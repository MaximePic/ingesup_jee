package maBanque.bean;

import maBanque.controller.CompteController;
import maBanque.model.Compte;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "compteBean")
@ViewScoped
public class CompteBean implements Serializable{



    public void setAccountList(List<Compte> accountList) {
        this.accountList = accountList;
    }

    private List<Compte> accountList;

    @ManagedProperty("#{compteCtrl}")
    private CompteController compteCtrl;

    @PostConstruct
    public void init(){
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession(false);
        int clientId = (int) session.getAttribute("clientId");
        accountList = compteCtrl.getAccountsByClientId(clientId);
    }

    public List<Compte> getAccountList() {
        return accountList;
    }

    public void setCompteCtrl(CompteController compteCtrl) {
        this.compteCtrl = compteCtrl;
    }


}
