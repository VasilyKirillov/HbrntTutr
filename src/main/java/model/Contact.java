
package model;

/**
 *
 * @author Vasilii_Kirillov
 */
public class Contact {
    private Long id;
    private Long AddressId;
    private String name;

    public Contact() {
    }

    public Contact(Long AddressId, String name) {
        this.AddressId = AddressId;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAddressId() {
        return AddressId;
    }

    public void setAddressId(Long AddressId) {
        this.AddressId = AddressId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
