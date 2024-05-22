package ac.za.tut.bl;

import ac.za.tut.user.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    @Override
    public void removeUserAddress(Long user_id) {
       
        Query query = em.createQuery("DELETE FROM Address a WHERE a.user.id = :user_id");
        query.setParameter("user_id", user_id);
        query.executeUpdate();
        
    }

    @Override
    public void removeUserShipment(Long user_id) {
        Query query = em.createQuery("DELETE FROM Shipment s WHERE s.user.id = :user_id");
        query.setParameter("user_id", user_id);
        query.executeUpdate();
    }

    @Override
    public void removeUserShipmentProduct(Long user_id) {
        Query query = em.createQuery("DELETE FROM Product d WHERE d.shipment.user.id = :user_id");
        query.setParameter("user_id", user_id);
        query.executeUpdate();
    }

    @Override
    public void removeUserShipmentStatus(Long user_id) {
        Query query = em.createQuery("DELETE FROM Status s WHERE s.shipment.user.id = :user_id");
        query.setParameter("user_id", user_id);
        query.executeUpdate();
    }
}
