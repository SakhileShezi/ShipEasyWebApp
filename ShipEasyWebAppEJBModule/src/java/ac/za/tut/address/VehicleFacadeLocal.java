/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ac.za.tut.address;

import ac.za.tut.vehicle.Vehicle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Shezi
 */
@Local
public interface VehicleFacadeLocal {

    void create(Vehicle vehicle);

    void edit(Vehicle vehicle);

    void remove(Vehicle vehicle);

    Vehicle find(Object id);

    List<Vehicle> findAll();

    List<Vehicle> findRange(int[] range);

    int count();
    
}
