package ac.za.tut.status;

import ac.za.tut.shipment.Shipment;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "SHIPMENT_STATUS")
public class Status implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "TRANSPORTATION",nullable = false,length = 30)
    private String transportationMode;
    @Column(name = "SHIPPING_METHOD",nullable = false,length = 30)
    private String shippingMethod;
    @Column(name = "STATUS",nullable = false,length = 30)
    private String Status;
    @Column(name = "UPCOMING_STATUS",nullable = false,length = 30)
    private String futureStatus;
    
    @Column(name = "DELIVERY_DATE",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;
    
    @OneToOne
    @JoinColumn(name = "SHIPMENT_ID")
    private Shipment shipment;
    
    public Status() {
    }

    public Status(String transportationMode, String shippingMethod, String Status, String futureStatus,Date deliveryDate) {
        this.transportationMode = transportationMode;
        this.shippingMethod = shippingMethod;
        this.Status = Status;
        this.futureStatus = futureStatus;
        this.deliveryDate = deliveryDate;
    }

    public Status(Shipment shipment) {
        this.shipment = shipment;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    
    public String getTransportationMode() {
        return transportationMode;
    }

    public void setTransportationMode(String transportationMode) {
        this.transportationMode = transportationMode;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getFutureStatus() {
        return futureStatus;
    }

    public void setFutureStatus(String futureStatus) {
        this.futureStatus = futureStatus;
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
        if (!(object instanceof Status)) {
            return false;
        }
        Status other = (Status) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ac.za.tut.status.Status[ id=" + id + " ]";
    }
    
}
