package be.intecbrussel.Amsakashop.data;


import jakarta.persistence.*;

@Entity
public class Payment {

    @Id
    private int id;
    private User userId;


}
