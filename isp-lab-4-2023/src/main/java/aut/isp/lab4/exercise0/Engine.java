package aut.isp.lab4.exercise0;


/**
 * Base class.
 */
public class Engine {
    private boolean status;
    private int power;


    /**
     * Constructorul nu este descris in mod explicit in diagrama UML de clase dar este adaugat pentru a permite initializarea atributelor.
     *
     * @param power
     */
    public Engine(int power) {
        this.power = power;
    }

    public void startEngine(){
        status = true;
    }

    public void stopEngine(){
        status = false;
    }

    public boolean isStatus() {
        return status;
    }
}
