package ac.za.tut.shipmenthandler;

import ac.za.tut.defaultdriver.DefaultDriver;
import ac.za.tut.driver.Driver;
import java.util.Date;
import javax.ejb.Local;


@Local
public interface ShipmentHandlerLocal {
    
    public String generateTrackingKey(String username);
    public String calcShipmentPrice(double weight,String type);
    public Driver getDriver();
    public DefaultDriver getCommunityDriver();
    public Date expectedToShipOn(Date creationDate);
    
}

