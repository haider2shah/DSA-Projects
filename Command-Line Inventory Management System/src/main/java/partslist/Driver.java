package partslist;

import java.util.Scanner;

class Inventory {
    private class Part {
        static final short UNUSED = 0;
        static final short USED = 1;
        static final short DELETED = 2;

        short mark = UNUSED;
        String description;
        String partNumber;
        int quantity;
    }

    private Part[] parts = new Part[10];

    public Inventory() {
        for (int i = 0; i < parts.length; i++) {
            parts[i] = new Part(); 
        }
    }

    public Inventory(int s) {
        parts = new Part[s];
        for (int i = 0; i < s; i++) {
            parts[i] = new Part(); 
        }
    }

    public int size() {
        return parts.length;
    }

    public void clear() {
        for (Part part : parts) {
            part.mark = Part.UNUSED;
        }
    }

    public boolean isFull() {
        for (Part part : parts) {
            if (part.mark == Part.UNUSED || part.mark == Part.DELETED) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        for (Part part : parts) {
            if (part.mark == Part.USED) {
                return false;
            }
        }
        return true;
    }

    public void insert(String partNumber, String description, int quantity) {
        if (!isFull()) {
            int index = hash(partNumber);
            int probe = index;
    
            while (parts[probe].mark == Part.USED) {
                probe = (probe + 1) % parts.length; 
            }
    
            parts[probe].partNumber = partNumber;
            parts[probe].description = description;
            parts[probe].quantity = quantity;
            parts[probe].mark = Part.USED;
        }
    }


    public void remove(String partNumber) {
        if (!isEmpty()) {
            int probe = hash(partNumber);
            int i = 0;
    
            while (i < parts.length && parts[probe].mark != Part.UNUSED) {
                if (parts[probe].partNumber.equals(partNumber)) {
                    parts[probe].mark = Part.DELETED;
                    break;
                }
                i++;
                probe = (probe + 1) % parts.length; 
            }
        }
    }



    public int find(String partNumber) {
    if (!isEmpty()) {
        int probe = hash(partNumber);      
        boolean found = false;           
        int i = 0;                         
        int quantity = -1;                

        while (i < parts.length && parts[probe].mark != Part.UNUSED && !found) {
            if (parts[probe].mark == Part.USED && parts[probe].partNumber.equals(partNumber)) {
                found = true;              
                quantity = parts[probe].quantity; 
            }

            probe = (probe + 1) % parts.length; 
            i++;                                
        }

        return quantity; 
    }

    return -1;
}


    public void print() {
        System.out.println("\nPARTS INVENTORY");
        System.out.printf("%-15s %-10s %s\n", "Desc.", "Part#", "Qty");
        for (Part part : parts) {
            if (part.mark == Part.USED) {
                System.out.printf("%-15s %-10s %d\n", part.description, part.partNumber, part.quantity);
            }
        }
    }

    private int hash(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum += key.charAt(i);
        }
        return sum % parts.length;
    }
}

public class Driver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of parts you will enter: ");
        int count = input.nextInt();
        input.nextLine(); 

        Inventory inv = new Inventory(count);

        for (int i = 0; i < count; i++) {
            System.out.println("\nEntry #" + (i + 1) + "....");
            System.out.print("   Enter the part description: ");
            String desc = input.nextLine();
            System.out.print("   Enter the part number: ");
            String number = input.nextLine();
            System.out.print("   Enter the part quantity: ");
            int qty = input.nextInt();
            input.nextLine(); 

            inv.insert(number, desc, qty);
        }

        inv.print();

        System.out.print("\nEnter part number to search for: ");
        String searchKey = input.nextLine();
        int stock = inv.find(searchKey);
        if (stock >= 0) {
            System.out.println("\nQuantity in Stock: " + stock + ".");
        } else {
            System.out.println("Part not found.");
        }

        System.out.print("\nEnter part number for part to remove: ");
        String removeKey = input.nextLine();
        inv.remove(removeKey);

        inv.print();
    }
}

