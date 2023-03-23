package aut.isp.lab4.exercise0;

/**
 * Clasa derivata din Engine. Utilizeaza mecanismul de mostenire pentru a adaugat proprietati noi si/sau a modifica comportamentul
 * unor metode existente.
 */
public class DieselEngine extends Engine {

    private int fuelLevel;

    /**
     * Constructorul nu este descris in mod explicit in diagrama UML de clase dar este adaugat pentru a permite initializarea atributelor.
     *
     * @param power
     */
    public DieselEngine(int power, int fuelLevel) {
        //cuvantul cheie super se utilizeaza pentru a apela constructorul din clasa de baza.
        super(power);
        this.fuelLevel = fuelLevel;
    }

    @Override
    public void startEngine(){
        //cuvantul cheie super se poate utiliza OPTIONAL in cadrul metodelor pentru a forta apelarea unei metode dintr-o clasa de baza.
        //in cazul de fata apelul metodei din clasa de baza este necesar pentru a modifica startea motorului.
        if(fuelLevel>0) {
            super.startEngine();
            fuelLevel--;
            System.out.println("Diesel engine is started.");
        }else{
            System.out.println("Engine cannot be started. No fuel.");
        }
    }


}
