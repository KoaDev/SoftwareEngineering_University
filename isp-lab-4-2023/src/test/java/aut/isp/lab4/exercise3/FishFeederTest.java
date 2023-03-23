package aut.isp.lab4.exercise3;

import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class FishFeederTest {

    @Test
    public void testFillUp() {
        FishFeeder fishFeeder = new FishFeeder("Acme", "Model X", 10);

        // Vérifier que la méthode fillUp() remplit correctement le distributeur de nourriture
        fishFeeder.feed();
        fishFeeder.fillUp();
        assertEquals(14, fishFeeder.getMeals());
    }

    @Test
    public void testFeed() {
        FishFeeder fishFeeder = new FishFeeder("Acme", "Model X", 4);

        // Vérifier que la méthode feed() diminue correctement le nombre de repas
        fishFeeder.feed();
        assertEquals(3, fishFeeder.getMeals());
        fishFeeder.feed();
        assertEquals(2, fishFeeder.getMeals());
        fishFeeder.feed();
        assertEquals(1, fishFeeder.getMeals());

        // Vérifier que la méthode feed() ne peut pas être appelée si le distributeur est vide
        fishFeeder.feed();
        assertEquals(0, fishFeeder.getMeals());
    }
}