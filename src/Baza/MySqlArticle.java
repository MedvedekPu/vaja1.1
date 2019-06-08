package Baza;

import Baza.ArticleDao;
import Baza.Util;
import Drugo.Artikel;
import Drugo.DBHelper;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static javax.rmi.CORBA.Util.*;

public class MySqlArticle implements ArticleDao {
    final String TABLE_NAME = "Article";
    final String SQL_GET_BY_ID = "select * from " + TABLE_NAME + " where article_id = ? limit 1";
    final String SQL_GET_ALL = "select * from " + TABLE_NAME;
    final String SQL_INSERT = "insert into " + TABLE_NAME + "(article_id, barcode, name, price, vat, stock,deleted created, modified) values(?, ?, ?, ?, ?, ?,0, ?, ?)";
    final String SQL_DELETE = "delete from " + TABLE_NAME + " where article_id = ?";
    final String SQL_UPDATE = "update " + TABLE_NAME + " set barcode = ?, name = ?, price = ?, vat = ?, stock = ?, deleted=?,modified = ? where article_id = ?";
    @Override
    public Artikel getById(UUID id)
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
    public List<Artikel> getAll() {
        try
        {
            Connection conn = DBHelper.getDataSource().getConnection();
            PreparedStatement stat = conn.prepareStatement(SQL_GET_ALL);
            List<Artikel> artikli = new ArrayList<>();
            ResultSet rs = stat.executeQuery();
            while(rs.next())
            {
                artikli.add(extractFromResultSet(rs));
            }
            return artikli;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean insert(Artikel m)
    {
        try
        {
            Connection conn = DBHelper.getDataSource().getConnection();
            PreparedStatement stat = conn.prepareStatement(SQL_INSERT);
            stat.setBytes(1, Util.uuidToBinary(m.getId()));
            stat.setString(2, m.toS());
            stat.setString(3, m.getIme());
            stat.setBigDecimal(4, new BigDecimal(m.getCena()));
            stat.setBigDecimal(5, new BigDecimal(m.getDdv()));
            stat.setInt(6, m.getKolicina());
            stat.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            stat.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
            return stat.executeUpdate() > 0;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Artikel m) {
        try
        {
            Connection conn = DBHelper.getDataSource().getConnection();
            PreparedStatement stat = conn.prepareStatement(SQL_UPDATE);
            stat.setString(1, m.toS());
            stat.setString(2, m.getIme());
            stat.setBigDecimal(3, new BigDecimal(m.getCena()));
            stat.setBigDecimal(4, new BigDecimal(m.getDdv()));
            stat.setInt(5, m.getKolicina());
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
    public boolean delete(Artikel m) {
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
    public Artikel extractFromResultSet(ResultSet rs) throws SQLException {
        int cena = rs.getInt("cena");
        UUID id = Util.binaryToUuid(rs.getBytes("internal_article_id"));
        //String code = rs.getString("internal_id");
        String name = rs.getString("name");
        BigDecimal price = rs.getBigDecimal("price");
        BigDecimal vat = rs.getBigDecimal("vat");
        int stock = rs.getInt("stock");
        int teza= rs.getInt("teza");
        long[] EAN = new long[1];
        String ean = Arrays.toString(EAN);
        Double ddv = rs.getDouble("ddv");
        ean = rs.getString("EAN");
        return new Artikel(id,EAN,name,cena, ddv,stock);
    }
}
