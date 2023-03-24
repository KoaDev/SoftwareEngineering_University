package isp.lab5.exercise1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Exercise1Test {

        Bank bank = new Bank();
        Card card = new Card("123456789", "1234");
        ATM atm = new ATM(bank);

    @Test
    public void testWithdrawal() {
        // test withdraw
        double amount = 100.0;
        Transaction withdrawTransaction = new Transaction(card.getNumber(), amount, card.getPin(), TransactionType.WITHDRAW);
        String withdrawResult = bank.executeTransaction(withdrawTransaction);

        assertEquals("Transaction successful: withdrew 100.0 from card 123456789.", withdrawResult);
    }

    @Test
    public void testDeposit() {
        Transaction deposit = new Transaction(card.getNumber(), "100.0", "1234", null, TransactionType.FUNDING);
        assertEquals("Transaction successful: added 100.0 to card 123456789.", bank.executeTransaction(deposit));
    }

    @Test
    public void testChangePin() {
        Transaction changePinTransaction = new Transaction(card.getNumber(), "1234", "0000", TransactionType.CHANGE_PIN, card);
        bank.executeTransaction(changePinTransaction);
        atm.removeCard();
        assertEquals("0000", card.getPin());
    }

    @Test
    public void testCheckMoney() {
        Transaction checkMoneyTransaction = new Transaction(card.getNumber(), 0.0, card.getPin(), TransactionType.CHECK_MONEY);
        double balance = Double.parseDouble(bank.executeTransaction(checkMoneyTransaction));
        assertEquals(500.0, balance, 0.01);
    }

}