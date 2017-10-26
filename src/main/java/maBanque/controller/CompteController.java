package maBanque.controller;

import maBanque.bean.TransactionBean;
import maBanque.dao.ICompteDAO;
import maBanque.dao.ITransactionDAO;
import maBanque.dao.impl.CompteDAOImpl;
import maBanque.dao.impl.TransactionDAOImpl;
import maBanque.model.Compte;
import org.primefaces.component.selectonemenu.SelectOneMenu;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import java.util.List;

@ManagedBean(name= "compteCtrl")
@SessionScoped
public class CompteController {
    ICompteDAO compteDAO = new CompteDAOImpl();
    TransactionBean transactionBean = new TransactionBean();
    ITransactionDAO transactionDAO = new TransactionDAOImpl();

    public List<Compte> getAccountsByClientId(int clientId){
        List<Compte> accountList = compteDAO.getAccountsByClientId(clientId);
        return accountList;
    }


    /**
     * Virement entre 2 comptes
     * @param sourceAccountNum compte debiteur
     * @param destinationAccountNum compte crediteur
     * @param montant montant de la transaction
     */
    public void virement(String libelle, int sourceAccountNum, int destinationAccountNum, double montant){
        Compte sourceAccount = compteDAO.getAccountById(sourceAccountNum);
        Compte destinationAccount = compteDAO.getAccountById(destinationAccountNum);
        compteDAO.virement(sourceAccount, destinationAccount, montant);

        createTransaction(libelle, montant, sourceAccount, destinationAccount);
    }

    /**
     * Update du bean en fonction du selectOneMenu
     *
     * L'ideal est quand meme de update depuis la vue avec ajax, mais pb avec primefaces
     * @param event
     */
    public void updateCompteDebiteur(final AjaxBehaviorEvent event)  {
        SelectOneMenu compteDebiteur =  (SelectOneMenu) event.getSource();
        int numcompte = Integer.parseInt(compteDebiteur.getSubmittedValue().toString());
        transactionBean.setCompteDebiteur(numcompte);
    }

    /**
     * Update du bean en fonction du selectOneMenu
     *
     * L'ideal est quand meme de update depuis la vue avec ajax, mais pb avec primefaces
     * @param event
     */
    public void updateCompteCrediteur(final AjaxBehaviorEvent event)  {
        SelectOneMenu compteCrediteur =  (SelectOneMenu) event.getSource();
        int numcompte = Integer.parseInt(compteCrediteur.getSubmittedValue().toString());
        transactionBean.setCompteCrediteur(numcompte);
    }


    public void createTransaction(String libelle, double montant, Compte compteDebiteur, Compte compteCrediteur){
        transactionDAO.createTransaction(libelle, montant, compteDebiteur, compteCrediteur);
    }


    public ICompteDAO getCompteDAO() {
        return compteDAO;
    }

    public void setCompteDAO(ICompteDAO compteDAO) {
        this.compteDAO = compteDAO;
    }

    public TransactionBean getTransactionBean() {
        return transactionBean;
    }

    public void setTransactionBean(TransactionBean transactionBean) {
        this.transactionBean = transactionBean;
    }
}
