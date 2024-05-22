package ac.za.tut.user;

import ac.za.tut.address.Address;
import ac.za.tut.shipment.Shipment;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "USER_TBL")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false, length = 15)
    private String name;

    @Column(name = "LAST_NAME", nullable = false, length = 15)
    private String surname;

    @Column(name = "BIRTH_DATE")
    private String dob;

    @Column(name = "SEX", nullable = false)
    private char gender;

    @Column(name = "EMAIL_ADDRESS", nullable = false, length = 30)
    private String email;

<<<<<<< HEAD
    @Column(name = "PHONE_NR", nullable = false,unique = true)
=======
    @Column(name = "PHONE_NR", nullable = false, length = 10)
>>>>>>> dd3e0be14ccfb211898bb09058ab81dc8862e11c
    private String phoneNumber;

    @Column(name = "PASSWORD", nullable = false, length = 500)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Shipment> shipments = new ArrayList<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.PERSIST)
    private Address address;

    @Temporal(TemporalType.DATE)
    private Date creationDate;

    public User() {
    }

    public User(String name, String surname, String password, String email, char gender, String dob, String phoneNumber, Date creationDate) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.creationDate = creationDate;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User(Address address, List<Shipment> shipments) {
        this.shipments = shipments;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Shipment> getShipments() {
        return shipments;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setShipments(List<Shipment> shipments) {
        this.shipments = shipments;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ac.za.tut.user.Client[ id=" + id + " ]";
    }

}
