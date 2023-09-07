package org.database;

import java.sql.*;

public class Main {
    public static void main(String[] args) {


        String URL = "jdbc:mysql://localhost: 3306/ Db_nations";
        String username = "root";
        String password= "";

        //query da eseguire
        String SQL = "SELECT countries.name AS country_name, country_id AS country_id, regions.name  AS regions_name, continents.name AS continents_name" +
        "FROM countries" +
        "JOIN regions ON countries.region_id = regions.region_id" +
        "JOIN continents ON regions.continent_id = continents.continent_id" +
        "ORDER BY countries.name" ;



        try (Connection connection = DriverManager.getConnection(URL, username, password)) {
            try (PreparedStatement ps = connection.prepareStatement(SQL)) {

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





