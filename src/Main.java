
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User[] users = new User[0];
        boolean istrue = true;
        while (istrue) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(""" 
                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        
                    ^                  🟢 1.Registr                    ^
                    ^                  🟠 2.Login                      ^
                    ^                  🔴 3.Exit                       ^
                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                    ↩️Enter your choice: """);
            switch (scanner.nextLine().toLowerCase()) {
                case "registr", "1" -> users = User.registr(users);
                case "login", "2" -> {
                    if (users.length == 0) {
                        System.out.println("📌Need to register.");
                    } else {
                        int index = User.login(users);
                        if (index > -1) {
                            User currentUser = users[index];
                            System.out.println(STR. """
                       ***************************************************************
                               Login succesfull ✅ Welcome!🙌
                               👤 Profile:  \{ currentUser.getFirstName() } \{ currentUser.getLastName() }
                               📨️ email:   \{ currentUser.getEmail() }
                       ---------------------------------------------------------------""" );
                            boolean bool = true;
                            while (bool) {
                                System.out.println("""
                                        ++++++++++++++++++++++++++++++++++++++++++++++++
                                        |            ⬅️  0.Logout                      |
                                        |            ❇️  1.Add new Product             |
                                        |            📚💻2.Get all Products            |
                                        |            📚  3.Get all Books               |
                                        |            💻  4.Get all Electronics         |
                                        |            ❌  5.Delete product              |
                                        |            ❎  6.Delete products             |
                                        ++++++++++++++++++++++++++++++++++++++++++++++++
                                                       ↩️ Enter your choice:
                                                """);
                                switch (scanner.nextLine().toLowerCase()) {
                                    case "0", "logout" -> bool = false;
                                    case "1", "add" -> {
                                        boolean chekCategory = true;
                                        while (chekCategory) {
                                            System.out.print("Product category: 1. 💻device  ⏸️ 2. 📕book \nWhich  product do you want to add? ");
                                            String category = scanner.nextLine();
                                            switch (category) {
                                                case "1", "device" -> {
                                                    currentUser.setProducts(new Device().addProduct(currentUser.getProducts(), MyGenerateId.generateId()));
                                                    System.out.println("❇️Succesfully added product \n");
                                                    chekCategory = false;
                                                }
                                                case "2", "book" -> {
                                                    currentUser.setProducts(new Book().addProduct(currentUser.getProducts(), MyGenerateId.generateId()));
                                                    System.out.println("❇️Succesfully added product \n");
                                                    chekCategory = false;
                                                }
                                                default -> {
                                                    System.err.println("Invalid category!");
                                                    System.out.println("Try again: ");
                                                }
                                            }
                                        }
                                    }

                                    case "2", "get all product" -> {
                                        if (!new Book().isEmpty(currentUser.getProducts()) && !new Device().isEmpty(currentUser.getProducts())) {
                                            System.out.println("You don't have product❗️");
                                        } else {
                                            System.out.println(Arrays.toString(currentUser.getProducts()));
                                        }
                                    }
                                    case "3", "books" -> new Book().getAllProduct(currentUser);

                                    case "4", "device" -> new Device().getAllProduct(currentUser);

                                    case "5", "delete" -> {
                                        if (!new Book().isEmpty(currentUser.getProducts()) && !new Device().isEmpty(currentUser.getProducts())) {
                                            System.out.println("You don't have product for to delete❗️");
                                        } else {
                                            System.out.print("Enter the id you want to delete: ");
                                            currentUser.setProducts(Product.deleteProduct(currentUser.getProducts(), new Scanner(System.in).nextInt()));
                                        }
                                    }
                                    case "6", "delete products" -> {
                                        if (!new Book().isEmpty(currentUser.getProducts()) && !new Device().isEmpty(currentUser.getProducts())) {
                                            System.out.println("You don't have product to delete❗️");
                                        } else {
                                            System.out.print("Enter count of products  you want to delete:");
                                            int countId = new Scanner(System.in).nextInt();
                                            int[] ids = new int[countId];
                                            for (int i = 0; i < countId; i++) {
                                                System.out.print("Write  " + (i + 1) + " - id: ");
                                                ids[i] = new Scanner(System.in).nextInt();
                                            }
                                            currentUser.setProducts(Product.deleteProduct(currentUser.getProducts(), ids));
                                        }
                                    }
                                    default -> System.out.println("❗️Invalid choice");
                                }
                            }
                        } else System.out.println("❌👤This is profile was not found.");

                    }
                }
                case "3", "exit" -> System.exit(0);
                case "4" -> {
                    System.out.println(Arrays.toString(users));
                }
                default -> System.err.println("Invalid choice");
            }
        }
    }
}
