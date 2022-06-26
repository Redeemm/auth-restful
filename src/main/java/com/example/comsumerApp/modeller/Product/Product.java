package com.example.comsumerApp.modeller.Product;

import com.example.comsumerApp.modeller.user.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString

@Entity (name = "Product")
@Table (name = "product")
public class Product {

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


    private Long ProductID;
    private String ProductName;
    private String Partner;
    private String Commercials;

    public Product(String productName, String partner, String commercials) {
        ProductName = productName;
        Partner = partner;
        Commercials = commercials;
    }

    public Product(Long productID, String productName, String partner, String commercials) {
        ProductID = productID;
        ProductName = productName;
        Partner = partner;
        Commercials = commercials;
    }

    public Product() {
    }

}
