package ac.za.tut.bl;

import ac.za.tut.address.Address;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Stateless
public class AddressFacade extends AbstractFacade<Address> implements AddressFacadeLocal {

    @PersistenceContext(unitName = "ShipEasyWebAppEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AddressFacade() {
        super(Address.class);
    }

    @Override
    public Address findByUserId(Long userId) {
      
        TypedQuery<Address> query = em.createQuery("SELECT a FROM Address a WHERE a.user.id = :userId",Address.class);
        query.setParameter("userId", userId);
        
        try {
            return query.getSingleResult();
          } catch (NoResultException e) {
            
        return null;
        }
    }
    
}
