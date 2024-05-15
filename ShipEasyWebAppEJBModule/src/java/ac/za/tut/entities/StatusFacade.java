package ac.za.tut.entities;

import ac.za.tut.status.Status;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class StatusFacade extends AbstractFacade<Status> implements StatusFacadeLocal {

    @PersistenceContext(unitName = "ShipEasyWebAppEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StatusFacade() {
        super(Status.class);
    }
    
}
