package ac.za.tut.shipment;

import ac.za.tut.defaultdriver.DefaultDriver;
import ac.za.tut.driver.Driver;
import ac.za.tut.product.Product;
import ac.za.tut.status.Status;
import ac.za.tut.user.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-22T19:21:51")
@StaticMetamodel(Shipment.class)
public class Shipment_ { 

    public static volatile SingularAttribute<Shipment, Product> product;
    public static volatile SingularAttribute<Shipment, String> pickLocation;
    public static volatile SingularAttribute<Shipment, DefaultDriver> assignDefault;
    public static volatile SingularAttribute<Shipment, String> destination;
    public static volatile SingularAttribute<Shipment, Long> id;
    public static volatile SingularAttribute<Shipment, Date> creationDate;
    public static volatile SingularAttribute<Shipment, User> user;
    public static volatile SingularAttribute<Shipment, Driver> assignedDriver;
    public static volatile SingularAttribute<Shipment, Status> status;

}