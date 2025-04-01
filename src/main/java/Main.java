import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        UserInput userInput = new UserInput();

        while (true) {
            int mainMenuOption = userInput.showMainMenu();

            if (mainMenuOption == 1) {
                while (true) {
                    int productsMenuOption = userInput.showProductsMenu();

                    // Add
                    if (productsMenuOption == 1) {
                        String name = userInput.CreateOption("Product name: ", Scanner::next);

                        if (name == null) {
                            System.out.println("Name is not allowed!!!");
                            continue;
                        }

                        if (manager.getProduct(name, true) != null) {
                            System.out.println("Product previously created!!!");
                            continue;
                        }

                        System.out.printf("Select a category for '%s'", name);

                        System.out.println();
                        for (Product.Category category : Product.Category.values()) {
                            System.out.printf("    %d. %s", category.ordinal(), category);
                        }
                        System.out.println();

                        int category = userInput.CreateOption("Category:", Scanner::nextInt, 0);
                        if (Product.Category.values().length - 1 < category) {
                            System.out.println("Category is not allowed!!!");
                            continue;
                        }

                        manager.addProduct(name, Product.Category.values()[category]);
                    // Remove product
                    } else if (productsMenuOption == 2) {
                        String name = userInput.CreateOption("Product name: ", Scanner::next);

                        if (name == null) {
                            System.out.println("Name is not allowed!!!");
                            continue;
                        }

                        Product findProduct = manager.getProduct(name, true);

                        if (findProduct == null) {
                            System.out.println("Product not exists!!!");
                            continue;
                        }

                        manager.removeProduct(name);
                    // List all
                    } else if (productsMenuOption == 3) {
                        int productNumber = 1;

                        System.out.printf("Products registered: %d", manager.getProducts().size());
                        System.out.println();

                        for (Product product : manager.getProducts()) {
                            System.out.printf("%d. Name: %s :: Category: %s", productNumber, product.getName(), product.getCategory());
                            System.out.println();
                            productNumber++;
                        }
                    // Return to main menu
                    } else if (productsMenuOption == 4) {
                        break;
                    }
                }
            } else if (mainMenuOption == 2) {
                System.out.println("Thank you for using Computer Shop!!!");
                break;
            }
        }
    }
}