package ac.za.tut.bl;

import ac.za.tut.shipment.Shipment;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Stateless
public class ShipmentFacade extends AbstractFacade<Shipment> implements ShipmentFacadeLocal {

    @PersistenceContext(unitName = "ShipEasyWebAppEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ShipmentFacade() {
        super(Shipment.class);
    }

    @Override
    public List<Shipment> getShipmentByUserId(Long id) throws NoResultException {
       
        TypedQuery<Shipment> query = em.createQuery("SELECT s FROM Shipment s WHERE s.user.id = :id", Shipment.class);
        query.setParameter("id", id);
        
        List<Shipment> shipments = query.getResultList();
        
        return shipments;
        
    }
    @Override
    public List<Shipment> getShipmentByDriverId(Long driverId) throws NoResultException {
       
        TypedQuery<Shipment> query = em.createQuery("SELECT s FROM Shipment s WHERE s.assignedDriver.id = :id", Shipment.class);
        query.setParameter("id", driverId);
        
        List<Shipment> shipments = query.getResultList();
        
        return shipments;
        
    }

    @Override
    public Shipment findShipmentByTrackingCode(Long userId,String key) throws NoResultException{
      
        TypedQuery<Shipment> query = em.createQuery("SELECT s FROM Shipment s WHERE s.product.trackingCode = :key AND s.user.id = :userId",Shipment.class);
        query.setParameter("userId", userId);
        query.setParameter("key", key);
        
        try {
           Shipment shipment = query.getSingleResult();
        
              return shipment;
            
           } catch (NoResultException e) {
            
            return null;
        }
    }
}
