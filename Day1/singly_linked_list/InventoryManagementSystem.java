package Day1.singly_linked_list;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class Inventory {
    String itemName;
    int itemId;
    int quantity;
    int price;
    Inventory next;
    Inventory(String itemName, int itemId, int price, int quantity){
        this.itemName=itemName;
        this.itemId=itemId;
        this.price=price;
        this.quantity=quantity;
        this.next = null;
    }
}
public class InventoryManagementSystem {
    private Inventory head;

    
    //add item in the first place
    public void addFirst(String itemName, int itemId, int price, int quantity) {
        Inventory newItem = new Inventory(itemName, itemId, price, quantity);
        if (head == null) {
            head = newItem;
            return;
        }
        head.next = newItem;
        head = newItem;
    }

    //add item at last index
    public void addFLast(String itemName, int itemId, int price, int quantity) {
        Inventory newItem = new Inventory(itemName, itemId, price, quantity);
        if (head == null) {
            head = newItem;
            return;
        }
        Inventory current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newItem;
    }

    //adding item at specific position
    public void addSpecificPosition(int position, String itemName, int itemId, int price, int quantity) {
        Inventory newItem = new Inventory(itemName, itemId, price, quantity);
        Inventory current = head;
        if (position < 0) {
            System.out.println("invalid position");
            return;
        }
        if (position == 1) {
            addFirst(itemName, itemId, price, quantity);
            return;
        }
        for (int i = 1; i < position - 1; i++) {
            if (current == null) {
                System.out.println("Out of bound position");
                return;
            }
            current = current.next;
        }
        newItem = current.next;
        current.next = newItem;
    }

    //Remove an item based on Item ID.
    public void removeBasedONItemId(int itemId) {
        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item with item id " + itemId + " is removed ");
        }
        Inventory current = head;
        while (current.next != null && current.itemId != itemId) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Item with item id " + itemId + " does not found");
            return;
        } else {
            current.next = current.next.next;
            System.out.println("Item with item id " + itemId + " is removed ");
        }
    }

    //Update the quantity of an item by Item ID.
    public void updateBasedONItemId(int itemId, int quantity) {
        Inventory current = head;
        if (head.itemId == itemId) {
            head.quantity = quantity;
            return;
        }
        while (current != null) {
            if (current.itemId == itemId) {
                current.quantity = quantity;
                System.out.println("item with item id " + itemId + " is updated");
            }
            current = current.next;
        }

        System.out.println("item with item id " + itemId + " does not found");
    }

    //Search for an item based on Item ID or Item Name.
    public void searchBasedONItemId(int itemId) {
        Inventory current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                System.out.println("item with item id " + itemId + " is found");
                return;
            }
            current = current.next;
        }
    }
    // Display all items in the inventory
    public void displayAll() {
        Inventory current = head;
        if (current == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("Inventory Details:");
        System.out.println("Item Name\tItem ID\tPrice\tQuantity");
        while (current != null) {
            System.out.println(current.itemName + "\t\t" + current.itemId + "\t" + current.price + "\t" + current.quantity);
            current = current.next;
        }
    }


    //Calculate and display the total value of inventory (Sum of Price * Quantity for each item).
    public void displayTotalValue() {
        int totalPrice = 0;
        int totalQuantity = 0;
        int totalValue = 0;
        Inventory current = head;
        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        while (current != null) {
            totalPrice += current.price;
            totalQuantity += current.quantity;
            current = current.next;
        }
        totalValue = totalQuantity * totalPrice;
        System.out.println("total value of inventory is " + totalValue);
    }
    //Sort the inventory based on Item Name or Price in ascending or descending order.

    public void sort(String sortBy, boolean ascending) {
        ArrayList<Inventory> al = new ArrayList<>();
        Inventory current = head;

        // Transfer all linked list nodes to the ArrayList
        while (current != null) {
            al.add(new Inventory(current.itemName, current.itemId, current.quantity, current.price));
            current = current.next;
        }

        // Sort the ArrayList based on the chosen property

        al.sort((a, b) -> ascending ? a.itemName.compareTo(b.itemName) : b.itemName.compareTo(a.itemName));
        // Reconstruct the linked list from the sorted ArrayList
        head = null;
        for (Inventory item : al) {
            addFLast(item.itemName, item.itemId, item.price, item.quantity);
        }

        System.out.println("Inventory sorted by " + sortBy + " in " + (ascending ? "ascending" : "descending") + " order.");
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        // Adding some dummy data
        ims.addFirst("Laptop", 101, 1000, 5);
        ims.addFLast("Smartphone", 102, 800, 10);
        ims.addFLast("Tablet", 103, 500, 8);
        ims.addFLast("Monitor", 104, 300, 7);
        ims.addFLast("Keyboard", 105, 50, 20);

        System.out.println("Initial Inventory:");
        ims.displayTotalValue(); // Display the total value of inventory

        // Display all items (before sorting)
        System.out.println("\nInventory before sorting:");
        ims.displayAll();

        // Sort inventory by item name in ascending order
        ims.sort("name", true);
        System.out.println("\nInventory sorted by name (ascending):");
        ims.displayAll();

        // Update quantity of an item
        ims.updateBasedONItemId(102, 15);
        System.out.println("\nUpdated quantity for item ID 102:");
        ims.displayAll();

        // Remove an item by ID
        ims.removeBasedONItemId(104);
        System.out.println("\nInventory after removing item ID 104:");
        ims.displayAll();
    }
}
