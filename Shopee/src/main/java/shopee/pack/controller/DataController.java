package shopee.pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shopee.pack.model.Product;
import shopee.pack.model.pojo.NewProduct;
import shopee.pack.model.pojo.SellerProdcuts;
import shopee.pack.service.ProductDataService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DataController {

    @Autowired
    private ProductDataService productDataService;

    @GetMapping("/product")
    public ResponseEntity<Product> getProductById(@RequestParam(required = false) String id) {
        Product product = productDataService.findProductById(id);
        return product == null ? new ResponseEntity(null, HttpStatus.NOT_FOUND) :
            new ResponseEntity(product, HttpStatus.OK);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productDataService.getAllProducts();
    }

    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody NewProduct product) {
        return productDataService.saveNewProduct(product);
    }

    @GetMapping("/products/seller")
    public SellerProdcuts getProductBySeller(@RequestParam(required = true) String seller) {
        return productDataService.findProductsBySeller(seller);
    }

    /*
     *  similar kind of data will be come together according to the column
     * of which they are grouped (eg. brand, color, size , price)
     */
    @GetMapping("/products/group/{groupParam}")
    public List<Product> getGroupedProduct(@PathVariable String groupParam) {
        return productDataService.getProductGroupWise(groupParam.toLowerCase());
    }

    @PutMapping("/product/buy")
    public Product buyProduct(@RequestBody String id) {
        return productDataService.buyProduct(id);
    }
}
