import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DigitalWalletDAO walletDAO = new DigitalWalletDAOImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Transaction");
            System.out.println("2. View Transaction");
            System.out.println("3. Update Transaction");
            System.out.println("4. Delete Transaction");
            System.out.println("5. Sort by Transaction ID");
            System.out.println("6. Sort by Amount");
            System.out.println("7. Display Transactions");
            System.out.println("8. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.println("Enter transaction ID:");
                        String transactionId = scanner.nextLine();
                        System.out.println("Enter UPI ID:");
                        String upiId = scanner.nextLine();
                        System.out.println("Enter amount:");
                        double amount = scanner.nextDouble();
                        scanner.nextLine(); // consume newline
                        WalletTransaction transaction = new WalletTransaction(transactionId, upiId, amount);
                        walletDAO.addTransaction(transaction);
                        break;
                    case 2:
                        System.out.println("Enter transaction ID:");
                        String tid = scanner.nextLine();
                        WalletTransaction t = walletDAO.getTransaction(tid);
                        if (t != null) {
                            System.out.println(t);
                        } else {
                            System.out.println("Transaction not found");
                        }
                        break;
                    case 3:
                        System.out.println("Enter transaction ID:");
                        String tid2 = scanner.nextLine();
                        System.out.println("Enter new amount:");
                        double newAmount = scanner.nextDouble();
                        scanner.nextLine(); // consume newline
                        walletDAO.updateTransaction(tid2, newAmount);
                        break;
                    case 4:
                        System.out.println("Enter transaction ID:");
                        String tid3 = scanner.nextLine();
                        walletDAO.deleteTransaction(tid3);
                        break;
                    case 5:
                        walletDAO.sortByTransactionId();
                        walletDAO.getAllTransactions().forEach(System.out::println);
                        break;
                    case 6:
                        walletDAO.sortByAmount();
                        walletDAO.getAllTransactions().forEach(System.out::println);
                        break;
                    case 7:
                        walletDAO.getAllTransactions().forEach(System.out::println);
                        break;
                    case 8:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
