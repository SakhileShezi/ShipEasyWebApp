package ac.za.tut.product;

import ac.za.tut.shipment.Shipment;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SHIPMENT_DETAILS_TBL")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PRODUCT_TYPE", nullable = false, length = 15)
    private String type;
    @Column(name = "PRICE",nullable = false)
    private Double price;
    @Column(name = "PRODUCT_WEIGHT",nullable = false)
    private Double weight;
    @Column(name = "TRACKING_KEY", nullable = false, length = 30)
    private String trackingCode;

    @OneToOne()
    @JoinColumn(name = "SHIPMENT_ID")
    private Shipment shipment;
    
    public Product() {
    }

    public Product(String type, Double price, Double weight,String trackingCode) {
        this.type = type;
        this.price = price;
        this.weight = weight;
        this.trackingCode = trackingCode;
    }

    public Product(Shipment shipment) {
        this.shipment = shipment;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ac.za.tut.product.Product[ id=" + id + " ]";
    }

}
