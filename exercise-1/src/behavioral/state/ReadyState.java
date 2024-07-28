package behavioral.state;

/**
 * Handles the ready state of the vending machine.
 * In this state, the vending machine is currently allowing users to insert a coin.
 * It cannot allow users to select items or dispense items until a coin is inserted.
 */
public class ReadyState implements VendingMachineState{

    private VendingMachine vendingMachine;

    /**
     * Constructs the ready state of the vending machine.
     * @param vendingMachine the vending machine that the state belongs to.
     */
    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    /**
     * Handles the event of inserting a coin in the vending machine.
     * Sets the state if vending machine to selection state once coin has been inserted.
     */
    @Override
    public void insertCoin() {
        System.out.println("Coin accepted");
        vendingMachine.setState(vendingMachine.getHasCoinState());
    }

    /**
     * Handles the event of selecting an item from the vending machine.
     * If the vending machine had no coin, it notifies the user to insert a coin.
     */
    @Override
    public void selectItem() {
        System.out.println("Please insert a coin first");
    }

    /**
     * Handles the event of dispensing an item in the vending machine.
     * If the vending machine had no coin, It notifies the user to insert a coin and select an item.
     */
    @Override
    public void dispenseItem() {
        System.out.println("Please insert a coin and select an item first");
    }
}
