package maBanque.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;
    private String libelle;
    private double montant;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JsonIgnore
    List<Transaction> transactionEntities;

    @ManyToOne
    @JoinColumn(name="clientID")
    private Client client;


    //****GETTERS AND SETTERS****//
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Transaction> getTransactionEntities() {
        return transactionEntities;
    }

    public void setTransactionEntities(List<Transaction> transactionEntities) {
        this.transactionEntities = transactionEntities;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

}
