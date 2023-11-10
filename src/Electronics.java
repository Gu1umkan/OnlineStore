import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.*;
import java.util.Scanner;

public class Electronics extends Product {
    private  String  brand;
    private String color;
    private boolean isNew;
    private String memory;


    public Electronics(String name, String description, BigDecimal price, String brand, String color, boolean isNew, String memory) {
        super(name, description, price);
        this.brand = brand;
        this.color = color;
        this.isNew = isNew;
        this.memory = memory;
    }

    public Electronics() {
        super();
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }
    public void addElectronic(){
        Scanner scanner= new Scanner(System.in);
        System.out.print("Enter product brand: ");
        setBrand(scanner.nextLine());
        System.out.print("Enter product name: ");
        setName(scanner.nextLine());
        System.out.println("Enter memory: ");
        setMemory(scanner.nextLine());
        System.out.println("Enter product color: ");
        setColor(scanner.nextLine());
        System.out.println("Enter description: ");
        setDescription(scanner.nextLine());
        System.out.println("Enter price: ");
        setPrice(new Scanner(System.in).nextBigDecimal());
        System.out.println("New product? (write true or false)");
        setNew(scanner.hasNextBoolean());
    }

    @Override
    public String toString() {
        return "Electronics{" +
                "\brand='" + brand +
                "\ncolor='" + color +
                "\nisNew=" + isNew +
                "\nmemory='" + memory +
                 super.toString();
    }
}
