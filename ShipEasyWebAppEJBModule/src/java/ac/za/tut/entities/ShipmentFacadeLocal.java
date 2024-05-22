package ac.za.tut.entities;

import ac.za.tut.shipment.Shipment;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.NoResultException;

@Local
public interface ShipmentFacadeLocal {

    void create(Shipment shipping);

    void edit(Shipment shipping);

    void remove(Shipment shipping);

    Shipment find(Object id)throws NoResultException;
    
    Shipment findShipmentByTrackingCode(Long userId,String trackingKey);
    
    List<Shipment> getShipmentByUserId(Long userId)throws NoResultException;

    List<Shipment> getShipmentByDriverId(Long driverId)throws NoResultException;
    
    List<Shipment> findAll();

    List<Shipment> findRange(int[] range);

    int count();
    
}
