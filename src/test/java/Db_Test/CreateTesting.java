package Db_Test;

import org.testng.annotations.Test;

import java.sql.*;

public class CreateTesting extends dbTesting {
    Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;

@Test
    public void createTable() throws SQLException {
        connection = createConnection();
        statement = connection.createStatement();
        String query = "create table Testing1(\n" +
                "id int primary key,\n" +
                "name varchar(255) not null,\n" +
                "salary int ,\n" +
                "city varchar(255));";
        statement.executeUpdate(query);
    }

    @Test
    public void insertData() throws SQLException {
    connection = createConnection();
    String query = "insert into Testing1(id,name,salary,city)values(?,?,?,?)";
    preparedStatement = con.prepareStatement(query);
    preparedStatement.setInt(1,78);
    preparedStatement.setString(2,"Shubham");
    preparedStatement.setInt(3,40000);
    preparedStatement.setString(4,"Sangali");
    preparedStatement.executeUpdate();
    }

    @Test
    public void updateData() throws SQLException{
    connection = createConnection();
    String query = "update Testing1 set salary = ? where id = ?";
   preparedStatement = con.prepareStatement(query);
   preparedStatement.setInt(1,33333);
   preparedStatement.setInt(2,2);
   preparedStatement.executeUpdate();

    }

@Test
    public void getAll() throws SQLException{
    connection = createConnection();
    statement = connection.createStatement();
    String query = "select * from Testing1";
    ResultSet resultSet = statement.executeQuery(query);
    while(resultSet.next()){
        System.out.println("ID : " + resultSet.getInt(1)+ " NAME : " + resultSet.getString(2)+ " SALARY : "+ resultSet.getInt(3)+" City : "+ resultSet.getString(4));
    }
}

    @Test
    public void getDelete() throws SQLException{
        connection = createConnection();
        statement = connection.createStatement();
        String query = "delete from Testing1 where id = 2";
        int rowsAffected = statement.executeUpdate(query);
        System.out.println(rowsAffected + " row(s) deleted.");

    }
}
