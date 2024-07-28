package behavioral.state;

/**
 * The main class to demonstrate the functionality of the vending machine.
 */
public class Vending {

    /**
     * Entry point of the application.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        System.out.println("Current State: " + vendingMachine.getCurrentStateName());

        vendingMachine.selectItem();

        vendingMachine.insertCoin();
        System.out.println("Current State: " + vendingMachine.getCurrentStateName());

        vendingMachine.insertCoin();

        vendingMachine.selectItem();
        System.out.println("Current State: " + vendingMachine.getCurrentStateName());

        vendingMachine.dispenseItem();
        System.out.println("Current State: " + vendingMachine.getCurrentStateName());

        vendingMachine.insertCoin();
        vendingMachine.selectItem();
        System.out.println("Current State: " + vendingMachine.getCurrentStateName());

        vendingMachine.dispenseItem();
        System.out.println("Current State: " + vendingMachine.getCurrentStateName());
    }
}
