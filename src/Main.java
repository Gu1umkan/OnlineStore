import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User[] users = new User[100];
        int counter = 0;
        boolean istrue = true;
        while (istrue) {Scanner scanner = new Scanner(System.in);
            System.out.println("""
                    1.Registr
                    2.Login
                    3.Exit
                     """);

            String choise = (scanner.nextLine());
           switch (choise){
               case "registr","1":
                User user = new User();
                   user.registr(users,counter);
                   users[counter] = user;
                           counter++;
                   System.out.println(Arrays.toString(users));
                           break;

               case "login","2":
                   User.login(users,counter); break;

               case "3","exit":
                   System.exit(0); break;
               default:
                   System.err.println("Invalid choice");
           }
        }
    }
}