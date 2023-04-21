package isp.lab7.safehome;

class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}