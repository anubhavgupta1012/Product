package shopee.pack.model.pojo;

import shopee.pack.model.Product;

import java.util.List;

public class SellerProdcuts {
    private String name;
    private int items;
    private List<Product> products;

    public SellerProdcuts(String name, int items, List<Product> products) {
        this.name = name;
        this.items = items;
        this.products = products;
    }

    @Override
    public String toString() {
        return "SellerProdcuts{" +
            "name='" + name + '\'' +
            ", items=" + items +
            ", products=" + products +
            '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
