package maBanque.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transacID;
    private String libelle;
    private Date date;


    @ManyToOne
    private Compte compteDebiteur;

    @ManyToOne
    private Compte compteCrediteur;

    private double montant;


    //****GETTERS AND SETTERS****//

    public int getTransacID() {
        return transacID;
    }

    public void setTransacID(int transacID) {
        this.transacID = transacID;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Compte getCompteDebiteur() {
        return compteDebiteur;
    }

    public void setCompteDebiteur(Compte compteDebiteur) {
        this.compteDebiteur = compteDebiteur;
    }

    public Compte getCompteCrediteur() {
        return compteCrediteur;
    }

    public void setCompteCrediteur(Compte compteCrediteur) {
        this.compteCrediteur = compteCrediteur;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

}
