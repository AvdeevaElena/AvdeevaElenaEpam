package SE10;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SQLConnection {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/actors";
    private static final String USER = "root";
    private static final String PASSWORD = "avd";

    private SQLConnection(){}

    private static SQLConnection instance;

    public static SQLConnection getInstance(){
        if (instance == null){
            instance = new SQLConnection();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName(DRIVER).newInstance()
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}