package behavioral.state;


/**
 * Handles the item selection state of the vending machine.
 * In this state, the vending machine is currently allowing to select an item.
 * It cannot allow users to insert coins or dispense items until an item has been selected.
 */
public class HasCoinState implements VendingMachineState{
    private VendingMachine vendingMachine;

    /**
     * Constructs a selection state for the vending machine.
     * @param vendingMachine the vending machine that the state belongs to.
     */
    public HasCoinState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }


    /**
     * Handles the event of inserting a coin in the vending machine.
     * If the vending machine already has a coin, it notifies the user to wait to select an item.
     */
    @Override
    public void insertCoin() {
        System.out.println("You already inserted a coin");
    }

    /**
     * Handles the event of selecting an item from the vending machine.
     * Sets the state of vending machine to dispensing state once selection of item has been completed.
     */
    @Override
    public void selectItem() {
        System.out.println("Item selected");
        vendingMachine.setState(vendingMachine.getDispensingState());
    }

    /**
     * Handles the event of dispensing an item in the vending machine.
     * If no items are selected, It notifies the user to wait to select an item.
     */
    @Override
    public void dispenseItem() {
        System.out.println("Please select an item first");
    }
}
