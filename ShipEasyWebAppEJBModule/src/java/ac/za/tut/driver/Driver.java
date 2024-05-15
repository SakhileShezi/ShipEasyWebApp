package ac.za.tut.driver;

import ac.za.tut.shipment.Shipment;
import ac.za.tut.vehicle.Vehicle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DRIVERS_TBL")
public class Driver implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "FULL_NAMES" ,nullable = false ,length = 30)
    private String fullNames;
    @Column(name = "SURNAME",nullable = false,length = 15)
    private String surname;
    @Column(name = "EMAIL_ADDRESS",nullable = false,length = 30)
    private String email;
    @Column(name = "CELL_NR",nullable = false,length = 10)
    private String cellNumber;
    @Column(name = "PASSWORD",nullable = false,length = 20)
    private String password;
    @OneToMany(mappedBy = "assignedDriver")
    private List<Shipment> shipments = new ArrayList<>();

    @OneToOne(mappedBy = "driver",cascade = CascadeType.ALL)
    private Vehicle vehicle;
    
    
    public Driver() {
    }

    public Driver(String fullNames, String surname, String email, String cellNumber, String password) {
        this.fullNames = fullNames;
        this.surname = surname;
        this.email = email;
        this.cellNumber = cellNumber;
        this.password = password;
    }
    
    public Driver(Vehicle vehicle,List<Shipment> shipments) {
        this.vehicle = vehicle;
        this.shipments = shipments;
    }

    public List<Shipment> getShipments() {
        return shipments;
    }

    public void setShipments(List<Shipment> shipments) {
        this.shipments = shipments;
    }
    
  
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
   
    
    public String getFullNames() {
        return fullNames;
    }

    public void setFullNames(String fullNames) {
        this.fullNames = fullNames;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        if (!(object instanceof Driver)) {
            return false;
        }
        Driver other = (Driver) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ac.za.tut.driver.Driver[ id=" + id + " ]";
    }
    
}
