package ru.eltex.practice.MySQL;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.*;

public class ControllerMySQL {

    private final String USERNAME = "root";
    private final String PASSWORD = "22105q";
    //с установкой временного пояса
    private final String URL = "jdbc:mysql://localhost:3306/data?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";

    public void dataBase(){

        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement()){

            ResultSet resultSet = statement.executeQuery("select * from users");

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String fio = resultSet.getString("fio");
                int number = resultSet.getInt("number");

                System.out.println("___________________________________________");
                System.out.println("id: " + id);
                System.out.println("fio: " + fio);
                System.out.println("number: " + number);
            }

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}