package org.acme.Model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "products")
public class Product extends PanacheEntityBase {
    @Id
    @Column(unique = true,nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "org.hibernate.id.UUIDGenerator")
    public String id;

    @Column(name = "product_name",nullable = false)
    public String productName;
    @Column(name = "merk",nullable = true)
    public String merk;
    @Column(name = "description",nullable = true)
    public String description;
    @Column(name = "category",nullable = true)
    public String category;
    @Column(name = "price",nullable = false)
    public int price;
    @Column(name = "quantity")
    public int quantity;
}
