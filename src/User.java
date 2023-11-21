import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class User {
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String password;
    private Product[] products = new Product[0];
    // private int productId = 0;

    public User() {
    }

    public User(String firstName, String lastName, String gender, String email, String password, Product[] products) {
        chekFirstName(firstName);
        chekLastName(lastName);
        chekGender(gender);
        chekEmail(email);
        chekPassword(password);
        this.products = products;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        chekFirstName(firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        chekLastName(lastName);
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

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    // public int getProductId() {
//        return productId;
//    }

    // public int setProductId() {
//        return this.productId = ++productId;
//    }

    public static User[] registr(User[] users) {
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        user.setFirstName(scanner.nextLine());
        System.out.print("Enter your last name: ");
        user.setLastName(scanner.nextLine());
        System.out.print("Enter your gender: ");
        user.setGender(scanner.nextLine());
        boolean isTrue = true;
        int count = 0;
        while (isTrue) {
            System.out.print("Enter your email: ");
            String email = scanner.nextLine();
            for (int i = 0; i < users.length; i++) {
                if (!Objects.equals(users[i].getEmail(), email)) {
                    count++;
                }
            }
            if (count == users.length) {
                user.setEmail(email);
                isTrue = false;
            }
        }
        System.out.print("Enter your password: ");
        user.setPassword(scanner.nextLine());
        System.out.print("           ✅ Soccessfully registered\n");
        users = Arrays.copyOf(users, users.length + 1);
        users[users.length - 1] = user;
        return users;
    }

    public static int login(User[] users) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        for (int i = 0; i < users.length; i++) {
            if (email.equals(users[i].getEmail()) && password.equals(users[i].getPassword())) {
                return i;
            }
        }
        return -1;
    }

    private void chekFirstName(String name) {
        boolean isTrue = true;
        while (isTrue) {
            if (!name.isBlank()) {
                this.firstName = name;
                isTrue = false;
            } else {
                System.out.println("write first name: ");
                name = new Scanner(System.in).nextLine();
            }
        }
    }

    private void chekLastName(String lastName) {
        boolean isTrue = true;
        while (isTrue) {
            if (!lastName.isBlank()) {
                this.lastName = lastName;
                isTrue = false;
            } else {
                System.out.println("write last name: ");
                lastName = new Scanner(System.in).nextLine();
            }
        }
    }

    private void chekEmail(String email) {
        boolean isTrue = true;
        while (isTrue) {
            if (email.endsWith("@gmail.com") && email.length() > "@gmail.com".length()) {
                this.email = email;
                isTrue = false;
            } else {
                System.out.println("❗️Invalid email!('@gmail.com' should be written)\nTry again: ");
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
                System.out.println("📌Password length should be between 4-12 characters.\nTry again");
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
                System.out.println("❗️Invalid gender (sould be 'male' or 'female')");
                System.out.println("\n Try again:  ");
                gender = new Scanner(System.in).nextLine();
            }
        }
    }

    @Override
    public String toString() {
        return
                "----------------------------------------------" +
                        "firstName: " + firstName +
                        "\nlastName: " + lastName +
                        "\ngender: " + gender +
                        "\nemail: " + email +
                        "\npassword: " + password +
                        "\n product: " + Arrays.toString(products)
                ;
    }

}

