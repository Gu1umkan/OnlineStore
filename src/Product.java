import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Scanner;

public abstract class Product {
    private String name;
    private String description;
    private BigDecimal price;
    private ZonedDateTime createdAt;
    private int id;

    public Product() {
    }

    public Product(String name, String description, BigDecimal price, ZonedDateTime time) {
        chekName(name);
        chekDescription(description);
        this.price = price;
        this.createdAt = time;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        chekName(name);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        chekDescription(description);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime time) {
        this.createdAt = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract Product[] addProduct(Product[] products, int productId);

    public abstract void getAllProduct(User user);

    public abstract boolean isEmpty(Product[] products);


    public static Product[] deleteProduct(Product[] products, int id) {
        boolean bool = false;
        for (int i = 0; i < products.length; i++) {
            if (products[i].getId() == id) {
                for (int j = i; j < products.length - 1; j++) {
                    products[j] = products[j + 1];
                }
                bool = true;
                System.out.println("Succesfully deleted ");
            }
        }
        if (bool) {
            products = Arrays.copyOf(products, products.length - 1);
        }
        return products;
    }


    public static Product[] deleteProduct(Product[] products, int[] ids) {
        for (int i = 0; i < ids.length; i++) {
            products = deleteProduct(products, ids[i]);
        }
        return products;
    }


    private void chekName(String name) {
        boolean isTrue = true;
        while (isTrue) {
            if (!name.isBlank()) {
                this.name = name;
                isTrue = false;
            } else {
                System.out.println("write  name: ");
                name = new Scanner(System.in).nextLine();
            }
        }
    }

    private void chekDescription(String description) {
        boolean isTrue = true;
        while (isTrue) {
            if (!description.isBlank()) {
                this.description = description;
                isTrue = false;
            } else {
                System.out.println("write description: ");
                description = new Scanner(System.in).nextLine();
            }
        }
    }

    @Override
    public String toString() {
        return
                "* name: " + name +
                        "\n* description: " + description +
                        "\n* price: " + price +
                        "\n* createdAt: " + createdAt
                ;
    }

}
