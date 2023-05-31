package adtbag;

public class BagArray<T> implements BagInterface<T> {

    private static final int DEFAULT_CAPACITY = 25;

    private int numberOfItems;
    private T[] items;

    public BagArray() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
	public BagArray(int size) {
        
        items = (T[]) new Object[size];
        numberOfItems = 0;
    }

    @Override
   
    public int getCurrentSize() {
        return numberOfItems;
    }

    @Override
    
    public boolean isEmpty() {
        return numberOfItems == 0;
    }

    @Override
    
    public boolean add(T item) {
        if (numberOfItems == items.length) {
            increaseCapacity();
        }
        items[numberOfItems] = item;
        numberOfItems++;
        return true;
    }

    @Override
    
    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Bag is empty");
        }

        numberOfItems--;
        T item = items[numberOfItems];
        items[numberOfItems] = null;
        return item;
    }

    @Override
    
    public boolean remove(T item) {
        for (int index = 0; index < numberOfItems; index++) {
            if (item.equals(items[index])) {
                numberOfItems--;
                items[index] = items[numberOfItems];
                items[numberOfItems] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }

    @Override
    
    public int getFrequencyOf(T item) {
        int frequency = 0;
        for (int index = 0; index < numberOfItems; index++) {
            if (items[index].equals(item)) {
                frequency++;
            }
        }
        return frequency;
    }

    @Override
    
    public boolean contains(T item) {
        for (int index = 0; index < numberOfItems; index++) {
            if (items[index].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
	@Override
    
    public T[] toArray() {
        
        
        T[] result = (T[]) new Item[numberOfItems];
        for ( int index = 0; index < numberOfItems; index++)
        {
            result[index] = items[index];
        }
        
        return result;
    }

    
    private void increaseCapacity() {
        @SuppressWarnings("unchecked")
		T[] newItems = (T[]) new Object[numberOfItems*2];
        for ( int index = 0; index < numberOfItems; index++){
            newItems[index] = items[index];
        }
        
        items = newItems;
    }

}