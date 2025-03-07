import java.util.Scanner;

public class SliceoHeaven {
    public String storeName;
    public String storeAddress;
    public String storeEmail;
    public String storePhone;
    public String storeMenu;
    private String pizzaIngredients;
    public double pizzaPrice;
    private String sides;
    private String drinks;
    private String orderID;
    private double orderTotal;

    final String DEF_ORDER_ID="DEF-SOH-099";
    final String DEF_PIZZA_INGREDIENTS="Mozzarella Cheese";
    final double DEF_ORDER_TOTAL=15.00;

    private String ing1,ing2,ing3;
    private String pizzaSize;
    private String extraCheese;
    private String sideDish;
    private String wantDiscount;
    private static final String BLACKLISTED_NUMBER = "1234567890123456";
    


    public SliceoHeaven(){
        this.orderID=DEF_ORDER_ID;
        this.pizzaIngredients=DEF_PIZZA_INGREDIENTS;
        this.orderTotal=DEF_ORDER_TOTAL;
    }

    public SliceoHeaven(String orderID, String pizzaIngredients, double orderTotal){
        this.orderID=orderID;
        this.pizzaIngredients=pizzaIngredients;
        this.orderTotal=orderTotal;
    }

    public String getOrderID(){
        return orderID;
    }

    public void setOrderID(String orderID){
        this.orderID=orderID;
    }

    public String getPizzaIngredients(){
        return pizzaIngredients;
    }

    public void setPizzaIngredients(String pizzaIngredients){
        this.pizzaIngredients=pizzaIngredients;
    }

    public double getOrderTotal(){
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal){
        this.orderTotal=orderTotal;
    }

    public String getSides(){
        return sides;
    }

    public void setSides(String sides){
        this.sides=sides;
    }

    public String getDrinks(){
        return drinks;
    }

    public void setDrinks(String drinks){
        this.drinks=drinks;
    }
    
    public void takeOrder(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please pick any three of the following ingredients:");
        System.out.println("1.Mushroom");
        System.out.println("2.Paprika");
        System.out.println("3.Sun-dried tomatoes");
        System.out.println("4.Chicken");
        System.out.println("5.Pineapple");
        System.out.println(" Enter any three choices (1, 2, 3, 4, 5) separated by spaces:");
        String[] parts = null;
        String[] choice = new String[3];
        boolean validInput = false;
        while (!validInput) {
            parts = scanner.nextLine().split(" ");
            if (parts.length == 3) {
                validInput = true;
                for (String part : parts) {
                    if (!(part.equals("1") || part.equals("2") || part.equals("3") || part.equals("4") || part.equals("5"))) {
                        System.out.println("Invalid choice(s). Please pick only from the given list:");
                        validInput = false;
                        break;
                    }
                }
            }
            if (!validInput) {
                System.out.println("Invalid choice(s). Please pick only from the given list:");
            }
        }
        for (int i = 0; i < 3; i++) {
            choice[i] = parts[i];
        }


        switch (choice[0]) {
            case "1":
                ing1 = "Mushroom";
                break;
            case "2":
                ing1 = "Paprika";
                break;
            case "3":
                ing1 = "Sun-dried tomatoes";
                break;
            case "4":
                ing1 = "Chicken";
                break;
            case "5":
                ing1 = "Pineapple";
                break;
        }
        switch (choice[1]) {
            case "1":
                ing2 = "Mushroom";
                break;
            case "2":
                ing2 = "Paprika";
                break;
            case "3":
                ing2 = "Sun-dried tomatoes";
                break;
            case "4":
                ing2 = "Chicken";
                break;
            case "5":
                ing2 = "Pineapple";
                break;
        }
        switch (choice[2]) {
            case "1":
                ing3 = "Mushroom";
                break;
            case "2":
                ing3 = "Paprika";
                break;
            case "3":
                ing3 = "Sun-dried tomatoes";
                break;
            case "4":
                ing3 = "Chicken";
                break;
            case "5":
                ing3 = "Pineapple";
                break;
        }

        System.out.println("What size should your pizza be?");
        System.out.println("1.Large");
        System.out.println("2.Medium");
        System.out.println("3.Small");
        System.out.println("Enter only one choice (1, 2, or 3):");

        while (true) {
            String sizeInput=scanner.nextLine();
            switch (sizeInput) {
                case "1":
                    pizzaSize="Large";
                    break;
            
                case "2":
                    pizzaSize="Medium";
                    break;
                case "3":
                    pizzaSize="Small";
                    break;
            }
            break;
            
        }

        System.out.println("Do you want extra cheese (Y/N):");
        extraCheese = scanner.nextLine();
        while (!extraCheese.equalsIgnoreCase("Y") && !extraCheese.equalsIgnoreCase("N")) {
            System.out.println("Invalid choice(s). Please pick only from the given list (Y/N):");
            extraCheese = scanner.nextLine();
        }

        System.out.println("Following are the side dish that go well with your pizza:");
        System.out.println("1.Calzone");
        System.out.println("2.Garlic bread");
        System.out.println("3.Chicken puff");
        System.out.println("4.Muffin");
        System.out.println("5.Nothing for me");
        System.out.println("What would you like? Pick one (1, 2, 3,…):");

        
        while (true) {
            String sideInput = scanner.nextLine();
            switch (sideInput) {
                case "1":
                    sideDish = "Calzone";
                    break;
                case "2":
                    sideDish = "Garlic bread";
                    break;
                case "3":
                    sideDish = "Chicken puff";
                    break;
                case "4":
                    sideDish = "Muffin";
                    break;
                case "5":
                    sideDish = "Nothing for me";
                    break;
               
            }
            break;
        }    

        System.out.println("”Choose from one of the drinks below. We recommend Coca Cola:");
        System.out.println("1.Coca Cola");
        System.out.println("2.Cold coffee");
        System.out.println("3.Cocoa Drink");
        System.out.println("4.No drinks for me");
        System.out.println("Enter your choice:");

        while (true) {
            String drinkInput = scanner.nextLine();
            switch (drinkInput) {
                case "1":
                    drinks = "Coca Cola";
                    break;
                case "2":
                    drinks = "Cold coffee";
                    break;
                case "3":
                    drinks = "Cocoa Drink";
                    break;
                case "4":
                    drinks = "No drinks for me";
                    break;
            }
            break;
        }

        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        wantDiscount = scanner.nextLine();
            if (wantDiscount.equalsIgnoreCase("Y")) {
                isItYourBirthday();
            } else {
                makeCardPayment();
            }
        System.out.println(this);
        scanner.close();
    }

