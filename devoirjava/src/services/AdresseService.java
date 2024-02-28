package services;

import java.util.List;

import enteties.Adresse;
import repositories.AdresseRepository;
public class AdresseService {
    AdresseRepository adresseRepositories=new AdresseRepository();
    public void ajouterAdresse(Adresse adresse){
        adresseRepositories.insert(adresse);
    }

    public List<Adresse> listerAdresse(){
        return  adresseRepositories.selectAll();
    }
}