package lab6;

public class Main {

    public static void main(String[] args) {

        Antresol<String> bookShelf = new Antresol<>(5);
        bookShelf.placeItem("Book 1");
        bookShelf.placeItem("Book 3");
        bookShelf.placeItem("Book 2");
        bookShelf.placeItem("Book 4");

        System.out.println("Items in the attic (books):");
        bookShelf.displayItems();
        System.out.println("Maximum book (alphabetically): " + bookShelf.findMax());

        Antresol<Integer> boxShelf = new Antresol<>(5);
        boxShelf.placeItem(3);  
        boxShelf.placeItem(1);
        boxShelf.placeItem(4);
        boxShelf.placeItem(2);

        System.out.println("\nItems in the attic (boxes):");
        boxShelf.displayItems();
        System.out.println("Minimum box (by size): " + boxShelf.findMin()); 
    }
}