    public void isItYourBirthday(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your birthday (DD/MM/YYYY): ");
        String birthdate = scanner.next();
        scanner.close();

        java.util.Date today = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        try {
            java.util.Date birthDate = sdf.parse(birthdate);
            long timeDiff = today.getTime() - birthDate.getTime();
            long diffDays = timeDiff / (1000 * 60 * 60 * 24);

            int years = (int) (diffDays / 365.25);

            if (years < 5 || years > 120) {
                System.out.println("Invalid date. You are either too young or too dead to order. Please enter a valid date:");
                isItYourBirthday(); 
            } else {
                System.out.println("Congratulations! You pay only half the price for your order");
                setOrderTotal(getOrderTotal() / 2);
            }
        } catch (java.text.ParseException e) {
            System.out.println("Invalid date format. Please enter a valid date (DD/MM/YYYY):");
            isItYourBirthday(); 
        }

    }

    public void makeCardPayment(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your card number: ");
        String cardNumberStr = scanner.next();
        System.out.println("Please enter your card expiry date (MM/YY): ");
        String expiryDate = scanner.next();
        System.out.println("Enter the card's CVV number: ");
        int cvv = scanner.nextInt();
        processCardPayment(cardNumberStr, expiryDate, cvv);
        scanner.close();
    }

    public void makePizza(){
    }
    
   
    private void processCardPayment(String cardNumberStr, String expiryDate, int cvv) {
        if (cardNumberStr.length() != 14) {
            System.out.println("Invalid card number. Please enter a 14-digit card number.");
            return;
        }
        if (cardNumberStr.equals(BLACKLISTED_NUMBER)) {
            System.out.println("Card is blacklisted. Please use another card.");
            return;
        }

        java.util.Date today = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MM/yy");
        try {
            java.util.Date expiryDateObj = sdf.parse(expiryDate);
            if (expiryDateObj.before(today)) {
                System.out.println("Invalid expiry date. Please enter a future date.");
                makeCardPayment(); 
            } else {
                System.out.println("Card accepted");
            }
        } catch (java.text.ParseException e) {
            System.out.println("Invalid date format. Please enter a valid expiry date (MM/YY).");
            makeCardPayment(); 
        }
    }

    @Override
    public String toString() {
        return "Order ID: " + getOrderID() +
                "\nPizza Ingredients: " + ing1 + ", " + ing2 + ", " + ing3 +
                "\nPizza Size: " + pizzaSize +
                "\nExtra Cheese: " + extraCheese +
                "\nSide Dish: " + sideDish +
                "\nDrinks: " + getDrinks() +
                "\nOrder Total: " + getOrderTotal();
    }

    
    public static void main(String[] args) {
        SliceoHeaven pizzeria = new SliceoHeaven();
        pizzeria.takeOrder();
    }
}