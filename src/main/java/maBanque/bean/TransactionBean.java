package maBanque.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.Date;

@ManagedBean(name = "transactionBean")
@ViewScoped
public class TransactionBean {

    private String libelle;

    private Date date;

    private int compteDebiteur;

    private int compteCrediteur;

    private double montant;




    //****GETTERS AND SETTERS****//

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

    public int getCompteDebiteur() {
        return compteDebiteur;
    }

    public void setCompteDebiteur(int compteDebiteur) {
        this.compteDebiteur = compteDebiteur;
    }

    public int getCompteCrediteur() {
        return compteCrediteur;
    }

    public void setCompteCrediteur(int compteCrediteur) {
        this.compteCrediteur = compteCrediteur;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}
