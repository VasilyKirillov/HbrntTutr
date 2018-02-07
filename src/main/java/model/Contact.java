package model;

/**
 *
 * @author Vasilii_Kirillov
 */
public class Contact {

    private Long id;
    private String name;
    private Long AddressId;

    public Contact() {
    }

    public Contact(String name, Long AddressId) {
        this.AddressId = AddressId;
        this.name = name;
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
        return AddressId;
    }

    public void setAddressId(Long AddressId) {
        this.AddressId = AddressId;
    }

}
