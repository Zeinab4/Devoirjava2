package services;

import java.util.List;

import enteties.Client;
import repositories.ClientRepository;

public class ClientService {
     ClientRepository clientRepository=new ClientRepository();
   
   public  List<Client>listerClient(){
    
        return clientRepository.selectAll();
    }
    public void ajouterClient(Client client){
        clientRepository.insert(client);
    }
  
    public  Client rechercherClientParTel(String tel){
        return clientRepository.selectClientByTel(tel);
    }
}
