package ac.za.tut.bl;

import ac.za.tut.defaultdriver.DefaultDriver;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class DefaultDriverFacade extends AbstractFacade<DefaultDriver> implements DefaultDriverFacadeLocal {

    @PersistenceContext(unitName = "ShipEasyWebAppEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DefaultDriverFacade() {
        super(DefaultDriver.class);
    }
    
}
