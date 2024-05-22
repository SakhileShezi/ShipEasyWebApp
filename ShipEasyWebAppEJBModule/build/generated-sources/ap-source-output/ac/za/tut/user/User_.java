package ac.za.tut.user;

import ac.za.tut.address.Address;
import ac.za.tut.shipment.Shipment;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-22T19:21:51")
=======
@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-15T21:44:56")
>>>>>>> dd3e0be14ccfb211898bb09058ab81dc8862e11c
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> phoneNumber;
    public static volatile SingularAttribute<User, Address> address;
    public static volatile SingularAttribute<User, Character> gender;
    public static volatile SingularAttribute<User, String> surname;
    public static volatile SingularAttribute<User, String> dob;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, Long> id;
    public static volatile SingularAttribute<User, Date> creationDate;
    public static volatile ListAttribute<User, Shipment> shipments;
    public static volatile SingularAttribute<User, String> email;

}