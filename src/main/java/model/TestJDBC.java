package model;
import dao.ClientDAO;

public class TestJDBC {
    public static void main(String[] args){

        //ClientDAO.loadClientById(1);
        ClientDAO.insertClient("Jimmy", "Leroy", "jimmy", "azerty");
        //ClientDAO.deleteClientById(2);
    }
}
