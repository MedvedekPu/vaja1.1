package Drugo;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.sql.*;
import java.util.UUID;

//public class Drugo.DBHelper {
  //  private static BasicDataSource dataSource;

   /* public static BigDecimal generateRandomBigDecimalFromRange(BigDecimal min, BigDecimal max) {
        BigDecimal randomBigDecimal = min.add(new BigDecimal(Math.random()).multiply(max.subtract(min)));
        return randomBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
    }*/

/*
    public static void comit() throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);
        try{
            PreparedStatement preparedStatement = null;
            XSSFWorkbook workbook = new XSSFWorkbook(new File("C:\\Users\\David Bajs\\IdeaProjects\\PJ_v1\\Grocery_UPC_Database.xlsx"));
            XSSFSheet sheet = workbook.getSheetAt(0);
            Row row;
            int counter = 0;

            for (int i=1; i<=sheet.getLastRowNum(); i++){
                if(counter < 1000) {
                    row = sheet.getRow(i);

                    UUID uuid = UUID.randomUUID();
                    ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
                    bb.putLong(uuid.getMostSignificantBits());
                    bb.putLong(uuid.getLeastSignificantBits());

                    String ime = row.getCell(4).getStringCellValue();
                    String barcode = row.getCell(1).getStringCellValue();
                    BigDecimal cena = generateRandomBigDecimalFromRange(new BigDecimal(0.00).setScale(2, BigDecimal.ROUND_HALF_UP), new BigDecimal(999.99).setScale(2, BigDecimal.ROUND_HALF_UP));
                    BigDecimal ddv = new BigDecimal(22.50).setScale(2, BigDecimal.ROUND_HALF_UP);
                    int zaloga = 1000;

                    Timestamp created = new Timestamp(System.currentTimeMillis());

                    preparedStatement = connection.prepareStatement("INSERT INTO Article (article_id, ime, barcode, cena, davcna_stopnja, zaloga, created) VALUES (?,?,?,?,?,?,?)");

                    preparedStatement.setBytes(1, bb.array());
                    preparedStatement.setString(2, ime);
                    preparedStatement.setString(3, barcode);
                    preparedStatement.setBigDecimal(4, cena);
                    preparedStatement.setBigDecimal(5, ddv);
                    preparedStatement.setInt(6, zaloga);
                    preparedStatement.setTimestamp(7, created);

                    preparedStatement.addBatch();
                    counter++;
                    System.out.println(i);
                }else{
                    preparedStatement.executeBatch();
                    connection.commit();
                    counter = 0;
                }
            }

            connection.commit();
            connection.setAutoCommit(true);

        } catch (SQLException|IOException|InvalidFormatException e) {
            connection.rollback();
            e.printStackTrace();
        }
    }*/


//}

public class DBHelper {
    private static BasicDataSource dataSource;



    public static BasicDataSource getDataSource()
    {

        if (dataSource == null)
        {
            BasicDataSource ds = new BasicDataSource();
            ds.setUrl("jdbc:mysql://localhost/mydb");
            ds.setUsername("root");
            ds.setPassword("root");



            ds.setMinIdle(5);
            ds.setMaxIdle(10);
            ds.setMaxOpenPreparedStatements(100);

            dataSource = ds;
        }
        return dataSource;
    }

    public static BigDecimal generateRandomBigDecimalFromRange(BigDecimal min, BigDecimal max) {
        BigDecimal randomBigDecimal = min.add(new BigDecimal(Math.random()).multiply(max.subtract(min)));
        return randomBigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP);
    }

    public static void comit() throws SQLException {
        try (BasicDataSource dataSource = DBHelper.getDataSource();
             Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM actor");)
        {
        connection.setAutoCommit(false);
        try{
            PreparedStatement preparedStatement = null;
            XSSFWorkbook workbook = new XSSFWorkbook(new File("C:\\Users\\aleks\\IdeaProjects\\vaja1.1\\Grocery_UPC_Database.xlsx"));
            XSSFSheet sheet = workbook.getSheetAt(0);
            Row row;
            int counter = 0;

            for (int i=1; i<=sheet.getLastRowNum(); i++){
                if(counter < 1000) {
                    row = sheet.getRow(i);

                    UUID uuid = UUID.randomUUID();
                    ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
                    bb.putLong(uuid.getMostSignificantBits());
                    bb.putLong(uuid.getLeastSignificantBits());

                    String name = row.getCell(4).getStringCellValue();
                    String barcode = row.getCell(1).getStringCellValue();
                    BigDecimal price = generateRandomBigDecimalFromRange(new BigDecimal(0.00).setScale(2, BigDecimal.ROUND_HALF_UP), new BigDecimal(999.99).setScale(2, BigDecimal.ROUND_HALF_UP));
                    BigDecimal vat = new BigDecimal(22.50).setScale(2, BigDecimal.ROUND_HALF_UP);
                    int stock = 1000;

                    Timestamp created = new Timestamp(System.currentTimeMillis());
                    Timestamp modified = new Timestamp(System.currentTimeMillis());
                    int deleted=0;

                    preparedStatement = connection.prepareStatement("INSERT INTO Article (idArticle, barcode, name, price, vat, stock, deleted,created,modified) VALUES (?,?,?,?,?,?,?,?,?)");

                    preparedStatement.setBytes(1, bb.array());
                    preparedStatement.setString(2, barcode);
                    preparedStatement.setString(3, name);
                    preparedStatement.setBigDecimal(4, price);
                    preparedStatement.setBigDecimal(5, vat);
                    preparedStatement.setInt(6, stock);
                    preparedStatement.setInt(7,deleted);
                    preparedStatement.setTimestamp(8,created);
                    preparedStatement.setTimestamp(9,modified);

                    preparedStatement.addBatch();
                    counter++;
                    System.out.println(i);
                }else{
                    preparedStatement.executeBatch();
                    connection.commit();
                    counter = 0;
                }
            }

            connection.commit();
            connection.setAutoCommit(true);

        } catch (SQLException|IOException|InvalidFormatException e) {
            connection.rollback();
            e.printStackTrace();
        }
        }
        catch (Exception e)
        {
            //connection.rollback();
            e.printStackTrace();
        }
    }
}
