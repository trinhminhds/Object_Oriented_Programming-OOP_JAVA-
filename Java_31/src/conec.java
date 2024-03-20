import java.sql.Connection;
import java.sql.DriverManager;

public class conec {
    public static void main(String[] args) {
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String serverName = "DESKTOP-PKBG0MG";
            String databaseName = "qlnv";
            // String username = "sa";
            // String password = "230903";
            String url = "jdbc:sqlserver://" + serverName + ";databaseName=" + databaseName
                    + ";integratedSecurity=false;encrypt=true;trustServerCertificate=true";

            Connection sqlconnection = DriverManager.getConnection(url);

            System.out.println("kết nối thành công" + sqlconnection);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
