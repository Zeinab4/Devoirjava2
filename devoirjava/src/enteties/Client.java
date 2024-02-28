package enteties;

import java.util.ArrayList;

public class Client {
    private int idClient;
    private String nomComplet;
    private String tel;
    private String email;

     ArrayList<Adresse> adresseList=new ArrayList<>();

    public ArrayList<Adresse> getAdresseList() {
        return adresseList;
    }
    public void setAdresseList(ArrayList<Adresse> adresseList) {
        this.adresseList = adresseList;
    }
    public Client() {
    }
    public int getIdClient() {
        return idClient;
    }
    public void setIdClient(int icClient) {
        this.idClient = icClient;
    }
    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
