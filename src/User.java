import java.util.Objects;
import java.util.Scanner;

public class User {
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String password;
    private Product[][] products = new Product[2][100];

    public User() {
    }

    public User(String firstName, String lastName, String gender, String email, String password, Product[][] products) {
        this.firstName = firstName;
        this.lastName = lastName;
        chekGender(gender);
        chekEmail(email);
        chekPassword(password);
        this.products = products;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        chekGender(gender);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        chekEmail(email);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        chekPassword(password);
    }

    public Product[][] getProducts() {
        return products;
    }

    public void setProducts(Product[][] products) {
        this.products = products;
    }

    private void chekEmail(String email) {
        boolean isTrue = true;
        while (isTrue) {
            if (!email.isBlank() && email.contains("@gmail.com")) {
                this.email = email;
                isTrue = false;
            } else {
                System.err.println("Invalid email!('@gmail.com' should be written)\n try again:");
                email = new Scanner(System.in).nextLine();
            }
        }
    }

    private void chekPassword(String password) {
        boolean isTrue = true;
        while (isTrue) {
            if (!password.isBlank() && 3 < password.length() && password.length() < 13) {
                this.password = password;
                isTrue = false;
            } else {
                System.err.println("Password length should be between 4-12 characters.\ntry again:");
                password = new Scanner(System.in).nextLine();
            }
        }
    }

    private void chekGender(String gender) {
        boolean isTrue = true;
        while (isTrue) {
            if (!gender.isBlank() && gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")) {
                this.gender = gender;
                isTrue = false;
            } else {
                System.err.println("Invalid gender (sould be 'male' or 'female')\n try again:");
                gender = new Scanner(System.in).nextLine();
            }
        }
    }


    @Override
    public String toString() {
        return
                "firstName: " + firstName +
                        "\nlastName: " + lastName +
                        "\ngender: " + gender +
                        "\nemail: " + email +
                        "\npassword: " + password +
                        "\nproducts: " + products
                ;
    }


    public void registr(User[] users, int counter) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        setFirstName(scanner.nextLine());
        System.out.print("Enter your last name: ");
        setLastName(scanner.nextLine());
        System.out.print("Enter your gender: ");
        boolean isTrue = true;
        setGender(scanner.nextLine());
        while (isTrue) {
            System.out.print("Enter your email: ");
            String email = scanner.nextLine();
            int count = 0;
            for (int i = 0; i < counter; i++) {
                if (!Objects.equals(users[i].getEmail(), email)) {
                    count++;
                }
            }
            if (count == counter) {
                setEmail(email);
                isTrue = false;
            } else break;


        }
        System.out.print("Enter your password: ");
        setPassword(scanner.nextLine());

        System.out.print("Soccessfully registered\n");


    }


    public static void login(User[] users, int counter) {
        Scanner scanner = new Scanner(System.in);
        boolean bool = true;
        int books = 0;
        int electronics = 0;
        Product[][] products1 = new Product[2][100];
        while (bool) {
            System.out.println("Enter your email: ");
            String email = scanner.nextLine();
            System.out.println("Enter your password: ");
            String password = scanner.nextLine().toLowerCase();
            boolean istrue = true;
            while (istrue) {
                for (int i = 0; i < counter; i++) {
                    if (email.equals(users[i].getEmail()) && password.equals(users[i].getPassword())) {
                        System.out.println(STR. """
                        Login succesfull.Welcome!
                        Profile:  \{ users[i].getFirstName() }  \{ users[i].getLastName() }
                        email: \{ users[i].getEmail() }
                 0.Logout
                 1.Add new Product
                 2.Get all Products
                 3.Get all Books
                 4.Get all Electronics
                 Enter your choice:

                        """ );
                        switch (scanner.nextLine().toLowerCase()) {
                            case "0", "logout":
                                bool = false;
                                istrue = false;

                                break;
                            case "1", "add": {
                                System.out.println("Choise category:Electronic or book");
                                String category = scanner.nextLine();

                                if ("electronic".equalsIgnoreCase(category)) {
                                    Electronics electronic = new Electronics();
                                    electronic.addElectronic();
                                    products1[1][electronics++] = electronic;
                                    users[i].setProducts(products1);
                                } else if ("book".equalsIgnoreCase(category)) {
                                    Book book = new Book();
                                    book.addBook();
                                    products1[0][books++] = book;
                                    users[i].setProducts(products1);
                                    System.out.println("Succesfully added product \n");
                                   // break;
                                } else {
                                    System.err.println("Invalid category!");
                                }
                                break;
                            }

                            case "2", "get all product":
                                boolean allNull = true;
                                for (int j = 0; j < 2; j++) {
                                    for (int k = 0; k < books+electronics; k++) {
                                        if (users[i].getProducts()[j][k] != null) {
                                            allNull = false;
                                            break;
                                        }
                                    }
                                }
                                if (allNull) {
                                    System.out.println("Product jok");
                                } else {
                                    for (int j = 0; j < 2; j++) {
                                        for (int k = 0; k < books+electronics; k++) {
                                            System.out.println(users[i].getProducts()[j][k]);
                                        }
                                    }
                                }
                                break;
                            case "3", "books":
                                boolean alNull = true;
                                 for (int k = 0; k < books+electronics; k++) {
                                        if (users[i].getProducts()[0][k] != null) {
                                            alNull = false;
                                            break;
                                        }
                                    }

                                if (alNull) {
                                    System.out.println("Product book jok");}
                                else {
                                for (int j = 0; j < books; j++) {
                                    System.out.println(users[i].getProducts()[0][j]);
                                }}
                                break;

                            case "4", "electronics":
                                boolean isNull = true;
                                for (int k = 0; k < electronics; k++) {
                                    if (users[i].getProducts()[1][k] != null) {
                                        isNull = false;
                                        break;
                                    }
                                }

                                if (isNull) {
                                    System.out.println("Product electronic jok");}
                                else {
                                for (int j = 0; j < electronics; j++) {
                                    System.out.println(users[i].getProducts()[1][j]);
                                }}
                                break;
                            default:
                                System.err.println("Invalid choice");
                        }
                    }
                }
                if (!istrue) {
                    System.out.println("Not found ");
                }
            }

        }
    }

}
