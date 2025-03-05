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
        System.out.println("Enter three ingredients for your pizza (use spaces to separate ingredients):");
        System.out.println("Ingredient 1:");
        ing1=scanner.nextLine();
        System.out.println("Ingerdient 2:");
         ing2=scanner.nextLine();
        System.out.println("Ingredient 3:");
        ing3=scanner.nextLine();

        System.out.println("Enter size of pizza (Small, Medium, Large):");
        pizzaSize=scanner.nextLine();

        System.out.println("”Do you want extra cheese (Y/N):");
        extraCheese=scanner.nextLine();

        System.out.println("Enter one side dish (Calzone, Garlic bread, None):");
        sideDish=scanner.nextLine();

        System.out.println("Enter drinks(Cold Coffee, Cocoa drink, Coke, None):");
        drinks=scanner.nextLine();

        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        wantDiscount=scanner.nextLine();
        if(wantDiscount.equalsIgnoreCase("Y")){
            isItYourBirthday();
        }else{
            makeCardPayment();
        }
        printReceipt();
        scanner.close();
    }

    public void isItYourBirthday(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter your birthday : ");
        String birthdate=scanner.next();
        String today="05/03/2025";
        if(birthdate.equals(today)){
            System.out.println("Congratulations! You pay only half the price for your order");
            setOrderTotal(getOrderTotal()/2);
        }else{
            System.out.println("Too bad! You do not meet the conditions to get our 50% discount");
        }
        scanner.close();

    }

    public void makeCardPayment(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter your card number: ");
        long cardNumber=scanner.nextLong();
        System.out.println("Please enter your card expiry date: ");
        String expiryDate=scanner.next();
        System.out.println("Enter the card's CVV number: ");
        int cvv=scanner.nextInt();
        processCardPayemnt(cardNumber, expiryDate, cvv);
        scanner.close();
    }

    public void makePizza(){
    }
    
    private void printReceipt(){
        System.out.println("Order ID: " + getOrderID());
        System.out.println("Pizza Ingredients: " + ing1 + ", " + ing2 + ", " + ing3);
        System.out.println("Pizza Size:"+pizzaSize);
        System.out.println("Extra Cheese: "+extraCheese);
        System.out.println("Side Dish: "+sideDish);
        System.out.println("Drinks: "+getDrinks());
        System.out.println("Order Total: "+getOrderTotal());
    
    }

    public void processCardPayemnt(long cardNumber, String expiryDate, int cvv){
        String cardNumberStr = Long.toString(cardNumber);
        if (cardNumberStr.length() == 14) {
            System.out.println("Card accepted");
        } else {
            System.out.println("Invalid card");
        }

        String firstCardDigitStr = String.valueOf(cardNumberStr.charAt(0));
        long firstCardDigit = Long.parseLong(firstCardDigitStr);
        String blacklistedNumber = "1234567890123456";
        if (cardNumber == Long.parseLong(blacklistedNumber)) {
            System.out.println("Card is blacklisted. Please use another card");
        }

        String lastFourDigitsStr = cardNumberStr.substring(cardNumberStr.length() - 4);
        String cardNumberToDisplay = firstCardDigitStr + "****" + lastFourDigitsStr;
        System.out.println("Card Number to Display: " + cardNumberToDisplay);
    }
    
    public static void main(String[] args) {
        SliceoHeaven pizzeria = new SliceoHeaven();
        pizzeria.takeOrder();
    }
}