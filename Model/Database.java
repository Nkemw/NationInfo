package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    private static Database instance = new Database(); //Singleton Pattern
    private String server_ip;
    private String db_name;
    private String user_id;
    private String passwd;
    private Connection con;

    private Database() {
        server_ip = "localhost";
        db_name = "contacts";
        user_id = "root";
        passwd = "kmw0522";
        con = connectDB(server_ip, db_name, user_id, passwd);
    }

    public static Database getInstance() {
        return instance;
    }

    private static Connection connectDB(String ip, String db, String id, String pswd) {
        Connection con = null;
        String url = "jdbc:mysql://" + ip + "/" + db + "?characterEncoding=UTF-8&serverTimezone=UTC";

        // JDBC
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Load JDBC Driver Failed: " + e.getMessage());
            e.printStackTrace();
        }

        //
        try {
            con = DriverManager.getConnection(url, id, pswd);
            System.out.println("Database Connection Executed: ");
            System.out.println("\tserver_ip = " + ip + "\n\tdb_name = " + db);
        } catch(SQLException e) {
            System.err.println("Database Connection Failed: " + e.getMessage());
            e.printStackTrace();
        }

        return con;
    }

    public ResultSet executeSql(String sql) throws SQLException {
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }
}
