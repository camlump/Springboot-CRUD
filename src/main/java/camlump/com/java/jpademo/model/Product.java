package camlump.com.java.jpademo.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "product_inventory")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column( name = "color")
    private String color;

    @Column( name = "price")
    private int price;
}
