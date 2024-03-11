
import java.sql.Connection;
import java.sql.DriverManager;

public class connection {

    public static Connection connectDangNhap() {

        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String serverName = "DESKTOP-PKBG0MG";
            String databaseName = "LoginQLNVJava";
            String username = "sa";
            String password = "230903";
            String url = "jdbc:sqlserver://" + serverName + ";databaseName=" + databaseName
                    + ";integratedSecurity=false;encrypt=true;trustServerCertificate=true";

            Connection sqlconnection = DriverManager.getConnection(url, username, password);
            return sqlconnection;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public static Connection connectQLNV() {
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String serverName = "DESKTOP-PKBG0MG";
            String databaseName = "QLNHANVIENJAVA";
            String username = "sa";
            String password = "230903";
            String url = "jdbc:sqlserver://" + serverName + ";databaseName=" + databaseName
                    + ";integratedSecurity=false;encrypt=true;trustServerCertificate=true";

            Connection sqlconnection = DriverManager.getConnection(url, username, password);
            return sqlconnection;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
