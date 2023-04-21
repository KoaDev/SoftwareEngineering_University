package isp.lab7.safehome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DoorLockController implements ControllerInterface {
    private final Map<Tenant, AccessKey> tenantAccessMap = new HashMap<>();
    private final Door door = new Door();
    private int attemptsCount = 0;
    private final List<AccessLog> accessLog = new ArrayList<>();

    public DoorStatus enterPin(String pin) throws InvalidPinException, TooManyAttemptsException {
        String logMessage = "";

        if (attemptsCount >= 2 && !MASTER_KEY.equals(pin)) {
            logMessage = "Too many attempts. Door locked.";
            accessLog.add(new AccessLog(logMessage));
            throw new TooManyAttemptsException(logMessage);
        }

        if (MASTER_KEY.equals(pin)) {
            attemptsCount = 0;
            door.changeStatus();
            logMessage = "Master key used. Door status: " + door.getStatus();
            accessLog.add(new AccessLog(logMessage));
            return door.getStatus();
        }

        Tenant tenant = null;
        for (Map.Entry<Tenant, AccessKey> entry : tenantAccessMap.entrySet()) {
            if (entry.getValue().getPin().equals(pin)) {
                tenant = entry.getKey();
                break;
            }
        }

        if (tenant == null) {
            attemptsCount++;
            logMessage = "Invalid PIN entered. Attempt " + attemptsCount;
            accessLog.add(new AccessLog(logMessage));
            throw new InvalidPinException(logMessage);
        }

        attemptsCount = 0;
        door.changeStatus();
        logMessage = "Door status: " + door.getStatus() + " for tenant: " + tenant.getName();
        accessLog.add(new AccessLog(logMessage));
        return door.getStatus();
    }

    public void addTenant(String pin, String name) throws TenantAlreadyExistsException {
        for (Tenant tenant : tenantAccessMap.keySet()) {
            if (tenant.getName().equals(name)) {
                throw new TenantAlreadyExistsException("Tenant " + name + " already exists.");
            }
        }
        tenantAccessMap.put(new Tenant(name), new AccessKey(pin));
    }

    public void removeTenant(String name) throws TenantNotFoundException {
        Tenant tenantToRemove = null;
        for (Tenant tenant : tenantAccessMap.keySet()) {
            if (tenant.getName().equals(name)) {
                tenantToRemove = tenant;
                break;
            }
        }
        if (tenantToRemove == null) {
            throw new TenantNotFoundException("Tenant " + name + " not found.");
        }
        tenantAccessMap.remove(tenantToRemove);
    }

    public List<AccessLog> getAccessLog() {
        return accessLog;
    }
}