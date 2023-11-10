import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class Book extends  Product{
    private String author;
    private String fullname;

    public Book(String name, String description, BigDecimal price) {
        super(name, description, price);
    }

    public Book(String name, String description, BigDecimal price, String author, String fullname) {
        super(name, description, price);
        this.author = author;
        this.fullname = fullname;
    }


    public Book() {
        super();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public  void addBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book name: ");
        setFullname(scanner.nextLine());
        System.out.println("Enter book author fullname: ");
        setAuthor(scanner.nextLine());
        System.out.println("Enter description: ");
        setDescription(scanner.nextLine());
        System.out.println("Enter price: ");
        setPrice(new Scanner(System.in).nextBigDecimal());
        setCreatedAt();
    }

    @Override
    public String toString() {
        return
                "\nauthor books: " + author +
                "\nfullname: " + fullname +
                  super.toString();
    }
}
