package isp.lab3.exercise5;

import java.util.HashMap;

import java.util.Map;

public class Exercise5 {
    private int credit;
    private Map<Integer, String> products;

    public Exercise5() {
        this.credit = 0;
        this.products = new HashMap<Integer, String>();
        this.products.put(1, "Coke");
        this.products.put(2, "Pepsi");
        this.products.put(3, "Sprite");
        this.products.put(4, "Fanta");
    }

    public String displayProducts() {
        System.out.println("Available products:");
        for (Map.Entry<Integer, String> entry : this.products.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        return this.products.toString();
    }

    public void insertCoin(int value) {
        this.credit += value;
    }

    public String selectProduct(int id) {
        String productName = this.products.get(id);
        if (productName == null) {
            return "Invalid selection. Please try again.";
        } else if (this.credit < 50) {
            return "Insufficient credit. Please insert coins.";
        } else {
            this.credit -= 50;
            return "Selected product: " + productName;
        }
    }

    public int displayCredit() {
        System.out.println("Credit: " + this.credit);
        return this.credit;
    }

    public void userMenu() {
        System.out.println("Welcome to the Vending Machine!");
        boolean exit = false;
        while (!exit) {
            System.out.println("Please select an option:");
            System.out.println("1 - Display available products");
            System.out.println("2 - Insert coins");
            System.out.println("3 - Select a product");
            System.out.println("4 - Display credit");
            System.out.println("5 - Exit");
            int choice = Integer.parseInt(System.console().readLine());
            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    System.out.println("Please insert coins:");
                    int coins = Integer.parseInt(System.console().readLine());
                    insertCoin(coins);
                    System.out.println("Coins inserted: " + coins);
                    break;
                case 3:
                    System.out.println("Please enter the product selection id:");
                    int productId = Integer.parseInt(System.console().readLine());
                    String result = selectProduct(productId);
                    System.out.println(result);
                    break;
                case 4:
                    displayCredit();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
        System.out.println("Thank you for using the Vending Machine!");
    }
}
