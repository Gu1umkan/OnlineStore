import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Book extends Product {
    private String authorFullname;

    public Book(String name, String description, BigDecimal price, ZonedDateTime time) {
        super(name, description, price, time);
    }

    public Book(String name, String description, BigDecimal price, String author, ZonedDateTime time) {
        super(name, description, price, time);
        chekAuthoFullname(author);
    }

    public Book() {
        super();
    }

    public String getAuthorFullname() {
        return authorFullname;
    }

    public void setAuthorFullname(String author) {
        chekAuthoFullname(author);
    }

    @Override
    public Product[] addProduct(Product[] products, int id) {
        Book book = new Book();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book name: ");
        book.setName(scanner.nextLine());
        System.out.print("Enter book author fullname: ");
        book.setAuthorFullname(scanner.nextLine());
        System.out.print("Enter description: ");
        book.setDescription(scanner.nextLine());
        System.out.print("Enter price: ");
        book.setPrice(new Scanner(System.in).nextBigDecimal());
        book.setCreatedAt(ZonedDateTime.now());
        book.setId(id);
        products = Arrays.copyOf(products, products.length + 1);
        products[products.length - 1] = book;
        return products;
    }

    @Override
    public void getAllProduct(User user) {
        Product[] products = user.getProducts();
        if (!new Book().isEmpty(products)) {
            System.out.println("❌You don't have device❗️");
        } else {
            for (int k = 0; k < products.length; k++) {
                if (products[k] instanceof Book bookUser) {
                    System.out.println(bookUser);
                }
            }
        }
    }

    @Override
    public boolean isEmpty(Product[] products) {
        for (int k = 0; k < products.length; k++) {
            if (products[k] instanceof Book bookUser) {
                if (bookUser != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public void chekAuthoFullname(String authorFullname) {
        boolean isTrue = true;
        while (isTrue) {
            if (!authorFullname.isBlank()) {
                this.authorFullname = authorFullname;
                isTrue = false;
            } else {
                System.out.println("write author  fullname: ");
                authorFullname = new Scanner(System.in).nextLine();
            }
        }
    }

    @Override
    public String toString() {
        return STR. """
          ******************************************************************
          * Book
          * id:\{ getId() }
          * author books: \{ authorFullname }
          \{ super.toString() }
                            """ ;
    }
}
