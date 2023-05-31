package adtbag;

import java.util.Scanner;

public class ShoppingCartApp {
    private BagArray<Item> cart;

    public ShoppingCartApp() {
        this.cart = new BagArray<>();
    }

    public void addToCart() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter item name: ");
        String name = scanner.nextLine();

        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Item item = new Item(name, price);
        cart.add(item);
    }

    public void removeFromCart() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter item name: ");
        String name = scanner.nextLine();

        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Item item = new Item(name, price);
        if (cart.remove(item)) {
            System.out.println("Item removed successfully.");
        } else {
            System.out.println("Failed to remove item from the cart.");
        }
    }

    public void removeSpecificItem() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter item name: ");
        String name = scanner.nextLine();

        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Item item = new Item(name, price);
        int count = cart.getFrequencyOf(item);
        if (count > 0) {
            cart.remove(item);
            System.out.println("Removed " + count + " instance(s) of the item from the cart.");
        } else {
            System.out.println("Item not found in the cart.");
        }
    }

    public void getNumberOfItems() {
        System.out.println("Number of items in the cart: " + cart.getCurrentSize());
    }

    public void abandonCart() {
        cart.clear();
        System.out.println("Cart abandoned. All items removed.");
    }

    public double getTotalCost() {
        double totalCost = 0.0;
        for (Item item : cart.toArray()) {
            totalCost += item.getPrice();
        }
        return totalCost;
    }

    public void printReceipt() {
        System.out.println("Receipt:");
        for (Item item : cart.toArray()) {
            System.out.println(item.getName() + ": $" + item.getPrice());
        }
        System.out.println("Total cost: $" + getTotalCost());
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add item to cart");
            System.out.println("2. Remove item from cart");
            System.out.println("3. Remove specific item from cart");
            System.out.println("4. Get number of items in cart");
            System.out.println("5. Abandon cart");
            System.out.println("6. Get total cost of cart");
            System.out.println("7. Print itemized receipt");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addToCart();
                    break;
                case 2:
                    removeFromCart();
                    break;
                case 3:
                    removeSpecificItem();
                    break;
                case 4:
                    getNumberOfItems();
                    break;
                case 5:
                    abandonCart();
                    break;
                case 6:
                    System.out.println("Total cost of the cart: $" + getTotalCost());
                    break;
                case 7:
                    printReceipt();
                    break;
                case 8:
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    
            }}}}
            
        


