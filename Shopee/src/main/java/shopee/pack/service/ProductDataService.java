package shopee.pack.service;

import org.springframework.http.ResponseEntity;
import shopee.pack.model.Product;
import shopee.pack.model.pojo.NewProduct;
import shopee.pack.model.pojo.SellerProdcuts;

import java.util.List;

public interface ProductDataService {

    List<Product> getAllProducts();

    ResponseEntity<Product> saveNewProduct(NewProduct product);

    Product findProductById(String id);

    SellerProdcuts findProductsBySeller(String seller);

    List<Product> getProductGroupWise(String groupParam);

    Product buyProduct(String id);
}
