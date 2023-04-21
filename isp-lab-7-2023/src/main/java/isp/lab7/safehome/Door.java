package isp.lab7.safehome;

class Door {
    private DoorStatus status = DoorStatus.CLOSE;

    public void changeStatus() {
        status = (status == DoorStatus.OPEN) ? DoorStatus.CLOSE : DoorStatus.OPEN;
    }

    public DoorStatus getStatus() {
        return status;
    }
}