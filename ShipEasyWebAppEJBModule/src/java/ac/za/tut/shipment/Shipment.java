package ac.za.tut.shipment;

import ac.za.tut.defaultdriver.DefaultDriver;
import ac.za.tut.driver.Driver;
import ac.za.tut.product.Product;
import ac.za.tut.status.Status;
import ac.za.tut.user.User;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SHIPMENT_TBL")
public class Shipment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "SHIP_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PICK_UP_POINT", nullable = false, length = 30)
    private String pickLocation;

    @Column(name = "DESTINATION", nullable = false, length = 30)
    private String destination;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToOne(mappedBy = "shipment",cascade = CascadeType.ALL)
    private Product product;
    
    @OneToOne(mappedBy = "shipment",cascade = CascadeType.ALL)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "DRIVER_ID")
    private Driver assignedDriver;
    
    @ManyToOne
    @JoinColumn(name = "COM_DRIVER_ID")
    private DefaultDriver assignDefault;
    
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    public Shipment() {
    }

    public Shipment(String pickLocation, String destination, Date creationDate) {
        this.pickLocation = pickLocation;
        this.destination = destination;
        this.creationDate = creationDate;
    }

    public Shipment(User user, Product product,Driver assignedDriver,Status status,DefaultDriver assignDefault) {
        this.user = user;
        this.product = product;
        this.assignedDriver = assignedDriver;
        this.assignDefault = assignDefault;
        this.status = status;
    }

    public Driver getAssignedDriver() {
        return assignedDriver;
    }
    
    public void setAssignedDriver(Driver assignedDriver) {
        this.assignedDriver = assignedDriver;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    

    public DefaultDriver getAssignDefault() {
        return assignDefault;
    }

    public void setAssignDefault(DefaultDriver assignDefault) {
        this.assignDefault = assignDefault;
    }
    
    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getPickLocation() {
        return pickLocation;
    }

    public void setPickLocation(String pickLocation) {
        this.pickLocation = pickLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
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
        if (!(object instanceof Shipment)) {
            return false;
        }
        Shipment other = (Shipment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ac.za.tut.shipping.Shipping[ id=" + id + " ]";
    }

}
