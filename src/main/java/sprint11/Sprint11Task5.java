package sprint11;

public class Sprint11Task5 {
    static class CheckingAccount {
        private double balance;
        private int number;

        public CheckingAccount(int number) {
            this.number = number;
        }

        public void deposit(double amount) {
            balance += amount;
        }

        public void withdraw(double amount) throws InsufficientAmountException {
            if (amount <= balance) {
                balance -= amount;
            } else {
                double needs = amount - balance;
                throw new InsufficientAmountException(needs);
            }
        }
        //some other code
    }

    static class BankDemo {
        public static void doOperations() {
            CheckingAccount c = new CheckingAccount(101);
            c.deposit(500.00);
            try {
                c.withdraw(100.00);
                c.withdraw(600.00);
            } catch (InsufficientAmountException e) {
                System.out.println(e.getMessage());
                System.out.println("Please, deposit at least $" + e.getAmount());
                e.printStackTrace();
            }
        }
    }

    static class InsufficientAmountException extends Exception {
        private final double amount;

        public InsufficientAmountException(double needs) {
            amount = needs;
        }

        public double getAmount() {
            return amount;
        }

        public String getMessage() {
            return "Sorry, but you are short $" + amount;
        }
    }
}
