package contacts.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.Table;

@Entity
//@Table
public class Contact {

    @Id
    @GeneratedValue
    private Long id;
    
    @Column
    private String name;
    
    @Column
    private String proneNumber;

    public String getProneNumber() {
        return proneNumber;
    }

    public void setProneNumber(String proneNumber) {
        this.proneNumber = proneNumber;
    }
    
    @Column
    private Long addressId;

    public Contact() {
    }

    public Contact(String name, Long addressId) {
        this.name = name;
        this.addressId = addressId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

}
