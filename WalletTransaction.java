public class WalletTransaction implements Comparable<WalletTransaction> {
    private String transactionId;
    private String upiId;
    private double amount;

    public WalletTransaction(String transactionId, String upiId, double amount) {
        this.transactionId = transactionId;
        this.upiId = upiId;
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getUpiId() {
        return upiId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public int compareTo(WalletTransaction other) {
        return this.transactionId.compareTo(other.transactionId);
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionId + ", UPI ID: " + upiId + ", Amount: " + amount;
    }
  }
