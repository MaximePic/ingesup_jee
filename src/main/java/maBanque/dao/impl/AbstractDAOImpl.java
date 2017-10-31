package maBanque.dao.impl;


import maBanque.dao.IAbstractDAO;
import maBanque.servlet.ServletHelper;

import javax.faces.context.FacesContext;
import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static maBanque.constants.Constants.PERSISTENCE_UNIT_NAME;

public class AbstractDAOImpl implements IAbstractDAO {

    private static EntityManagerFactory factory = null;

    private static EntityManager em;


    /**
     * Méthode permettant d'ouvrir une connexion
     * @return em
     */
    @Override
    public EntityManager newConnexion(){
        factory = createFactory();
        if(em == null){
            EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();
            return em;
        }

        return em;
    }

    /**
     * Méthode permettant de fermer une connexion
     */
    @Override
    public void closeConnexion(EntityManager em) {
        if (em != null) {
            if (em.isOpen()) {
                EntityTransaction t = em.getTransaction();
                if (t.isActive()) {
                    try {
                        t.rollback();
                    } catch (PersistenceException e) {
                    }
                }
                em.close();
            }
        }
    }

    /**
     * Create factory
     * @return
     */
    private static EntityManagerFactory createFactory(){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }

    /**
     * LogoutServlet
     * @param request
     * @param response
     */
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response){
        try {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect(request.getContextPath() + ServletHelper.SERVLET_LOGIN);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Retourne le dernier paramètre de l'uri en entier
     * @param request
     * @return
     */
    @Override
    public int getLastUriParameter(HttpServletRequest request){
        String path = request.getRequestURI();
        String idStr = path.substring(path.lastIndexOf('/') + 1);
        return Integer.parseInt(idStr);
    }


}
