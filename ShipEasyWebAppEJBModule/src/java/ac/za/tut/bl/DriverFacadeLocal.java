/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ac.za.tut.bl;

import ac.za.tut.driver.Driver;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Shezi
 */
@Local
public interface DriverFacadeLocal {

    void create(Driver driver);

    void edit(Driver driver);

    void remove(Driver driver);

    Driver find(Object id);
    Driver findByShipment(Long shipmentId);

    List<Driver> findAll();

    List<Driver> findRange(int[] range);

    int count();
    
    Driver findDriverByEmail(String email);
    
}
