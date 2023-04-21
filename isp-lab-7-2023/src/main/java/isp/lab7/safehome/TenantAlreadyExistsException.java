package isp.lab7.safehome;

class TenantAlreadyExistsException extends Exception {
    public TenantAlreadyExistsException(String message) {
        super(message);
    }
}
