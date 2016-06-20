import java.util.Scanner;

/**
 * Created by Nigel on 6/16/16.
 */
public class Main {

    public static void main(String[] args) {
        int id = 0;
        int choice = 0;
        Inventory theInventory = new Inventory();
        Item theItem = new Item();
        Scanner scanner = new Scanner(System.in);



        do {
            switch (theInventory.menuOptions()) {
                case 1:
                    id++;
                    theInventory.addItem(id);
                    break;
                case 2:
                    if (theInventory.isListEmpty()) {
                        System.out.println(" There are no items in your inventory.");
                    } else {
                        theInventory.printItems();
                        theInventory.sellItem();
                    }
                    break;
                case 3:
                    if (theInventory.isListEmpty()) {
                        System.out.println(" There are no items in your inventory.");
                    } else {
                        theInventory.printItems();
                        theInventory.removeItem();
                    }
                    break;
                case 4:
                    if (theInventory.isListEmpty()) {
                        System.out.println(" There are no items in your inventory.");
                    } else {
                        theInventory.printItems();
                        theInventory.changeQuantity();
                        }

                    break;
                case 5:
                    if (theInventory.isListEmpty()) {
                        System.out.println(" There are no items in your inventory.");
                    } else {
                        theInventory.printItems();
                        theInventory.changePrice();
                    }
                    break;
                case 6:
                    choice = 6;
                    System.out.println("You've opted to quit.");
                    break;

            }
        } while (choice != 6);
        System.out.println("Thank you for using my inventory system!");
    }
}
