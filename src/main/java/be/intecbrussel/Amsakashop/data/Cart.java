package be.intecbrussel.Amsakashop.data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cart {

    @Id
    @GeneratedValue
    private int id;
    private int productCount;
    private float totalPrice;
    private float discountedPrice;

    public Cart() {
    }

    public Cart(int productCount, float totalPrice, float discountedPrice) {
        this.productCount = productCount;
        this.totalPrice = totalPrice;
        this.discountedPrice = discountedPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public float getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(float discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
}
