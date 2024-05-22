package ac.za.tut.address;

import ac.za.tut.vehicle.Vehicle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class VehicleFacade extends AbstractFacade<Vehicle> implements VehicleFacadeLocal {

    @PersistenceContext(unitName = "ShipEasyWebAppEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehicleFacade() {
        super(Vehicle.class);
    }
    
}
