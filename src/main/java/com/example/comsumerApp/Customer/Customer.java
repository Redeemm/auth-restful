package com.example.comsumerApp.Customer;

import javax.persistence.*;


@Entity (name = "Customer")
@Table (
        name = "Customer",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_name", columnNames = "email")
        }
)
public class Customer {

    @Id

    @SequenceGenerator(
            name = "sequence_name",
            sequenceName = "sequence_name",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_name"
    )

    private Long CustomerID;
    private String Email;
    private String Password;


    public Customer(Long customerID, String email, String password) {
        CustomerID = customerID;
        Email = email;
        Password = password;
    }

    public Customer() {

    }


    public Customer(String email, String password) {
        Email = email;
        Password = password;
    }

    public Long getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(Long customerID) {
        CustomerID = customerID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "CustomerID=" + CustomerID +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
