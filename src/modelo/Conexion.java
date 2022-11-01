
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

 
public class Conexion {
    //private final String db = "producto";
    private final String user = "root";
    private final String password = "root";
    private final String url = "jdbc:mysql://localhost/registry_javaproject2";
    Connection con = null;
    
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection)DriverManager.getConnection(this.url, this.user, this.password);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
