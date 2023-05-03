package isp.lab9.exercise1.ui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map;

public class SellJPanel extends JPanel {

    private final StockMarketJFrame mainFrame;
    private JComboBox<String> symbolComboBox;

    private JTextField availableFundsTextField;

    public SellJPanel(StockMarketJFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridLayout(2, 2));

        JPanel sellPanel = new JPanel();
        sellPanel.setLayout(new GridLayout(10, 2));

        JLabel availableFundsLabel = new JLabel("Available funds:");
        availableFundsTextField = new JTextField(mainFrame.getPortfolio().getCash().toPlainString() + " $");
        availableFundsTextField.setEditable(false);

        JLabel symbolLabel = new JLabel("Symbol:");
        symbolComboBox = new JComboBox<>();

        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityTextField = new JTextField();

        JLabel costLabel = new JLabel("Total cost:");
        JTextField costTextField = new JTextField();
        costTextField.setEditable(false);

        JButton sellButton = new JButton("Sell");

        sellButton.addActionListener(e -> {
            try {
                String symbol = (String) symbolComboBox.getSelectedItem();
                int quantity = Integer.parseInt(quantityTextField.getText());
                BigDecimal stockPrice = mainFrame.getMarketService().getStockPrice(symbol);
                BigDecimal totalCost = stockPrice.multiply(new BigDecimal(quantity));

                Map<String, Integer> shares = mainFrame.getPortfolio().getShares();
                int sharesOwned = shares.getOrDefault(symbol, 0);
                if (quantity > sharesOwned) {
                    JOptionPane.showMessageDialog(this,
                            "Not enough shares owned!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    mainFrame.getPortfolio().sellStock(symbol, quantity, totalCost);
                    availableFundsTextField.setText(mainFrame.getPortfolio().getCash().toPlainString() + " $");

                    mainFrame.getSellJPanel().refreshData();
                    mainFrame.getBuyJPanel().refreshData();
                    mainFrame.getPortfolioJPanel().refreshData();

                    JOptionPane.showMessageDialog(this,
                            "Stock sold successfully!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Invalid quantity value!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton costButton = new JButton("Get cost");
        costButton.addActionListener(e ->
                calculateTotalCostActionPerformed(quantityTextField, costTextField));

        sellPanel.add(availableFundsLabel);
        sellPanel.add(availableFundsTextField);
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(symbolLabel);
        sellPanel.add(symbolComboBox);
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(quantityLabel);
        sellPanel.add(quantityTextField);
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(costLabel);
        sellPanel.add(costTextField);
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(costButton);
        sellPanel.add(sellButton);
        add(sellPanel);
        add(new JPanel()); // empty cell in the grid
        add(new JPanel()); // empty cell in the grid
        add(new JPanel()); // empty cell in the grid

    }

    /**
     * Refreshes the symbols in the symbol combo box
     */

    /**
     * Refreshes the symbols in the symbol combo box
     */
    public void refreshData() {
        symbolComboBox.removeAllItems(); // supprime tous les éléments de la combo box
        for (String symbol : mainFrame.getPortfolio().getShares().keySet()) {
            symbolComboBox.addItem(symbol);
        }

        availableFundsTextField.setText(mainFrame.getPortfolio().getCash().toPlainString() + " $");

    }


    /**
     * Calculates the total transaction cost
     */
    private void calculateTotalCostActionPerformed(JTextField quantityTextField, JTextField totalCostTextField) {
        try {
            String symbol = (String) symbolComboBox.getSelectedItem();
            BigDecimal stockPrice = mainFrame.getMarketService().getStockPrice(symbol);

            try {
                int quantity = Integer.parseInt(quantityTextField.getText());
                DecimalFormat formatter = new DecimalFormat("#,##0.##");
                totalCostTextField.setText(
                        formatter.format(stockPrice.multiply(new BigDecimal(quantity))) + " $");
            } catch (NumberFormatException e) {
                totalCostTextField.setText("Invalid quantity value!");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}