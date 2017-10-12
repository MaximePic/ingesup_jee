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


    @ManyToOne(optional = false)
    private Compte leCompte;



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

    public Compte getLeCompte() {
        return leCompte;
    }

    public void setLeCompte(Compte leCompte) {
        this.leCompte = leCompte;
    }

}
