package shopee.pack.model.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NewProduct {

    private String category;
    private String brand;
    private String color;
    private String size;
    private String seller;
    private int price;

}
