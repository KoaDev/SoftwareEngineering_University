package isp.lab3.exercise5;

import org.junit.Test;
import static org.junit.Assert.*;

public class Exercise5Test {
    @Test
    public void testDisplayProducts() {
        Exercise5 vm = new Exercise5();
        String expectedOutput = "{1=Coke, 2=Pepsi, 3=Sprite, 4=Fanta}";
        assertEquals(expectedOutput, vm.displayProducts());
    }

    @Test
    public void testInsertCoin() {
        Exercise5 vm = new Exercise5();
        vm.insertCoin(10);
        vm.insertCoin(50);
        vm.insertCoin(100);
        assertEquals(160, vm.displayCredit());
    }

    @Test
    public void testSelectProductWithInsufficientCredit() {
        Exercise5 vm = new Exercise5();
        String result = vm.selectProduct(1);
        assertEquals("Insufficient credit. Please insert coins.", result);
    }

    @Test
    public void testSelectProductWithEnoughCredit() {
        Exercise5 vm = new Exercise5();
        vm.insertCoin(100);
        String result = vm.selectProduct(1);
        assertEquals("Selected product: Coke", result);
    }
}