package shopee.pack.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import shopee.pack.model.Product;
import shopee.pack.model.pojo.NewProduct;
import shopee.pack.model.pojo.SellerProdcuts;
import shopee.pack.model.repo.JpaProductRepository;
import shopee.pack.service.ProductDataService;

import java.util.List;

@Service
public class ProductDataServiceImpl implements ProductDataService {

    @Autowired
    private JpaProductRepository jpaProductRepository;

    @Override
    public List<Product> getAllProducts() {
        return jpaProductRepository.getProductsByAvailableTrue();
    }

    @Override
    public ResponseEntity<Product> saveNewProduct(NewProduct newProduct) {
        Product product = new Product();
        product.setBrand(newProduct.getBrand());
        product.setCategory(newProduct.getCategory());
        product.setColor(newProduct.getColor());
        product.setPrice(newProduct.getPrice());
        product.setSeller(newProduct.getSeller());
        product.setSize(newProduct.getSize());
        jpaProductRepository.save(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @Override
    public Product findProductById(String id) {
        return jpaProductRepository.getProductsBySKU(id);
    }

    @Override
    public SellerProdcuts findProductsBySeller(String seller) {
        List<Product> productsBySellers = jpaProductRepository.getProductsBySellers(seller.toLowerCase());
        if (productsBySellers.isEmpty()) {
            return null;
        }
        SellerProdcuts sellerProdcut = new SellerProdcuts(
            productsBySellers.get(0).getSeller(), productsBySellers.size(), productsBySellers);
        return sellerProdcut;
    }

    @Override
    public List<Product> getProductGroupWise(String groupParam) {
        switch (groupParam) {
            case "brand":
                return jpaProductRepository.getProductBrandWise();
            case "price":
                return jpaProductRepository.getProductPriceWise();
            case "color":
                return jpaProductRepository.getProductColorWise();
            case "size":
                return jpaProductRepository.getProductSizeWise();
            default:
                return jpaProductRepository.getProductsByAvailableTrue();
        }
    }

    @Override
    public Product buyProduct(String id) {
        Product productById = findProductById(id);
        productById.setAvailable(false);
        jpaProductRepository.save(productById);
        return productById;
    }
}
