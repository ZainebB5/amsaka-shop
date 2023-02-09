package be.intecbrussel.Amsakashop.data;


import jakarta.persistence.*;
import be.intecbrussel.Amsakashop.data.Category;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String brand;
    private double price;
    private String imageLocation;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private  Category categoryId;

}
