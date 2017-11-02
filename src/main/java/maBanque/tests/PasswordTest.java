package maBanque.tests;

import maBanque.dao.IClientDAO;
import maBanque.dao.impl.ClientDAOImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordTest {

    IClientDAO clientDAO = new ClientDAOImpl();
    //longueur

    /**
     * Test si le password fait plus de 8 characteres
     */
    @Test
    public final void shouldBeLongEnough(){
      //GIVEN
        int clientID = 1;
        String password = "abc";
      //WHEN
       boolean isPasswordChanged = clientDAO.changePassword(clientID, password);
      //THEN
        assertEquals(isPasswordChanged, false);
    }

    /**
     * Test si le password fait plus de 8 characteres
     */
    @Test
    public final void shouldHaveOneUppercaseLetter(){
        //GIVEN
        int clientID = 1;
        String password = "abcdefgh";
        //WHEN
        boolean isPasswordChanged = clientDAO.changePassword(clientID, password);
        //THEN
        assertEquals(isPasswordChanged, false);
    }

    /**
     * Test si le password fait plus de 8 characteres
     */
    @Test
    public final void shouldHaveOneNumber(){
        //GIVEN
        int clientID = 1;
        String password = "abcdefGh";
        //WHEN
        boolean isPasswordChanged = clientDAO.changePassword(clientID, password);
        //THEN
        assertEquals(isPasswordChanged, false);
    }

    /**
     * Test si le password fait plus de 8 characteres
     */
    @Test
    public final void isCorrect(){
        //GIVEN
        int clientID = 1;
        String password = "abcdefG1";
        //WHEN
        boolean isPasswordChanged = clientDAO.changePassword(clientID, password);
        //THEN
        assertEquals(isPasswordChanged, true);
    }
}
