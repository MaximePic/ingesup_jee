package maBanque.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clientID;
    private String nom;
    private String prenom;
    private String password;
    @Column(unique=true)
    private String login;


    @OneToMany(mappedBy="client", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Compte> compteEntities;

    public Client(){

    }

    //****GETTERS AND SETTERS****//

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public List<Compte> getCompteEntities() {
        return compteEntities;
    }

    public void setCompteEntities(List<Compte> compteEntities) {
        this.compteEntities = compteEntities;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
