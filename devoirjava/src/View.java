import java.util.List;
import java.util.Scanner;

import enteties.Adresse;
import enteties.Client;
import services.AdresseService;
import services.ClientService;

public class View {
    public static void main(String[] args) throws Exception {
        int choix;
        Scanner sc=new Scanner(System.in);
        //Dependances
        AdresseService adresseService=new AdresseService();
        ClientService clientService=new ClientService();

        do {
            System.out.println("1-Créer un Client");
            System.out.println("2-Lister les Clients"); 
            System.out.println("3-Ajouter une adresse et lui associe un client"); 
            System.out.println("4-Lister les adresse en affichant le nom du client");
            System.out.println("5-Quitter");  
             choix=sc.nextInt();
             sc.nextLine();
            switch (choix) {
                case 1:
                     System.out.println("Entrer le Telephone");
                     String tel=sc.nextLine(); 
                     Client client=  clientService.rechercherClientParTel(tel);
                     if (client!=null) {
                          System.out.println("Ce numero de Telephone existe deja");
                     } else {
                         System.out.println("Entrer le nom complet");
                         String nomComplet=sc.nextLine(); 
                         System.out.println("Entrer son email");
                         String email=sc.nextLine(); 
                         client=new Client();
                         client.setNomComplet(nomComplet);
                         client.setTel(tel);
                         client.setEmail(email);
                         clientService.ajouterClient(client);
                     }
                   break;
                    case 2:
                   List<Client>  clients= clientService.listerClient();
                   for (Client cl: clients) {
                     System.out.println("Nom complet "+ cl.getNomComplet());
                     System.out.println("Email "+ cl.getEmail());
                     System.out.println("Tel "+cl.getTel() );
                     System.out.println("***********************");
               }
                    break;
                    case 3:
                    System.out.println("Entrer une ville ");
                    String ville=sc.nextLine(); 
                    System.out.println("Entrer une quartier");
                    String quartier=sc.nextLine();
                    System.out.println("Entrer le numero de la villa"); 
                    String numVilla=sc.nextLine();
                    int type=sc.nextInt();
                    sc.nextLine();
                     System.out.println("Entrer le Telephone du client");
                     tel=sc.nextLine(); 
                      Client cl = clientService.rechercherClientParTel(tel);
                        if (cl==null) {
                            System.out.println("Entrer NomComplet");
                            String nomComplet=sc.nextLine(); 
                            System.out.println("Entrer un Telephone");
                             tel=sc.nextLine();  
                            System.out.println("Entrer un mail");
                            String mail=sc.nextLine();
                            Client clie=new Client();
                          cl.setNomComplet(nomComplet);
                          cl.setTel(tel);
                          cl.setEmail(mail);
                         clientService.ajouterClient(cl);
                        }
                        break;
                        case 4:
                    List<Adresse> adresse= adresseService.listerAdresse();
                    for (Adresse adr: adresse) {
                         System.out.println("Ville :"+ adr.getVille());
                         System.out.println("Quartier :"+ adr.getQuartier());
                         System.out.println("NumVilla :"+ adr.getNumVilla());
                         System.out.println("Client :"+ adr.getClient().getNomComplet()+" "+adr.getClient().getTel());
                         System.out.println("====================================================================");
                    }
                   break;
                default:
                    break;
            }
        }while (choix!=5);
    }
}
