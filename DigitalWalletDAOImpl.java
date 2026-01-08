import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class DigitalWalletDAOImpl implements DigitalWalletDAO {
    private List<WalletTransaction> transactions;
    private static final String UPI_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String FILE_NAME = "transactions.txt";

    public DigitalWalletDAOImpl() {
        this.transactions = new ArrayList<>();
        loadTransactionsFromFile();
    }

    private void loadTransactionsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String transactionId = parts[0];
                    String upiId = parts[1];
                    double amount = Double.parseDouble(parts[2]);
                    WalletTransaction transaction = new WalletTransaction(transactionId, upiId, amount);
                    transactions.add(transaction);
                }
            }
        } catch (IOException e) {
            // File not found or error reading file
        }
    }

    private void saveTransactionsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (WalletTransaction transaction : transactions) {
                writer.write(transaction.getTransactionId() + "," + transaction.getUpiId() + "," + transaction.getAmount());
                writer.newLine();
            }
        } catch (IOException e) {
            // Error writing to file
        }
    }

    @Override
    public void addTransaction(WalletTransaction transaction) {
        if (!Pattern.matches(UPI_PATTERN, transaction.getUpiId())) {
            throw new IllegalArgumentException("Invalid UPI ID");
        }
        if (transaction.getAmount() < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        transactions.add(transaction);
        saveTransactionsToFile();
    }

    @Override
    public WalletTransaction getTransaction(String transactionId) {
        for (WalletTransaction transaction : transactions) {
            if (transaction.getTransactionId().equals(transactionId)) {
                return transaction;
            }
        }
        return null;
    }

    @Override
    public void updateTransaction(String transactionId, double newAmount) {
        WalletTransaction transaction = getTransaction(transactionId);
        if (transaction != null) {
            if (newAmount < 0) {
                throw new IllegalArgumentException("Amount cannot be negative");
            }
            transaction.setAmount(newAmount);
            saveTransactionsToFile();
        }
    }

    @Override
    public void deleteTransaction(String transactionId) {
        transactions.removeIf(transaction -> transaction.getTransactionId().equals(transactionId));
        saveTransactionsToFile();
    }

    @Override
    public List<WalletTransaction> getAllTransactions() {
        return transactions;
    }

    @Override
    public void sortByTransactionId() {
        Collections.sort(transactions);
    }

    @Override
    public void sortByAmount() {
        Collections.sort(transactions, new AmountComparator());
    }
 }
