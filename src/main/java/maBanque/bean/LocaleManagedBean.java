package maBanque.bean;

import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Locale;

@ManagedBean(name = "localeManagedBean")
@SessionScoped
public class LocaleManagedBean implements Serializable {

    /**
     * Locale courante
     */
    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();


    /**
     * Permet d'obtenir la locale courante
     * @return
     */
    public Locale getLocale() {
        return locale;
    }

    public String getLanguage() {
        return locale.getLanguage();
    }

    public void changeLanguage(String language) {
        locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(language));
    }

}