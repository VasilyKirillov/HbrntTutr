package contacts.repositories;

import contacts.entities.Address;

public class AddressRepository extends Repository<Address>{

    public AddressRepository() {
        super(Address.class);
    }

}
