import java.util.Scanner;

public class SliceoHeaven {
// final
    private static final double PIZZA_BASE_PRICE = 10.0;
    private static String[] pizzasOrdered = new String[10];
    private static String[] pizzaSizesOrdered = new String[10];
    private static String[] sideDishesOrdered = new String[20];
    private static String[] drinksOrdered = new String[20];
    private static double totalOrderPrice = 0.0;
    private static int orderCount = 0;

    public enum PizzaSelection {
        PEPPERONI("Pepperoni", "Lots of pepperoni and extra cheese", 18),
        HAWAIIAN("Hawaiian", "Pineapple, ham, and extra cheese", 22),
        VEGGIE("Veggie", "Green pepper, onion, tomatoes, mushroom, and black olives", 25),
        BBQ_CHICKEN("BBQ Chicken", "Chicken in BBQ sauce, bacon, onion, green pepper, and cheddar cheese", 35),
        EXTRAVAGANZA("Extravaganza", "Pepperoni, ham, Italian sausage, beef, onions, green pepper, mushrooms, black olives, and extra cheese", 45);

        private final String pizzaName;
        private final String pizzaToppings;
        private final double price;

        PizzaSelection(String pizzaName, String pizzaToppings, double price) {
            this.pizzaName = pizzaName;
            this.pizzaToppings = pizzaToppings;
            this.price = price;
        }

        public String getPizzaName() {
            return pizzaName;
        }

        public String getPizzaToppings() {
            return pizzaToppings;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return pizzaName + " Pizza with " + pizzaToppings + ", for €" + price;
        }
    }


    public enum PizzaToppings {
        HAM("Ham", 2), PEPPERONI("Pepperoni", 2), BEEF("Beef", 2), CHICKEN("Chicken", 2), SAUSAGE("Sausage", 2),
        PINEAPPLE("Pineapple", 1), ONION("Onion", 0.5), TOMATOES("Tomatoes", 0.4), GREEN_PEPPER("Green Pepper", 0.5),
        BLACK_OLIVES("Black Olives", 0.5), SPINACH("Spinach", 0.5), CHEDDAR_CHEESE("Cheddar Cheese", 0.8),
        MOZZARELLA_CHEESE("Mozzarella Cheese", 0.8), FETA_CHEESE("Feta Cheese", 1), PARMESAN_CHEESE("Parmesan Cheese", 1);

        private final String topping;
        private final double toppingPrice;

        PizzaToppings(String topping, double toppingPrice) {
            this.topping = topping;
            this.toppingPrice = toppingPrice;
        }

        public String getTopping() {
            return topping;
        }

        public double getToppingPrice() {
            return toppingPrice;
        }

        @Override
        public String toString() {
            return topping + " (€" + toppingPrice + ")";
        }
    }

    public enum PizzaSize {
        LARGE("Large", 10), MEDIUM("Medium", 5), SMALL("Small", 0);

        private final String pizzaSize;
        private final double addToPizzaPrice;

        PizzaSize(String pizzaSize, double addToPizzaPrice) {
            this.pizzaSize = pizzaSize;
            this.addToPizzaPrice = addToPizzaPrice;
        }

        public String getPizzaSize() {
            return pizzaSize;
        }

        public double getAddToPizzaPrice() {
            return addToPizzaPrice;
        }

        @Override
        public String toString() {
            return pizzaSize + " (€" + addToPizzaPrice + ")";
        }
    }

    public enum SideDish {
        CALZONE("Calzone", 15), CHICKEN_PUFF("Chicken Puff", 20), MUFFIN("Muffin", 12), NOTHING("No side dish", 0);

        private final String sideDishName;
        private final double addToPizzaPrice;

        SideDish(String sideDishName, double addToPizzaPrice) {
            this.sideDishName = sideDishName;
            this.addToPizzaPrice = addToPizzaPrice;
        }

        public String getSideDishName() {
            return sideDishName;
        }

        public double getAddToPizzaPrice() {
            return addToPizzaPrice;
        }

        @Override
        public String toString() {
            return sideDishName + " (€" + addToPizzaPrice + ")";
        }
    }

    public enum Drinks {
        COCA_COLA("Coca Cola", 8), COCOA_DRINK("Cocoa Drink", 10), NOTHING("No drinks", 0);

        private final String drinkName;
        private final double addToPizzaPrice;

        Drinks(String drinkName, double addToPizzaPrice) {
            this.drinkName = drinkName;
            this.addToPizzaPrice = addToPizzaPrice;
        }

        public String getDrinkName() {
            return drinkName;
        }

