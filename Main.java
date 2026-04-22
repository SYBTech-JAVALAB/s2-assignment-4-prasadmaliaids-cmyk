import java.util.Scanner;

// Abstract class
abstract class BankAccount {
    double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    abstract void deposit(double amount);
    abstract void withdraw(double amount);

    void displayBalance() {
        System.out.println("Final Balance: Rs " + balance);
    }
}

// Savings Account
class SavingsAccount extends BankAccount {

    SavingsAccount(double balance) {
        super(balance);
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: Rs " + amount);
    }

    void withdraw(double amount) {
        if ((balance - amount) < 1000) {
            System.out.println("Cannot withdraw! Minimum balance Rs 1000 required.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: Rs " + amount);
        }
    }
}

// Current Account
class CurrentAccount extends BankAccount {

    CurrentAccount(double balance) {
        super(balance);
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: Rs " + amount);
    }

    void withdraw(double amount) {
        if ((balance - amount) < -5000) {
            System.out.println("Overdraft limit exceeded!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: Rs " + amount);
        }
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account type (1: Savings, 2: Current): ");
        int choice = sc.nextInt();

        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();

        BankAccount acc;

        if (choice == 1) {
            acc = new SavingsAccount(balance);
        } else {
            acc = new CurrentAccount(balance);
        }

        System.out.print("Enter deposit amount: ");
        double dep = sc.nextDouble();
        acc.deposit(dep);

        System.out.print("Enter withdrawal amount: ");
        double wd = sc.nextDouble();
        acc.withdraw(wd);

        acc.displayBalance();

        sc.close();
    }
}