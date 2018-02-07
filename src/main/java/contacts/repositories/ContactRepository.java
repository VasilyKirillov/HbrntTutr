package contacts.repositories;

import contacts.entities.Contact;

public class ContactRepository  extends Repository<Contact>{

    public ContactRepository() {
        super(Contact.class);
    }
}
