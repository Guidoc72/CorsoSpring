/* Questa classe ContactRepository utilizza un’istanza di java.sql.Connection per interagire con il database. 
   I metodi addContact, getAllContacts, getContactById, deleteContactById e updateContact corrispondono 
   alle operazioni richieste. Si noti che questi metodi generano eccezioni di tipo SQLException in caso 
   di errori di accesso al database.
*/

//package com.example.repositories;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import org.springframework.stereotype.Repository;
//import com.example.models.Contact;
//
//@Repository
//public class ContactRepository {
//    private Connection conn;
//
//    public ContactRepository(Connection conn) {
//        this.conn = conn;
//    }
//
//    public void addContact(Contact contact) throws SQLException {
//        String sql = "INSERT INTO contacts (first_name, last_name, phone, email) VALUES (?, ?, ?, ?)";
//        PreparedStatement statement = conn.prepareStatement(sql);
//        statement.setString(1, contact.getFirstName());
//        statement.setString(2, contact.getLastName());
//        statement.setString(3, contact.getPhone());
//        statement.setString(4, contact.getEmail());
//        statement.executeUpdate();
//    }
//
//    public List<Contact> getAllContacts() throws SQLException {
//        String sql = "SELECT * FROM contacts";
//        PreparedStatement statement = conn.prepareStatement(sql);
//        ResultSet result = statement.executeQuery();
//        List<Contact> contacts = new ArrayList<>();
//        while (result.next()) {
//            Contact contact = new Contact();
//            contact.setId(result.getInt("id"));
//            contact.setFirstName(result.getString("first_name"));
//            contact.setLastName(result.getString("last_name"));
//            contact.setPhone(result.getString("phone"));
//            contact.setEmail(result.getString("email"));
//            contacts.add(contact);
//        }
//        return contacts;
//    }
//
//    public Contact getContactById(int id) throws SQLException {
//        String sql = "SELECT * FROM contacts WHERE id = ?";
//        PreparedStatement statement = conn.prepareStatement(sql);
//        statement.setInt(1, id);
//        ResultSet result = statement.executeQuery();
//        if (result.next()) {
//            Contact contact = new Contact();
//            contact.setId(result.getInt("id"));
//            contact.setFirstName(result.getString("first_name"));
//            contact.setLastName(result.getString("last_name"));
//            contact.setPhone(result.getString("phone"));
//            contact.setEmail(result.getString("email"));
//            return contact;
//        }
//        return null;
//    }
//
//    public void deleteContactById(int id) throws SQLException {
//        String sql = "DELETE FROM contacts WHERE id = ?";
//        PreparedStatement statement = conn.prepareStatement(sql);
//        statement.setInt(1, id);
//        statement.executeUpdate();
//    }
//
//    public void updateContact(Contact contact) throws SQLException {
//        String sql = "UPDATE contacts SET first_name = ?, last_name = ?, phone = ?, email = ? "
//        		+ "WHERE id = ?";
//        PreparedStatement statement = conn.prepareStatement(sql);
//        statement.setString(1, contact.getFirstName());
//        statement.setString(2, contact.getLastName());
//        statement.setString(3, contact.getPhone());
//        statement.setString(4, contact.getEmail());
//        statement.setInt(5, contact.getId());
//        statement.executeUpdate();
//    }
//}
