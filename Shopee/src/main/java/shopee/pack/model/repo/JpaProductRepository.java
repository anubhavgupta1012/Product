package shopee.pack.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shopee.pack.model.Product;

import java.util.List;

@Repository
public interface JpaProductRepository extends JpaRepository<Product, String> {

    @Query("select p from Product p where  p.isAvailable = true")
    List<Product> getProductsByAvailableTrue();

    Product getProductsBySKU(String id);

    @Query("SELECT p from Product p where lower(p.seller) like concat('%',:seller,'%')")
    List<Product> getProductsBySellers(@Param("seller") String seller);

    @Query("select p from Product p order by p.brand")
    List<Product> getProductBrandWise();

    @Query("select p from Product p order by p.price")
    List<Product> getProductPriceWise();

    @Query("select p from Product p order by p.color")
    List<Product> getProductColorWise();

    @Query("select p from Product p order by p.size")
    List<Product> getProductSizeWise();
}
