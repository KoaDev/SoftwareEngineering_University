package isp.lab7.safehome;

class TenantNotFoundException extends Exception {
    public TenantNotFoundException(String message) {
        super(message);
    }
}