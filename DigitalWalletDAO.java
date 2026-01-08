import java.util.List;

public interface DigitalWalletDAO {
    void addTransaction(WalletTransaction transaction);
    WalletTransaction getTransaction(String transactionId);
    void updateTransaction(String transactionId, double newAmount);
    void deleteTransaction(String transactionId);
    List<WalletTransaction> getAllTransactions();
    void sortByTransactionId();
    void sortByAmount();
}
