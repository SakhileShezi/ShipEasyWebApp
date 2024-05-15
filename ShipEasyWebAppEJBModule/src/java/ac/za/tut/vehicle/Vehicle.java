package ac.za.tut.vehicle;

import ac.za.tut.driver.Driver;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE_TBL")
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "VEHICLE_VIN" ,nullable = false,length = 50)
    private String vin;
    @Column(name = "VEHICLE_PLATE_NUMBER" ,nullable = false,length = 15)
    private String numberPlate;
    @Column(name = "VEHICLE_TYPE" ,nullable = false,length = 15)
    private String vehicleType;
    @Column(name = "MENUFACTURER" ,nullable = false,length = 15)
    private String model;
    
    @Lob
    @Column(name = "LICENSE_SOURCE")
    private byte[] license;
    
    @OneToOne
    @JoinColumn(name = "DRIVER_ID")
    private Driver driver;
    

    public Vehicle() {
    }

    public Vehicle(String vin, String numberPlate, String vehicleType,String model,byte[] license) {
        this.vin = vin;
        this.numberPlate = numberPlate;
        this.vehicleType = vehicleType;
        this.model = model;
        this.license = license;
    }

    public Vehicle(Driver driver) {
        this.driver = driver;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public byte[] getLicense() {
        return license;
    }

    public void setLicense(byte[] license) {
        this.license = license;
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
        if (!(object instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ac.za.tut.vehicle.Vehicle[ id=" + id + " ]";
    }
    
}
