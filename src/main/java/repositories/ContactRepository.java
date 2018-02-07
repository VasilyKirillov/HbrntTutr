package repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Contact;

public class ContactRepository {

    private final DataSource ds;

    public ContactRepository() {
        try {
            Context context = new InitialContext();
            try {
                ds = (DataSource) context.lookup("java:comp/env/jdbc/trainingdb");
            } finally {
                context.close();
            }
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public void init() throws SQLException {
        Connection connection = ds.getConnection();
        try {
            Statement statement = connection.createStatement();
            try {
                statement.execute("CREATE TABLE contact (id integer generated by default as identity primary key,"
                        + " name varchar(255), address_id integer, foreign key (address_id) references address)");
            } finally {
                statement.close();
            }
        } finally {
            connection.close();
        }
    }

    public List<Contact> findAll() throws SQLException {
        Connection connection = ds.getConnection();
        try {
            Statement statement = connection.createStatement();
            try {
                ResultSet results = statement
                        .executeQuery("SELECT * FROM contact");
                try {
                    List<Contact> contacts = new ArrayList<Contact>();
                    while (results.next()) {
                        contacts.add(unmarshal(results));
                    }
                    return contacts;
                } finally {
                    results.close();
                }
            } finally {
                statement.close();
            }
        } finally {
            connection.close();
        }
    }

    public Contact find(long id) throws SQLException {
        Connection connection = ds.getConnection();
        try {
            Statement statement = connection.createStatement();
            try {
                ResultSet results = statement
                        .executeQuery("SELECT * FROM contact WHERE id = " + id);
                try {
                    if (!results.next()) {
                        return null;
                    } else {
                        return unmarshal(results);
                    }
                } finally {
                    results.close();
                }
            } finally {
                statement.close();
            }
        } finally {
            connection.close();
        }
    }

    public void create(Contact contact) throws SQLException {
        Connection connection = ds.getConnection();
        try {
            Statement statement = connection.createStatement();
            try {
                statement.executeUpdate(
                        "INSERT INTO contact (name, address_id) VALUES ('"
                        + contact.getName() + "', '"
                        + contact.getAddressId() + "')",
                        Statement.RETURN_GENERATED_KEYS);
                ResultSet generatedKeys = statement.getGeneratedKeys();
                try {
                    if (generatedKeys.next()) {
                        contact.setId(generatedKeys.getLong("id"));
                    }
                } finally {
                    generatedKeys.close();
                }
            } finally {
                statement.close();
            }
        } finally {
            connection.close();
        }
    }

    public void update(Contact contact) throws SQLException {
        Connection connection = ds.getConnection();
        try {
            Statement statement = connection.createStatement();
            try {
                statement.executeUpdate("UPDATE contact SET name='"
                        + contact.getName() + "', address_id='"
                        + contact.getAddressId() + "' WHERE id="
                        + contact.getId());
            } finally {
                statement.close();
            }
        } finally {
            connection.close();
        }
    }

    public void delete(Contact contact) throws SQLException {
        Connection connection = ds.getConnection();
        try {
            Statement statement = connection.createStatement();
            try {
                statement.executeUpdate("DELETE FROM contact WHERE id="
                        + contact.getId());
            } finally {
                statement.close();
            }
        } finally {
            connection.close();
        }
    }

    private Contact unmarshal(ResultSet results) throws SQLException {
        Contact contact = new Contact();
        contact.setId(results.getLong("id"));
        contact.setName(results.getString("name"));
        contact.setAddressId(results.getLong("address_id"));
        return contact;
    }
}
