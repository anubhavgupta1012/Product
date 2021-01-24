package shopee.pack.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Product {
    @Id
    private String SKU = UUID.randomUUID().toString().split("-")[0];
    private String category;
    private String brand;
    private String color;
    private String size;
    private String seller;
    private boolean isAvailable = true;
    private int price;
    private Date createdDate = new Date();

    public Date getCreatedDate() {
        return createdDate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getCategory() {
        return category;
    }

    public Product setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public Product setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Product setColor(String color) {
        this.color = color;
        return this;
    }

    public String getSize() {
        return size;
    }

    public Product setSize(String size) {
        this.size = size;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Product setPrice(int price) {
        this.price = price;
        return this;
    }

    public String getSeller() {
        return seller;
    }

    public Product setSeller(String seller) {
        this.seller = seller;
        return this;
    }

    public String getSKU() {
        return SKU;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price &&
            SKU == product.SKU &&
            Objects.equals(category, product.category) &&
            Objects.equals(brand, product.brand) &&
            Objects.equals(color, product.color) &&
            Objects.equals(size, product.size) &&
            Objects.equals(seller, product.seller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, brand, color, size, price, seller, SKU);
    }

}
