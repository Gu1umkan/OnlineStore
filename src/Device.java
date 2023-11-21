import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Device extends Product {
    private String brand;
    private String color;
    private boolean isNew;
    private int memory;


    public Device(String name, String description, BigDecimal price, ZonedDateTime time, String brand, String color, boolean isNew, int memory) {
        super(name, description, price, time);
        chekbrand(brand);
        chekColor(color);
        this.isNew = isNew;
        chekMemory(memory);
    }

    public Device() {
        super();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        chekbrand(brand);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        chekColor(color);
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        chekMemory(memory);
    }


    @Override
    public Product[] addProduct(Product[] products, int id) {
        Device device = new Device();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product brand: ");
        device.setBrand(scanner.nextLine());
        System.out.print("Enter product name: ");
        device.setName(scanner.nextLine());
        System.out.print("Enter memory: ");
        device.setMemory(new Scanner(System.in).nextInt());
        System.out.print("Enter product color: ");
        device.setColor(scanner.nextLine());
        System.out.print("Enter description: ");
        device.setDescription(scanner.nextLine());
        System.out.print("Enter price: ");
        device.setPrice(new Scanner(System.in).nextBigDecimal());
        System.out.print("New product? (write true or false)");
        device.setNew(scanner.hasNextBoolean());
        device.setCreatedAt(ZonedDateTime.now());
        device.setId(id);
        products = Arrays.copyOf(products, products.length + 1);
        products[products.length - 1] = device;
        return products;
    }

    @Override
    public void getAllProduct(User user) {
        Product[] products = user.getProducts();
        if (!new Device().isEmpty(products)) {
            System.out.println("❌You don't have devices❗️");
        } else {
            for (int k = 0; k < products.length; k++) {
                if (products[k] instanceof Device deviceUser) {
                    System.out.println(deviceUser);
                }
            }
        }
    }

    public boolean isEmpty(Product[] products) {
        for (int k = 0; k < products.length; k++) {
            if (products[k] instanceof Device deviceUser) {
                if (deviceUser != null) {
                    return true;
                }
            }
        }
        return false;
    }

    private void chekbrand(String brand) {
        boolean isTrue = true;
        while (isTrue) {
            if (!brand.isBlank()) {
                this.brand = brand;
                isTrue = false;
            } else {
                System.out.println("write  brand: ");
                brand = new Scanner(System.in).nextLine();
            }
        }
    }

    private void chekColor(String color) {
        boolean isTrue = true;
        while (isTrue) {
            if (!color.isBlank()) {
                this.color = color;
                isTrue = false;
            } else {
                System.out.println("write color: ");
                color = new Scanner(System.in).nextLine();
            }
        }
    }

    private void chekMemory(int memory) {
        boolean isTrue = true;
        while (isTrue) {
            if (memory > 0) {
                this.memory = memory;
                isTrue = false;
            } else {
                System.out.println("write memory  : ");
                memory = new Scanner(System.in).nextInt();
            }
        }
    }

    @Override
    public String toString() {
        return STR. """
                ***************************************************************
                * Device
                * id: \{ getId() }
                * brand: \{ brand }
                * name: \{ getName() }
                * color:  \{ color }
                * memory: \{ memory }
                * product is new ?  \{ isNew }
                * description: \{ getDescription() }
                * price: \{ getPrice() }
                * createdAt: \{ getCreatedAt() }
                 """ ;
    }
}


