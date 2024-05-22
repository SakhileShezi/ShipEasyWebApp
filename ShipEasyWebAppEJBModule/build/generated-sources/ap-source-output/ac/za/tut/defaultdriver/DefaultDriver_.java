package ac.za.tut.defaultdriver;

import ac.za.tut.shipment.Shipment;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-22T19:21:51")
=======
@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-15T21:44:56")
>>>>>>> dd3e0be14ccfb211898bb09058ab81dc8862e11c
@StaticMetamodel(DefaultDriver.class)
public class DefaultDriver_ { 

    public static volatile SingularAttribute<DefaultDriver, String> ratings;
    public static volatile SingularAttribute<DefaultDriver, String> companyName;
    public static volatile SingularAttribute<DefaultDriver, String> contactNumber;
    public static volatile SingularAttribute<DefaultDriver, Long> id;
    public static volatile SingularAttribute<DefaultDriver, String> slogan;
    public static volatile ListAttribute<DefaultDriver, Shipment> shipments;
    public static volatile SingularAttribute<DefaultDriver, String> email;

}