import java.sql.*;

public class DBConnection {
    Statement st;

    private static Connection getDBConnect() {
        String driver = "org.mariadb.jdbc.Driver";
        String userName = "base_user";
        String password = "base_pass";
        String url = "jdbc:mariadb://192.168.100.2:3306/check_list_sngisn";
        Connection dbConnect = null;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnect = DriverManager.getConnection(url, userName, password);
            return dbConnect;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnect;
    }

    public static ResultSet getdatabase(String sqlquery) {
        try {
            Connection dbConnection = getDBConnect();
            Statement stat = dbConnection.createStatement();
            ResultSet res = stat.executeQuery(sqlquery);
            return res;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
