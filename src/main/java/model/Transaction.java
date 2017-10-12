package model;

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

    public Compte getComptes() {
        return leCompte;
    }

    public void setComptes(Compte comptes) {
        this.leCompte = leCompte;
    }
}
