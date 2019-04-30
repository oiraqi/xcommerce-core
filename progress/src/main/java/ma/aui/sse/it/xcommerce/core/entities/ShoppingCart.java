/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.aui.sse.it.xcommerce.core.entities;

import java.util.Hashtable;


/**
 *
 * @author Omar IRAQI
 */
public class ShoppingCart {
    private Hashtable<Product, Integer> selectedProducts;
    private long customerId;
    private float productsTotalPrice;
    private float shippingCost;
    private static final float BASE_SHIPPING_COST = 25;  
    
    public ShoppingCart(){
        customerId = -1;
        selectedProducts = new Hashtable<Product, Integer>();
        productsTotalPrice = 0;
        shippingCost = 0;
    }

    public ShoppingCart(long customerId){
        this();
        this.customerId = customerId;
    }

    public void addProduct(Product product, int quantity){
        if(quantity <= 0)
            throw new IllegalArgumentException();
        updateProduct(product, quantity);
    }

    public void removeProduct(Product product, int quantity){
        if(quantity <= 0)
            throw new IllegalArgumentException();
        updateProduct(product, -1 * quantity);
    }

    private void updateProduct(Product product, int quantity) {
        int currentQuantity = 0;
        if(selectedProducts.get(product) != null)
            currentQuantity = selectedProducts.get(product);
        if(quantity + currentQuantity < 0)
            throw new IllegalArgumentException();
        if(quantity + currentQuantity == 0)
            selectedProducts.remove(product);
        else
            selectedProducts.put(product, quantity + currentQuantity);
        productsTotalPrice += product.getPrice() * quantity;
        shippingCost += product.getWeight() * quantity;
    }

    public float getProductsTotalPrice() {
        return productsTotalPrice;
    }

    public float getShippingCost() {
        return shippingCost;
    }

    public float getTotalPrice() {
        return productsTotalPrice + ((shippingCost == 0)? 0 : shippingCost + BASE_SHIPPING_COST);
    }
    
    public boolean isEmpty(){
        return productsTotalPrice == 0;
    }
    public void empty(){
        selectedProducts = new Hashtable<Product, Integer>();
        productsTotalPrice = 0;
        shippingCost = 0;
    }

    public void setShippingCost(float shippingCost) {
        this.shippingCost = shippingCost;
    }

    public void setCustomerId(long customerId){
        this.customerId = customerId;
    }

    public long getCustomerId() {
        return customerId;
    }
}
