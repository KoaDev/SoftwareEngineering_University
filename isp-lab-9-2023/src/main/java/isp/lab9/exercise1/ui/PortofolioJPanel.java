package isp.lab9.exercise1.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

public class PortofolioJPanel extends JPanel {
    private JTable portfolioTable;
    private final StockMarketJFrame parentFrame;
    private JPanel bottomPanel;


    public PortofolioJPanel(StockMarketJFrame parentFrame) {
        this.parentFrame = parentFrame;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        String[] columns = {"Symbol", "Quantity", "Price Per Unit", "Total Price"};
        Object[][] data = {};
        portfolioTable = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(portfolioTable);

        add(scrollPane, BorderLayout.CENTER);

        bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(new JLabel("Available Funds: " + parentFrame.getPortfolio().getCash().toString()));

        add(bottomPanel, BorderLayout.SOUTH);
    }


    public void refreshData() {
        try {
            String[] columns = {"Symbol", "Quantity", "Price Per Unit", "Total Price"};

            Map<String, Integer> portfolio = parentFrame.getPortfolio().getShares();
            Object[][] data = new Object[portfolio.size()][4];

            int i = 0;
            for (Map.Entry<String, Integer> entry : portfolio.entrySet()) {
                String symbol = entry.getKey();
                int quantity = entry.getValue();

                BigDecimal pricePerUnit = parentFrame.getMarketService().getStockPrice(symbol);
                BigDecimal totalPrice = pricePerUnit.multiply(new BigDecimal(quantity));

                data[i][0] = symbol;
                data[i][1] = quantity;
                data[i][2] = pricePerUnit;
                data[i][3] = totalPrice;

                i++;
            }

            bottomPanel.removeAll();
            bottomPanel.add(new JLabel("Available Funds: " + parentFrame.getPortfolio().getCash().toString()));
            bottomPanel.revalidate();

            portfolioTable.setModel(new DefaultTableModel(data, columns));
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }






}