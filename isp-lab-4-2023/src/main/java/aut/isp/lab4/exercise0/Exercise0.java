package aut.isp.lab4.exercise0;

public class Exercise0 {
    public static void main(String[] args) {

        Engine e1 = new DieselEngine(100, 15);
        //Car car1 = new Car(e1, "Red");
        Car car1 = Car.getInstance(e1, "Red");
        car1.startCar();

        car1.stopCar();

        Engine e2 = new ElectricEngine(50,12);

        Car car2 = Car.getInstance(e2, "blue");
        //Car car2 = new Car(e2, "blue");

        for(int i=0;i<5;i++) {
            car2.startCar();
            car2.stopCar();
        }

    }
}
