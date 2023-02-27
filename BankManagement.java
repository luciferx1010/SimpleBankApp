import java.util.Scanner;

class Bank {
    String accountHolderName;
    int accountNumber;
    double accountBalance;

    public Bank(String name, int accNo, double balance) {
        accountHolderName = name;
        accountNumber = accNo;
        accountBalance = balance;
    }

    public void deposit(double amount) {
        accountBalance += amount;
        System.out.println("Deposited: " + amount);
        System.out.println("New balance: " + accountBalance);
    }

    public void withdraw(double amount) {
        if (accountBalance < amount) {
            System.out.println("Insufficient balance.");
        } else {
            accountBalance -= amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("New balance: " + accountBalance);
        }
    }

    public void checkBalance() {
        System.out.println("Account balance: " + accountBalance);
    }
}

public class BankManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        System.out.print("Enter account number: ");
        int accNo = scanner.nextInt();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();

        Bank bank = new Bank(name, accNo, balance);

        while (true) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmt = scanner.nextDouble();
                    bank.deposit(depositAmt);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmt = scanner.nextDouble();
                    bank.withdraw(withdrawAmt);
                    break;
                case 3:
                    bank.checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
