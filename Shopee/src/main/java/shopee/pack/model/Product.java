package shopee.pack.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
