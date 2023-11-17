/*	In questo esempio, la classe ContactRepository utilizza JdbcTemplate di Spring per interagire con il database. 
 	I metodi addContact, getAllContacts, getContactById, deleteContactById e updateContact corrispondono alle 
 	operazioni richieste. Si noti che questi metodi non generano eccezioni di tipo SQLException in caso di 
 	errori di accesso al database, poiché JdbcTemplate di Spring gestisce automaticamente le eccezioni.
*/
package com.example.repositories;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.example.models.Contact;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

@Repository
public class ContactJdbcTemplateRepository {
    private JdbcTemplate jdbcTemplate;
    private static final Log logger = LogFactory.getLog(ContactJdbcTemplateRepository.class);

    public ContactJdbcTemplateRepository(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }    

    public void addContact(Contact contact) {
        logger.info("## Repository: Inizio elaborazione... ##");
    	String sql = "INSERT INTO contacts (first_name, last_name, phone, email) "
        		+ "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, contact.getFirstName(), contact.getLastName(), 
        		contact.getPhone(), contact.getEmail());
        logger.info("## Repository: Contatto aggiunto! ##");
    }

    public List<Contact> getAllContacts() {
        String sql = "SELECT * FROM contacts";
        RowMapper<Contact> rowMapper = new ContactRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public Contact getContactById(int id) {
        String sql = "SELECT * FROM contacts WHERE id = ?";
        RowMapper<Contact> rowMapper = new ContactRowMapper();
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public void deleteContactById(int id) {
        String sql = "DELETE FROM contacts WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void updateContact(Contact contact) {
        String sql = "UPDATE contacts SET first_name = ?, last_name = ?, phone = ?, "
        		+ "email = ? WHERE id = ?";
        jdbcTemplate.update(sql, contact.getFirstName(), contact.getLastName(), 
        		contact.getPhone(), contact.getEmail(), contact.getId());
    }

    private static final class ContactRowMapper implements RowMapper<Contact> {
        public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
            Contact contact = new Contact();
            contact.setId(rs.getInt("id"));
            contact.setFirstName(rs.getString("first_name"));
            contact.setLastName(rs.getString("last_name"));
            contact.setPhone(rs.getString("phone"));
            contact.setEmail(rs.getString("email"));
            return contact;
        }
    }
}
