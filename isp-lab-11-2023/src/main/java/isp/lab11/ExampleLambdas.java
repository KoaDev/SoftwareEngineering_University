package isp.lab11;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * @author Radu Miron
 * <p>
 * A lambda expression is "syntactic sugar" for anonymous classes that implement functional interfaces.
 * A functional interface is an interface that has a single abstract method.
 * Well know Functional Interface: ActionListener, Runnable, Consumer, Predicate, Function, BiFunction
 * <p>
 * Lets implement a simple application with widows that contains a button.
 * Clicking the button will create a new clone of the window at a random possition on the screen.
 * We'll implement the click event handler first as an anomymous class and then as a lambda expression.
 */
public class ExampleLambdas {
    public static void main(String[] args) {
        new Window();
    }

    static class Window extends JFrame {
        Window() {
            JButton button = new JButton("Click me!");

            // the event handler implemented as an anonymous class
            ActionListener buttonHandler = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    new Window();
                }
            };

            // the same event handler implemented as a lambda expression
            ActionListener buttonHandlerLambda = e -> new Window();

            // both implementations
//            button.addActionListener(buttonHandler);
            button.addActionListener(buttonHandlerLambda);

            this.setBounds(new Random().nextInt(800), new Random().nextInt(600), 300, 70);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.add(button);

            setVisible(true);
        }
    }
}
