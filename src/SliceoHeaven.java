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
    
    public void takeOrder(String id, String details, double total){
        setOrderID(id);
        setPizzaIngredients(details);
        setOrderTotal(total);
        printReceipt();
    
    }

    public void makePizza(){
        
       
    }
    
    private void printReceipt(){
        System.out.println("Order ID: " + getOrderID());
        System.out.println("Pizza Ingredients: " + getPizzaIngredients());
        System.out.println("Order Total: " + getOrderTotal());
    
    }

    public void processCardPayemnt(String cardNumber, String expiryDate, int cvv){
        int cardLength=cardNumber.length();
        if(cardLength==14){
            System.out.println("Card accepted");
        }else{
            System.out.println("Invalid card");
            
        }

        int firstCardDigit = Integer.parseInt(cardNumber.substring(0, 1));
        String blacklistedNumber="123";
        if(cardNumber.equals(blacklistedNumber)){
            System.out.println("Card is blackListed. Please use another");
        }

        int lastFourDigits=Integer.parseInt(cardNumber.substring(cardLength-4));
        String cardNumberToDisplay=firstCardDigit+"****"+lastFourDigits;
        System.out.println("Card Number to Display"+cardNumberToDisplay);
    }

    public void specialOfTheDay(String pizzaOfTheDay, String sideOfTheDay,String specialPrice){
        StringBuilder displayInfo = new StringBuilder();
        displayInfo.append("Today's Special: ").append(pizzaOfTheDay)
                  .append(" with ").append(sideOfTheDay)
                  .append(" for only $").append(specialPrice);
        System.out.println(displayInfo.toString());
    }
    



    public static void main(String[] args) {
        SliceoHeaven pizzeria = new SliceoHeaven();
        pizzeria.takeOrder("DEF-SOH-099", "Mozzarella Cheese", 15.00);
        pizzeria.processCardPayemnt("12345678901234", "3/2", 123);
    }
}