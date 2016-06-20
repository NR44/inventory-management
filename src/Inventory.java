import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Nigel on 6/16/16.
 */
public class Inventory {

    private ArrayList<Item> items = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addItem(int id) {
        scanner.reset();
        Item theItem = new Item();
        System.out.println("Please enter the new Item's Name: ");
        theItem.setName(scanner.nextLine());
        System.out.println("How many Items are there? ");
        theItem.setQuantity(scanner.nextInt());
        System.out.println("What is the price of the Item? ");
        theItem.setPrice(scanner.nextInt());
        theItem.setId(id);
        items.add(theItem);
    }

    public boolean isListEmpty() {
        return items.isEmpty();
    }

    public void printItems() {
        System.out.println("Here is your list of items: ");
        for (Item name : items) {
            System.out.println(name.getId() + ". [" + name.getQuantity() + "] " + name.getName());
        }
        scanner.nextLine();
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }


    public void sellItem(){
        Item theItem;
        String sellItemName;
        int amountToSell = 0;

        System.out.println("Enter the name of the item you would like to sell: ");
        scanner.nextLine();
        sellItemName = scanner.nextLine();

        theItem = findItem(sellItemName);

        if (theItem != null) {
            System.out.println("Enter the amount you'd like to sell: ");
            amountToSell = scanner.nextInt();
            scanner.nextLine();
            if (theItem.getQuantity() >= amountToSell) {
                sellItem(theItem, amountToSell);
                System.out.println("You've successfully sold " + amountToSell + ".");
            } else {
                System.out.println("You cannot sell more than you have.");
            }

        } else {
            System.out.println("The item name you entered does not exist.");
        }
    }

    public int menuOptions() {
        int option = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("[1] Create a new Item." + System.lineSeparator() + "[2] Sell some items." + System.lineSeparator() + "[3] Remove an Item." + System.lineSeparator() + "[4] Update an Item's Quantity." + System.lineSeparator() + "[5] Update an Item's Price." + System.lineSeparator() + "[6] Quit Program." + System.lineSeparator());

        option = scanner.nextInt();

        return option;
    }

    public Item findItem(String name) {
        Item needItem = null;

        for (Item foundItem : this.items) {
            if (foundItem.getName().equalsIgnoreCase(name)) {
                needItem = foundItem;
            }
        }
        return needItem;
    }

    public String findItemName(String name) {
        for (Item item : this.items) {
            if (item.getName().equalsIgnoreCase(name)) {
                name = item.getName();
            }
        }
        return name;
    }

    public void sellItem(Item sellItem, int sellAmount) {
        int amount = sellItem.getQuantity();
        amount -= sellAmount;
        sellItem.setQuantity(amount);
    }

    public void removeItem() {
        int index = -1;
        System.out.println("Please enter the 'NUMBER' of the item you'd like to remove: ");
        int idToRemove = scanner.nextInt();
        for (int i = 0; i <= items.size(); i++){
            Item current = items.get(i);
            if (current.getId() == idToRemove) {
                items.remove(i);
                System.out.println("Yay! Successful removal!");
            }
        }
    }

    public void changeQuantity(){
        System.out.println("Enter the name of the item you would like to update: ");
        String itemName = scanner.nextLine();
        if (itemName.equalsIgnoreCase(findItemName(itemName))){
            scanner.nextLine();
            System.out.println("What would you like to update the quantity to: ");
            int newQuantity = scanner.nextInt();
            Item item = findItem(itemName);
            item.setQuantity(newQuantity);
            System.out.println("Your new quantity is " + item.getQuantity());
        }else{
            System.out.println("The name you entered is invalid.");
        }

    }

    public void changePrice(){
        System.out.println("Enter the name of the item you would like to update: ");
        String itemName = scanner.nextLine();
        scanner.nextLine();
        if (itemName.equalsIgnoreCase(findItemName(itemName))) {
            System.out.println("What would you like to update the price to: ");
            int newPrice = scanner.nextInt();
            Item item = findItem(itemName);
            item.setPrice(newPrice);
            System.out.println("Your new price is " + item.getPrice());
        } else {
            System.out.println("The item name you entered does not exist.");
        }
    }
}



