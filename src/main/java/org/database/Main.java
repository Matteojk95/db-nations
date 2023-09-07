package org.database;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
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

            //chiedo all'utente di inserire una stringa
            System.out.println("inserisci una stringa");
            String stringadiricerca =  scan.nextLine() ;
            System.out.println("you choose" + stringadiricerca);
            String query = "SELECT countries.name AS country_name, country_id AS country_id, regions.name  AS regions_name, continents.name AS continents_name" +
                    "FROM countries" +
                    "JOIN regions ON countries.region_id = regions.region_id" +
                    "JOIN continents ON regions.continent_id = continents.continent_id" +
                    "ORDER BY countries.name" + "FROM countries where name like ?";
            try(PreparedStatement ps = connection.prepareStatement(query)){
                ps.setString(1,"%"+ stringadiricerca + "%");
            }




          }  catch (SQLException e) {
             System.out.println("c'è un errore");

        }
    }
}





