package ac.za.tut.status;

import ac.za.tut.shipment.Shipment;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-22T19:21:51")
=======
@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-15T21:44:56")
>>>>>>> dd3e0be14ccfb211898bb09058ab81dc8862e11c
@StaticMetamodel(Status.class)
public class Status_ { 

    public static volatile SingularAttribute<Status, String> Status;
    public static volatile SingularAttribute<Status, Shipment> shipment;
    public static volatile SingularAttribute<Status, String> shippingMethod;
    public static volatile SingularAttribute<Status, String> transportationMode;
    public static volatile SingularAttribute<Status, Long> id;
    public static volatile SingularAttribute<Status, String> futureStatus;
    public static volatile SingularAttribute<Status, Date> deliveryDate;

}