import org.apache.commons.dbcp2.BasicDataSource;

public class DBHelper {
    private static BasicDataSource dataSource;

    public static BasicDataSource getDataSource()
    {

        if (dataSource == null)
        {
            BasicDataSource ds = new BasicDataSource();
            ds.setUrl("jdbc:mysql://localhost/sakila?useSSL=false&useUnicode=true&useJDBCCompliantTimeZoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&SSL=false");
            ds.setUsername("root");
            ds.setPassword("root");



            ds.setMinIdle(5);
            ds.setMaxIdle(10);
            ds.setMaxOpenPreparedStatements(100);

            dataSource = ds;
        }
        return dataSource;
    }
}
