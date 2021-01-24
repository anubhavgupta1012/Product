package shopee.pack.model.pojo;

public class NewProduct {

    private String category;
    private String brand;
    private String color;
    private String size;
    private String seller;
    private int price;

    public String getCategory() {
        return category;
    }

    public NewProduct setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public NewProduct setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getColor() {
        return color;
    }

    public NewProduct setColor(String color) {
        this.color = color;
        return this;
    }

    public String getSize() {
        return size;

    }

    public NewProduct setSize(String size) {
        this.size = size;
        return this;
    }

    public String getSeller() {
        return seller;
    }

    public NewProduct setSeller(String seller) {
        this.seller = seller;
        return this;

    }

    public int getPrice() {
        return price;
    }

    public NewProduct setPrice(int price) {
        this.price = price;
        return this;
    }
}
