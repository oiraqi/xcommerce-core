package ma.aui.sse.it.xcommerce.microservices.catalog.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Omar IRAQI
 */
@Entity
public class Product extends AbstractJpaEntity {
    
    private static final long serialVersionUID = 730736845770996539L;
    private String barcode;
    private String name;
    private int quantity;
    private float weight;
    @ManyToOne
    @NotNull
    private Brand brand;
    private float price;
    @ManyToOne
    @NotNull
    private Category category;
    private boolean active;

    protected Product(){

    }

    public Product(String name, Brand brand, Category category, float price, int quantity, float weight){
        this.name = name;
        this.brand = brand;
        this.category = category;        
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
        active = false;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object other){
        if(other == null || !(other instanceof Product))
            return false;
        
        return id.longValue() == ((Product)other).getId().longValue();
    }

    /**
     * @return the barcode
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * @param barcode the barcode to set
     */
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}
