package maBanque.controller;

import maBanque.dao.ICompteDAO;
import maBanque.dao.impl.CompteDAOImpl;
import maBanque.model.Compte;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name= "compteCtrl")
@SessionScoped
public class CompteController {
    ICompteDAO compteDAO = new CompteDAOImpl();

    public List<Compte> getAccountsByClientId(int clientId){
        List<Compte> accountList = compteDAO.getAccountsByClientId(clientId);
        return accountList;
    }

    public void virement(Compte sourceAccount, Compte destinationAccount, double montant){
        compteDAO.virement(sourceAccount, destinationAccount, montant);
    }

    public void lol(){
        System.out.println("lel");
    }

    public void debitCompte(Compte compte, double montant){
        compteDAO.debitCompte(compte, montant);
    }

    public void creditCompte(Compte compte, double montant){
        compteDAO.creditCompte(compte, montant);
    }
}
