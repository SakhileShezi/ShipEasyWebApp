package ac.za.tut.driver;

import ac.za.tut.shipment.Shipment;
import ac.za.tut.vehicle.Vehicle;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-22T19:21:51")
=======
@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-15T21:44:56")
>>>>>>> dd3e0be14ccfb211898bb09058ab81dc8862e11c
@StaticMetamodel(Driver.class)
public class Driver_ { 

    public static volatile SingularAttribute<Driver, String> password;
    public static volatile SingularAttribute<Driver, String> surname;
    public static volatile SingularAttribute<Driver, String> fullNames;
    public static volatile SingularAttribute<Driver, Long> id;
    public static volatile ListAttribute<Driver, Shipment> shipments;
    public static volatile SingularAttribute<Driver, String> email;
    public static volatile SingularAttribute<Driver, String> cellNumber;
    public static volatile SingularAttribute<Driver, Vehicle> vehicle;

}