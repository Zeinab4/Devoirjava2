package repositories;
import enteties.Adresse;
import enteties.Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdresseRepository {
     public  void insert(Adresse adresse){
     try {
          Class.forName("com.mysql.cj.jdbc.Driver");
         
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/devoirjava" 
                    , "root", "");
            
             Statement statement = conn.createStatement();
            
             int nbreLigne=statement.executeUpdate("INSERT INTO agence (ville, quartier, numVilla) VALUES ('"+adresse.getVille()+"', '"+adresse.getQuartier()+"', '"+adresse.getNumVilla()+"')");
             conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement de Driver");
        }
       catch (SQLException e) {
          System.out.println("Erreur de Connexion a la BD");
      }
     }

     public List<Adresse> selectAll(){
         List<Adresse> adresses=new ArrayList<>();
          try {
    
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/devoirjava" 
                   , "root", "");
             Statement statement = conn.createStatement();
             String sql="SELECT * FROM `adresse` a, client cl where a.idClient=cl.idClient;";
             ResultSet rs=statement.executeQuery(sql);
            while (rs.next()) {
              
                Client client=new Client();
                client.setIdClient(rs.getInt("idClient"));
                client.setNomComplet(rs.getString("nomComplet"));
                client.setTel(rs.getString("telephone"));
                client.setEmail(rs.getString("email"));

                 Adresse ad=new Adresse();
                 ad.setId(rs.getInt("id-adresse"));
                 ad.setVille(rs.getString("ville"));
                 ad.setQuartier(rs.getString("quartier"));
                 ad.setNumVilla(rs.getString("numVilla"));
                
    
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
       return  adresses;
      }
}
