package ac.za.tut.vehicle;

import ac.za.tut.driver.Driver;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-22T19:21:51")
=======
@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-15T21:44:56")
>>>>>>> dd3e0be14ccfb211898bb09058ab81dc8862e11c
@StaticMetamodel(Vehicle.class)
public class Vehicle_ { 

    public static volatile SingularAttribute<Vehicle, byte[]> license;
    public static volatile SingularAttribute<Vehicle, Driver> driver;
    public static volatile SingularAttribute<Vehicle, String> vin;
    public static volatile SingularAttribute<Vehicle, String> model;
    public static volatile SingularAttribute<Vehicle, Long> id;
    public static volatile SingularAttribute<Vehicle, String> numberPlate;
    public static volatile SingularAttribute<Vehicle, String> vehicleType;

}