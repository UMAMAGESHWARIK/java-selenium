package pkg_16082025;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static final String url = "jdbc:mysql://localhost:3306/java_selenium";
    private static final String user = "root";
    private static final String password = "mysql@Magesh63";

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }
}