        public double getAddToPizzaPrice() {
            return addToPizzaPrice;
        }

        @Override
        public String toString() {
            return drinkName + " (€" + addToPizzaPrice + ")";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueOrdering = true;

        while (continueOrdering) {
            takeOrder(scanner);
            System.out.println("Do you want to order more? (Y/N): ");
            continueOrdering = scanner.nextLine().equalsIgnoreCase("Y");
        }
        printOrderDetails();
        scanner.close();
    }

    public static void takeOrder(Scanner scanner) {
        System.out.println("Welcome to Slice-o-Heaven Pizzeria. Here’s what we serve:");
        for (int i = 0; i < PizzaSelection.values().length; i++) {
            System.out.println((i + 1) + ". " + PizzaSelection.values()[i].toString());
        }
        System.out.println("6. Custom Pizza with a maximum of 10 toppings that you choose");

        System.out.print("Please enter your choice (1 - 6): ");
        int choice = Integer.parseInt(scanner.nextLine());

        String pizzaDetails;
        double pizzaPrice;

        if (choice >= 1 && choice <= 5) {
            PizzaSelection selectedPizza = PizzaSelection.values()[choice - 1];
            pizzaDetails = selectedPizza.toString();
            pizzaPrice = selectedPizza.getPrice();
        } else if (choice == 6) {
            System.out.println("Available toppings:");
            for (PizzaToppings topping : PizzaToppings.values()) {
                System.out.println(topping);
            }
            System.out.print("Enter up to 10 toppings (separated by spaces): ");
            String[] toppingsInput = scanner.nextLine().split(" ");
            StringBuilder toppingsList = new StringBuilder();
            double customPizzaPrice = PIZZA_BASE_PRICE;

            for (String input : toppingsInput) {
                if (Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= PizzaToppings.values().length) {
                    PizzaToppings selectedTopping = PizzaToppings.values()[Integer.parseInt(input) - 1];
                    toppingsList.append(selectedTopping.getTopping()).append(", ");
                    customPizzaPrice += selectedTopping.getToppingPrice();
                }
            }
            toppingsList = new StringBuilder(toppingsList.toString().trim().replaceAll(", $", ""));

            pizzaDetails = "Custom Pizza with " + toppingsList + ", for €" + customPizzaPrice;
            pizzaPrice = customPizzaPrice;
        } else {
            System.out.println("Invalid choice. Order cancelled.");
            return;
        }

        

        pizzasOrdered[orderCount] = pizzaDetails;
        totalOrderPrice += pizzaPrice;

  
        System.out.println("Choose pizza size:");
        for (PizzaSize size : PizzaSize.values()) {
            System.out.println(size);
        }
        System.out.print("Enter your choice (1-3): ");
        int sizeChoice = Integer.parseInt(scanner.nextLine());
        PizzaSize selectedSize = PizzaSize.values()[sizeChoice - 1];
        pizzaSizesOrdered[orderCount] = selectedSize.getPizzaSize();
        totalOrderPrice += selectedSize.getAddToPizzaPrice();


        System.out.println("Choose a side dish:");
        for (SideDish dish : SideDish.values()) {
            System.out.println(dish);
        }
        System.out.print("Enter your choice (1-4): ");
        int dishChoice = Integer.parseInt(scanner.nextLine());
        SideDish selectedDish = SideDish.values()[dishChoice - 1];
        sideDishesOrdered[orderCount] = selectedDish.getSideDishName();
        totalOrderPrice += selectedDish.getAddToPizzaPrice();


        System.out.println("Choose a drink:");
        for (Drinks drink : Drinks.values()) {
            System.out.println(drink);
        }
        System.out.print("Enter your choice (1-3): ");
        int drinkChoice = Integer.parseInt(scanner.nextLine());
        Drinks selectedDrink = Drinks.values()[drinkChoice - 1];
        drinksOrdered[orderCount] = selectedDrink.getDrinkName();
        totalOrderPrice += selectedDrink.getAddToPizzaPrice();

        orderCount++;
    }

 
    public static void printOrderDetails() {
        System.out.println("Thank you for dining with Slice-o-Heaven Pizzeria. Your order details are as follows:");
        for (int i = 0; i < orderCount; i++) {
            System.out.println((i + 1) + ". " + pizzasOrdered[i]);
            System.out.println("   " + pizzaSizesOrdered[i]);
            System.out.println("   " + sideDishesOrdered[i]);
            System.out.println("   " + drinksOrdered[i]);
        }
        System.out.println("ORDER TOTAL: €" + totalOrderPrice);
    }
}