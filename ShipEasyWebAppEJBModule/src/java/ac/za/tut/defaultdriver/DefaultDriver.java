package ac.za.tut.defaultdriver;

import ac.za.tut.shipment.Shipment;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DRIVER_COMMUNITY")
public class DefaultDriver implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "COMPANY_NAME",nullable = false,length = 50)
    private String companyName;
    @Column(name = "SLOGAN",nullable = false,length = 50)
    private String slogan;
    @Column(name = "EMAIL_ADDRESS",nullable = false,length = 50)
    private String email;
    @Column(name = "CONTACT",nullable = false,unique = true)
    private String contactNumber;
    @Column(name = "RATINGS",nullable = false,length = 50)
    private String ratings;
    
    @OneToMany(mappedBy = "assignDefault")
    private List<Shipment> shipments = new ArrayList<>();

    public DefaultDriver() {
    }

    public DefaultDriver(String companyName, String slogan,String email,String contactNumber,String ratings ) {
        this.companyName = companyName;
        this.slogan = slogan;
        this.ratings = ratings;
        this.contactNumber = contactNumber;
        this.email = email;
    }
    public DefaultDriver(List<Shipment> shipments) {
        this.shipments = shipments;
    }

    public List<Shipment> getShipments() {
        return shipments;
    }

    public void setShipments(List<Shipment> shipments) {
        this.shipments = shipments;
    }
    
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        if (!(object instanceof DefaultDriver)) {
            return false;
        }
        DefaultDriver other = (DefaultDriver) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ac.za.tut.defaultdriver.DefaultDriver[ id=" + id + " ]";
    }
    
}
