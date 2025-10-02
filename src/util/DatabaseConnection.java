package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection conn;

    private static final String URL= "jdbc:mysql://localhost:3306/brief2_GPDA";
    private static final String USER= "mohsen";
    private static final String PASSWORD= "mohsen123";

    public static Connection getConnection(){
        if(conn==null){
            try{
                conn= DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("connexion réussie ");
            }catch(SQLException e){
                System.out.println("erreur de connexion : "+e.getMessage());
            }
        }
        return conn;
    }

}
