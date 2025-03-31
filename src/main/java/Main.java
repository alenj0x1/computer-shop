public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        UserInput userInput = new UserInput();

        while (true) {
            int mainMenuOption = userInput.showMainMenu();

            if (mainMenuOption == 1) {
                while (true) {
                    int productsMenuOption = userInput.showProductsMenu();

                    if (productsMenuOption == 4) {
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