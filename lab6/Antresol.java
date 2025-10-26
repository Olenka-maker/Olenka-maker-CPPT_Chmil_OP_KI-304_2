package lab6;


public class Antresol<T extends Comparable<T>> {

    private T[] items;  
    private int size;

    @SuppressWarnings("unchecked")
    public Antresol(int capacity) {
        items = (T[]) new Comparable[capacity];
        size = 0;
    }

   
    public boolean placeItem(T item) {
        if (size < items.length) {
            items[size++] = item;
            return true;
        }
        return false;
    }

    
    public boolean removeItem(T item) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item)) {
                System.arraycopy(items, i + 1, items, i, size - i - 1);
                items[--size] = null;
                return true;
            }
        }
        return false;
    }

    
    public T findMin() {
        if (size == 0) {
            return null;
        }
        T min = items[0];
        for (int i = 1; i < size; i++) {
            if (items[i].compareTo(min) < 0) {
                min = items[i];
            }
        }
        return min;
    }

   
    public T findMax() {
        if (size == 0) {
            return null;
        }
        T max = items[0];
        for (int i = 1; i < size; i++) {
            if (items[i].compareTo(max) > 0) {
                max = items[i];
            }
        }
        return max;
    }

   
    public void displayItems() {
        for (int i = 0; i < size; i++) {
            System.out.println(items[i]);
        }
    }
}
