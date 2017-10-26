package maBanque.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TransactionEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transacID;
    private String libelle;
    private Date date;


    @ManyToOne
    private CompteEntity compteEntityDebiteur;

    @ManyToOne
    private CompteEntity compteEntityCrediteur;

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

    public CompteEntity getCompteEntityDebiteur() {
        return compteEntityDebiteur;
    }

    public void setCompteEntityDebiteur(CompteEntity compteEntityDebiteur) {
        this.compteEntityDebiteur = compteEntityDebiteur;
    }

    public CompteEntity getCompteEntityCrediteur() {
        return compteEntityCrediteur;
    }

    public void setCompteEntityCrediteur(CompteEntity compteEntityCrediteur) {
        this.compteEntityCrediteur = compteEntityCrediteur;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

}
