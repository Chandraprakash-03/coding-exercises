package behavioral.state;

/**
 * Handles the dispensing state of the vending machine.
 * In this state, the vending machine is currently dispensing an item.
 * It cannot accept new coins or select items until dispensing in completed.
 */
public class DispensingState implements VendingMachineState{
    private VendingMachine vendingMachine;

    /**
     * Constructs a dispensing state for the vending machine.
     * @param vendingMachine the vending machine that the state belongs to.
     */
    public DispensingState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    /**
     * Handles the event of inserting a coin in the vending machine.
     * Since the vending machine is currently dispensing an item,
     * it ignores the coin insertion and notifies the user to wait.
     */
    @Override
    public void insertCoin() {
        System.out.println("Please wait, we're already dispensing an item.");
    }

    /**
     * Handles the event of selecting an item from the vending machine.
     * Since the vending machine is currently dispensing an item,
     * it ignores the item selection and notifies the user to wait.
     */
    @Override
    public void selectItem() {
        System.out.println("Please wait, we're already dispensing an item.");
    }

    /**
     * Handles the event of dispensing an item from the vending machine.
     * Sets the state of vending machine to ready state, once dispensing is completed.
     */
    @Override
    public void dispenseItem() {
        System.out.println("Item dispensed");
        vendingMachine.setState(vendingMachine.getReadyState());
    }
}
