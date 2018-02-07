package contacts.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Contact {

    @Id
    @GeneratedValue
    private Long id;
    
    @Column
    private String name;    
    
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch=FetchType.LAZY)
    private Address address;

    public Contact() {
    }

    public Contact(String name, Address address) {
        this.name = name;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddressId(Address address) {
        this.address = address;
    }

}
