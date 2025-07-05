import java.util.Scanner;

class ATM {
    private double balance;
    private String transactionHistory = "";
    
    public void viewTransactionHistory() {
        System.out.println("Transaction History:");
        System.out.println(transactionHistory.isEmpty() ? "No transactions yet." : transactionHistory);
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory += "Withdrawn: ₹" + amount + "\n";
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory += "Deposited: ₹" + amount + "\n";
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void transfer(double amount, String recipient) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory += "Transferred: ₹" + amount + " to " + recipient + "\n";
            System.out.println("₹" + amount + " transferred to " + recipient);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();
        
        System.out.print("Enter User ID: ");
        System.out.print("Enter PIN: ");

        // Assume validation success
        int choice;
        do {
            System.out.println("\n1. Transaction History\n2. Withdraw\n3. Deposit\n4. Transfer\n5. Quit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    atm.viewTransactionHistory();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    atm.withdraw(sc.nextDouble());
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ₹");
                    atm.deposit(sc.nextDouble());
                    break;
                case 4:
                    System.out.print("Enter recipient name: ");
                    String recipient = sc.next();
                    System.out.print("Enter amount to transfer: ₹");
                    atm.transfer(sc.nextDouble(), recipient);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
        sc.close();
    }
}
