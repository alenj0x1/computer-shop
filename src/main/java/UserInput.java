import java.util.HashMap;
import java.util.Scanner;

public class UserInput {
    public Scanner keyboard;

    public UserInput() {
        this.keyboard = new Scanner(System.in);
    }

    public int showMainMenu() {
        HashMap<String, Integer> options = new HashMap<>();
        options.put("Products", 1);
        options.put("Exit", 2);

        return this.CreateMenu("Main menu", options);
    }

    public int showProductsMenu() {
        HashMap<String, Integer> options = new HashMap<>();
        options.put("Add", 1);
        options.put("Remove", 2);
        options.put("List all", 3);
        options.put("Return to main menu", 4);

        return this.CreateMenu("Products menu", options);
    }

    private int CreateMenu(String name, HashMap<String, Integer> options) {
        try {
            System.out.println(name);
            options.forEach((key, value) -> {
                System.out.println("    " + value + ". " + key);
            });
            System.out.println("Your option: ");

            return this.keyboard.nextInt();
        } catch (Exception e) {
            this.keyboard.nextLine();
            System.out.println("Only integers are allowed!!!");
            return 0;
        }
    }
}
