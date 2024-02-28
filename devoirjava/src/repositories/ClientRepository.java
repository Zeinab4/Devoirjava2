package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import enteties.Client;

public class ClientRepository {
    public void insert(Client client){
           try {
      
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/devoirjava" 
                      , "root", "");
              Statement statement = conn.createStatement();
              
              String sql=String.format("INSERT INTO `client` (`id_client` , `nomComplet`, `tel` ,`email` ) "
                        + " VALUES ('%s', '%s', '%s')",
                        client.getIdClient(), client.getNomComplet(),client.getTel(), client.getEmail());
              int nbreLigne=statement.executeUpdate(sql);
        
              statement.close();
              conn.close();
          } catch (ClassNotFoundException e) {
              System.out.println("Erreur de chargement de Driver");
          }
        catch (SQLException e) {
            System.out.println("Erreur de Connexion a la BD");
        }
    }

     public List<Client> selectAll(){
         List<Client> clients=new ArrayList<>();
        try {
    
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/devoirjava" 
                   , "root", "");
           Statement statement = conn.createStatement();
           String sql="Select * from client";
           ResultSet rs=statement.executeQuery(sql);
            while (rs.next()) {
                Client client=new Client();
                client.setIdClient(rs.getInt("id_client"));
                client.setNomComplet(rs.getString("nomComplet"));
                client.setEmail(rs.getString("email"));
                client.setTel(rs.getString("tel"));
                clients.add(client);
            }
            statement.close();
            rs.close();
            conn.close();
       } catch (ClassNotFoundException e) {
           System.out.println("Erreur de chargement de Driver");
       }
       catch (SQLException e) {
         System.out.println("Erreur de Connexion a la BD");
       }
       return clients;
     }

     public Client selectClientByTel(String tel){
        Client client=null;
        try {
    
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/devoirjava" 
                   , "root", "");
           Statement statement = conn.createStatement();
           String sql=String.format("Select * from client where tel like '%s' ",tel);
           ResultSet rs=statement.executeQuery(sql);
            if (rs.next()) {
                client=new Client();
                client.setIdClient(rs.getInt("idClientt"));
                client.setNomComplet(rs.getString("nomComplet"));
                client.setEmail(rs.getString("email"));
                client.setTel(rs.getString("tel"));
            }
            statement.close();
            rs.close();
            conn.close();
       } catch (ClassNotFoundException e) {
           System.out.println("Erreur de chargement de Driver");
       }
       catch (SQLException e) {
         System.out.println("Erreur de Connexion a la BD");
       }
           return client;
      }
}
