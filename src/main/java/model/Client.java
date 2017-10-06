package model;

public class Client {
    private int clientID;
    private String nom;
    private String prenom;
    private String password;
    private String login;

    public String toString(){
        return "ID: "+ clientID + System.getProperty("line.separator")
                +"Nom: "+ nom + System.getProperty("line.separator")
                +"Prenom: " + prenom + System.getProperty("line.separator")
                +"Login: " + login;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }
}
