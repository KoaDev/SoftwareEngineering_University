package isp.lab5.exercise1;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum TransactionType {
    WITHDRAW,
    CHECK_MONEY,
    CHANGE_PIN,
    FUNDING,
}


public class Exercise1 {

    public static void main(String[] args) {
        Bank bank = new Bank();
        Card card = new Card("123456789", "1234");
        ATM atm = new ATM(bank);
        atm.insertCard(card, "1234");

        // test withdraw
        double amount = 100.0;
        Transaction withdrawTransaction = new Transaction(card.getNumber(), amount, card.getPin(), TransactionType.WITHDRAW);
        String withdrawResult = bank.executeTransaction(withdrawTransaction);
        System.out.println(withdrawResult);

        // test checkMoney
        Transaction checkMoneyTransaction = new Transaction(card.getNumber(), 0.0, card.getPin(), TransactionType.CHECK_MONEY);
        double balance = Double.parseDouble(bank.executeTransaction(checkMoneyTransaction));
        System.out.println("Balance: " + balance);

        // test changePin
        String oldPin = "1234";
        String newPin = "5678";
        Transaction changePinTransaction = new Transaction(card.getNumber(), oldPin, newPin, TransactionType.CHANGE_PIN, card);
        String changePinResult = bank.executeTransaction(changePinTransaction);
        System.out.println(changePinResult);

        atm.changePin(oldPin, newPin, card);

        atm.removeCard();
    }
}

class Card {
    private String number;
    private String pin;

    public Card(String number, String pin) {
        this.number = number;
        this.pin = pin;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public boolean checkPin(String pin) {
        return this.pin.equals(pin);
    }
}

class Account {
    private String owner;
    private double balance;

    public Account(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class Bank {
    private final Map<String, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
        Account account1 = new Account("John Doe", 500.0);
        Account account2 = new Account("Jane Smith", 1000.0);
        accounts.put("123456789", account1);
        accounts.put("987654321", account2);
    }

    public String executeTransaction(Transaction t) {
        if (t.getType() == TransactionType.WITHDRAW) {
            Account account = accounts.get(t.getCardId());
            if (account == null) {
                return "Error: Account not found.";
            } else if (account.getBalance() < t.getAmount()) {
                return "Error: Insufficient funds.";
            } else {
                account.setBalance(account.getBalance() - t.getAmount());
                return "Transaction successful: withdrew " + t.getAmount() + " from card " + t.getCardId() + ".";
            }
        } else if (t.getType() == TransactionType.CHECK_MONEY) {
            Account account = accounts.get(t.getCardId());
            if (account == null) {
                return "Error: Account not found.";
            } else {
                return Double.toString(account.getBalance());
            }
        } else if (t.getType() == TransactionType.CHANGE_PIN) {
            System.out.println(t.getOldPin());
            System.out.println(t.getNewPin());
            t.setNewPin(t.getNewPin());
            return "PIN successfully changed for card " + t.getCardId() + ".";
        } else if (t.getType() == TransactionType.FUNDING) {
            Account account = accounts.get(t.getCardId());
            if (account == null) {
                return "Error: Account not found.";
            } else {
                account.setBalance(account.getBalance() + t.getAmount());
                return "Transaction successful: added " + t.getAmount() + " to card " + t.getCardId() + ".";
            }
        } else {
            return "Error: Invalid transaction type.";
        }
    }

    public Account getAccountByCardId (String cardId){
        return accounts.get(cardId);
    }
}


class ATM {
    private Card card;
    private final Bank bank;

    public ATM(Bank bank) {
        this.bank = bank;
    }

    public void insertCard(Card card, String pin) {
        if (card.checkPin(pin)) {
            this.card = card;
            System.out.println("Card inserted successfully.");
        } else {
            System.out.println("Invalid PIN. Card not inserted.");
        }
    }

    public void removeCard() {
        this.card = null;
        System.out.println("Card removed successfully.");
    }

    public void withdraw(double amount) {
        if (card == null) {
            System.out.println("Error: No card inserted.");
        } else {
            Transaction t = new Transaction(card.getNumber(), amount, card.getPin(), TransactionType.WITHDRAW);
            String result = bank.executeTransaction(t);
            System.out.println(result);
        }
    }

    public void checkMoney() {
        if (card == null) {
            System.out.println("Error: No card inserted.");
        } else {
            Transaction t = new Transaction(card.getNumber(), 0.0, card.getPin(), TransactionType.CHECK_MONEY);
            double balance = Double.parseDouble(bank.executeTransaction(t));
            System.out.println("Balance: " + balance);

        }
    }

    public void changePin(String oldPin, String newPin, Card card) {
        if (card == null) {
            System.out.println("Error: No card inserted.");
        } else {
            Transaction t = new Transaction(card.getNumber(), oldPin, newPin, TransactionType.CHANGE_PIN, card);
            String result = bank.executeTransaction(t);
            System.out.println(result);
        }
    }
}

class Transaction {
    private String cardId;
    private double amount;
    private final String oldPin;
    private String newPin;
    private TransactionType type;

    private Card card;

    public Transaction(String cardId, double amount, String pin, TransactionType type) {
        this.cardId = cardId;
        this.amount = amount;
        this.oldPin = pin;
        this.type = type;
    }

    public Transaction(String cardId, String oldPin, String newPin, TransactionType type, Card card) {
        this.cardId = cardId;
        this.oldPin = oldPin;
        this.newPin = newPin;
        this.type = type;
        this.card = card;
    }

    public Transaction(String cardNumber, String amount, String oldPin, String newPin, TransactionType type) {
        this.cardId = cardNumber;
        this.amount = Double.parseDouble(amount);
        this.oldPin = oldPin;
        this.newPin = newPin;
        this.type = type;
    }


    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getOldPin() {
        return oldPin;
    }

    public void setOldPin(String oldPin) {
        this.card.setPin(oldPin);
    }

    public String getNewPin() {
        return newPin;
    }

    public void setNewPin(String newPin) {
        this.card.setPin(newPin);
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }
}
