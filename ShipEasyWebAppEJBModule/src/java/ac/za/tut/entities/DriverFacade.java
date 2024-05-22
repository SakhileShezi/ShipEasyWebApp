package ac.za.tut.entities;

import ac.za.tut.driver.Driver;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class DriverFacade extends AbstractFacade<Driver> implements DriverFacadeLocal {

    @PersistenceContext(unitName = "ShipEasyWebAppEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DriverFacade() {
        super(Driver.class);
    }

    @Override
    public Driver findDriverByEmail(String email) {
        
        TypedQuery<Driver> query = em.createQuery("SELECT d FROM Driver d WHERE d.email = :email",Driver.class);
        
        query.setParameter("email", email);
        
        try {
            
        return query.getSingleResult();
        
        } catch (NoResultException e) {
       
            return null;
        }
        
    }
    
}
