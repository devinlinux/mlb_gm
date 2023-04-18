package util;

public class StrictListContainsException extends Exception {

    public StrictListContainsException(Object element) {
        super(String.format("Could not add element to StrictList because StrictList already contains %s", element));
    }    
    
}
