package org.database;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {


        String URL = "jdbc:mysql://localhost: 3306/ Db_nations";
        String username = "root";
        String password;


        try (Connection connection = DriverManager.getConnection(URL, username, password)) {
            try (PreparedStatement ps = connection.createStatement()) {

                try (ResultSet rs = ps.executeQuery()) {
                    //itero
                    while (rs.next()) {
                        int id = rs.getInt("ID");
                        String countryname = rs.getString("nome nazione");
                        String regionname = rs.getString("nome regione");
                        String continentname = rs.getString("nome continente");

                        System.out.println(id);
                        System.out.println(countryname);
                        System.out.println(regionname);
                        System.out.println(continentname);
                    }
                }
            }

          }  catch (SQLException e) {
             System.out.println("c'è un errore");

        }
    }
}





