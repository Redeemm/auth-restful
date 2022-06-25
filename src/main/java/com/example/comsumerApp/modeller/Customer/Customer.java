package com.example.comsumerApp.modeller.Customer;

import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

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

    private long CustomerID;

    @Column (name = "first_name")
    private String FirstName;

    @Column (name = "last_name")
    private String LastName;

    @Column (name = "email")
    private String Email;

    @Column (name = "phone_number")
    private int Phone;

    @Column (name = "address")
    private String Address;


}
