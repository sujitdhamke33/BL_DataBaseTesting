package Db_Test;

import org.testng.annotations.BeforeClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class dbTesting {
    Connection con ;

    @BeforeClass
    public Connection createConnection() throws SQLException {
        try{
            String url ="jdbc:mysql://localhost:3306/dbTesting";
            String username = "root";
            String password = "1122";
            con = DriverManager.getConnection(url,username,password);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return con;
    }
}
