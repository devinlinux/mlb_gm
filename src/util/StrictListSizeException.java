package util;

public class StrictListSizeException extends Exception {

    StrictListSizeException(int maximumCapacity) {
        super(String.format("The StrictList cannot exceed maximum capacity %d", maximumCapacity));
    }
    
}
