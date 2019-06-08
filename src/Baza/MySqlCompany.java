package Baza;

import Drugo.DBHelper;
import Drugo.Podjetje;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MySqlCompany implements CompanyDao {

    final String TABLE_NAME = "Company";
    final String SQL_GET_BY_ID = "select * from " + TABLE_NAME + " where idCompany = ? limit 1";
    final String SQL_GET_ALL = "select * from " + TABLE_NAME;
    final String SQL_INSERT = "insert into " + TABLE_NAME + "(idCompany, name, tax_number, registration_number, phone_number, taxpayer, address,deleted, created, modified) values(?, ?, ?, ?, ?, ?, ?,0,?, ?)";
    final String SQL_DELETE = "delete from " + TABLE_NAME + " where idCompany = ?";
    final String SQL_UPDATE = "update " + TABLE_NAME + " set name = ?, tax_number = ?, registration_number = ?, phone_number = ? taxpayer = ?, address = ?, deleted=0,modified = ? where idCompany = ?" ;
    @Override
    public Podjetje getById(UUID id)
    {
        try
        {
            Connection conn = DBHelper.getDataSource().getConnection();
            PreparedStatement stat = conn.prepareStatement(SQL_GET_BY_ID);
            stat.setBytes(1, Util.uuidToBinary(id));
            ResultSet rs = stat.executeQuery();
            if(rs.first())
            {
                return extractFromResultSet(rs);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Podjetje> getAll() {
        try
        {
            Connection conn = DBHelper.getDataSource().getConnection();
            PreparedStatement stat = conn.prepareStatement(SQL_GET_ALL);
            List<Podjetje> podjetja = new ArrayList<>();
            ResultSet rs = stat.executeQuery();
            while(rs.next())
            {
                podjetja.add(extractFromResultSet(rs));
            }
            return podjetja;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean insert(Podjetje m)
    {
        try
        {
            Connection conn = DBHelper.getDataSource().getConnection();
            PreparedStatement stat = conn.prepareStatement(SQL_INSERT);
            stat.setBytes(1, Util.uuidToBinary(m.getId()));
            stat.setString(2, m.getIme());
            stat.setDouble(3, m.getDavcna());
            stat.setLong(4, m.getMaticna());
            stat.setString(5, m.getTelefon());
            stat.setBoolean(6, m.isZavezanec());
            stat.setString(7, m.getTelefon());
            stat.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
            stat.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
            return stat.executeUpdate() > 0;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Podjetje m) {
        try
        {
            Connection conn = DBHelper.getDataSource().getConnection();
            PreparedStatement stat = conn.prepareStatement(SQL_UPDATE);
            stat.setString(1, m.getIme());
            stat.setDouble(2, m.getDavcna());
            stat.setLong(3, m.getMaticna());
            stat.setString(4, m.getTelefon());
            stat.setBoolean(5, m.isZavezanec());
            stat.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            stat.setBytes(7, Util.uuidToBinary(m.getId()));
            return stat.executeUpdate() > 0;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Podjetje m) {
        try
        {
            Connection conn = DBHelper.getDataSource().getConnection();
            PreparedStatement stat = conn.prepareStatement(SQL_DELETE);
            stat.setBytes(1, Util.uuidToBinary(m.getId()));
            return stat.executeUpdate() > 0;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Podjetje extractFromResultSet(ResultSet rs) throws SQLException {
        UUID id = Util.binaryToUuid(rs.getBytes("idCompany"));
        int tax_n = rs.getInt("tax_number");
        long mat_n = rs.getLong("registration_number");
        String name = rs.getString("name");
        Boolean isTaxPayer = rs.getBoolean("taxpayer");
        String phone = rs.getString("phone");
        String naslov =rs.getString("adress");
        return new Podjetje(id, name, tax_n, mat_n,phone, isTaxPayer,naslov);
    }
}
