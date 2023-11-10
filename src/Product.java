import java.math.BigDecimal;
import java.time.LocalDate;

public class Product  {
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDate createdAt;

    public Product() {
    }

    public Product(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.createdAt = LocalDate.now();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt() {
        this.createdAt = LocalDate.now();
    }
    public  void addProduct(){
        System.out.println("Enter your ");
    }

    @Override
    public String toString() {
        return
                "name: " + name +
                "\ndescription: " + description +
                "\nprice: " + price +
                "\ncreatedAt: " + createdAt
                ;
    }
}
