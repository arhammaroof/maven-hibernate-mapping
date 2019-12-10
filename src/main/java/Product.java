import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(generator = "incrementor")
    private long productId;
    private String name;
    private String Description;
    private String category;

    public Product(long id, String name, String Description)
    {
        productId=id;
        this.name=name;
        this.Description=Description;
    }
    public long getProduct() {
        return productId;
    }

    public void setProduct(long product) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
//    public String toString(){
//        return name+Description+category;
//    }
}
