package maBanque.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class CompteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;
    private String libelle;
    private double montant;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JsonIgnore
    List<TransactionEntity> transactionEntities;

    @ManyToOne
    @JoinColumn(name="clientID")
    private ClientEntity clientEntity;


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

    public List<TransactionEntity> getTransactionEntities() {
        return transactionEntities;
    }

    public void setTransactionEntities(List<TransactionEntity> transactionEntities) {
        this.transactionEntities = transactionEntities;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

}
