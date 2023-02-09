package be.intecbrussel.Amsakashop.data;

import jakarta.persistence.*;


@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String categoryName;



}
