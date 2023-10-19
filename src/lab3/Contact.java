package lab3;

import java.util.Objects;

public class Contact {
    private String name = "Jane";
    private String email = "jane@mail.com";
    private String contact_details;
    public Contact() {
    }
    public Contact(String name, String email, String contact_details) {
        this.name = name;
        this.email = email;
        this.contact_details = contact_details;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContact_details() {
        return contact_details;
    }
    public void setContact_details(String contact_details) {
        this.contact_details = contact_details;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contact_details='" + contact_details + '\'' +
                '}';
    }
}
