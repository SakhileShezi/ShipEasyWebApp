package ac.za.tut.product;

import ac.za.tut.shipment.Shipment;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-22T19:21:51")
=======
@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-15T21:44:56")
>>>>>>> dd3e0be14ccfb211898bb09058ab81dc8862e11c
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Shipment> shipment;
    public static volatile SingularAttribute<Product, Double> price;
    public static volatile SingularAttribute<Product, Double> weight;
    public static volatile SingularAttribute<Product, String> trackingCode;
    public static volatile SingularAttribute<Product, Long> id;
    public static volatile SingularAttribute<Product, String> type;

}