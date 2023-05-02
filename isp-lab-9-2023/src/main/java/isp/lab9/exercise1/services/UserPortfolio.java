/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isp.lab9.exercise1.services;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Uses Lombok to get rid of boilerplate code.
 *
 * @author mihai.hulea
 * @author radu.miron
 */
@Data // it creates getters, setters, equals(), hashCode() and toString() (at compile time)
@AllArgsConstructor // it creates the constructor with arguments for all the attributes (at compile time)
public class UserPortfolio {
    private BigDecimal cash;

    private Map<String, Integer> shares; // a map of number of shares by stock symbol

    public void buyStock(String symbol, int quantity, BigDecimal totalCost) {
        if (totalCost.compareTo(cash) > 0) {
            // If the total cost is greater than the available cash, do not allow the purchase
            throw new IllegalArgumentException("Not enough funds to make this purchase");
        } else {
            // Otherwise, subtract the total cost from the available cash and add the purchased shares to the portfolio
            cash = cash.subtract(totalCost);
            shares.put(symbol, shares.getOrDefault(symbol, 0) + quantity);
        }
    }

}
