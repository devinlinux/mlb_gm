package util;

public class StrictList<E> implements java.io.Serializable {
    
    /* fields and constants */
    @java.io.Serial
    private static final long serialVersionUID = 202304162127L;
    private final int MAXIMUM_CAPACITY;
    private Object[] elementData;
    private int size;
    
    /* constructor */
    public StrictList(int MAXIMUM_CAPACITY) {
        if (MAXIMUM_CAPACITY <= 0)
            this.MAXIMUM_CAPACITY = MAXIMUM_CAPACITY;
        else 
            throw new IllegalArgumentException("Size must be greater than 0");
        
            elementData = new Object[this.MAXIMUM_CAPACITY];
    }

    /* methods */

    //  method to check if the StrictList contains an object
    public boolean contains(Object o) {
        return this.indexOf(o) >= 0;
    }

    //  method to return the first occurance of a specified element in the StrictList
    public int indexOf(Object o) {
        Object[] elements = this.elementData;
        if (o == null) {
            for (int i = 0; i < this.MAXIMUM_CAPACITY; i++) {
                if (elements[i] == null) {
                    return i;    
                }
            }
        }      
        else {
            for (int i = 0; i < this.MAXIMUM_CAPACITY; i++) {
                if (o.equals(elements[i])) {
                    return i;   
                }
            }
        }       
        return -1;
    }

    //  method to quickly get a value from the elementData array
    @SuppressWarnings("unchecked")
    public E elementData(int index) {
        return (E) this.elementData[index];
    }

    //  method to return the element at the specified position in the StrictList
    public E get(int index) {
        return elementData(index);
    }

    //  method to set the element at the specified position in the StrictList
    public E set(int index, E element) {
        E previousValue = elementData(index);
        elementData[index] = element;
        return previousValue;
    }

    //  method to add an element to the end of the StrictList
    public boolean add(E element) throws StrictListSizeException, StrictListContainsException {
        if (size == elementData.length) 
            throw new StrictListSizeException(this.MAXIMUM_CAPACITY);
        if (contains(element))
            throw new StrictListContainsException(element);
        elementData[size] = element;
        size++;
        return true;
    }

    //  method to insert an element at a specific position in this StrictList
    public boolean add(int index, E element) throws StrictListSizeException, StrictListContainsException {
        if (size == this.elementData.length)
            throw new StrictListSizeException(this.MAXIMUM_CAPACITY);
        if (contains(element))
            throw new StrictListContainsException(element);
        Object[] elementData = new Object[this.elementData.length];
        for (int i = 0; i < index; i++) 
            elementData[i] = this.elementData[i];
        elementData[index] = element;
        for (int i = index + 1; i < this.elementData.length; i++) 
            elementData[i] = this.elementData[i - 1];
        this.elementData = elementData;
        return true;
    }

    //  add method to sort, also make similar to Set - no duplicates

}
