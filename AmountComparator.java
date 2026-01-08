import java.util.Comparator;

public class AmountComparator implements Comparator<WalletTransaction> {
    @Override
    public int compare(WalletTransaction t1, WalletTransaction t2) {
        return Double.compare(t1.getAmount(), t2.getAmount());
    }
}
