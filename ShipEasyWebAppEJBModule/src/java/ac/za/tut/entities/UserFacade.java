package ac.za.tut.entities;

import ac.za.tut.user.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Stateless
public class UserFacade extends AbstractFacade<User> implements UserFacadeLocal {

    @PersistenceContext(unitName = "ShipEasyWebAppEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
     @Override
    public User findByEmail(String email) {
        
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE  u.email = :email", User.class);
        query.setParameter("email", email);
        
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
