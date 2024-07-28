package behavioral.state;

/**
 * Represents a vending machine.
 */
public class VendingMachine {
    private VendingMachineState readyState;
    private VendingMachineState hasCoinState;
    private VendingMachineState dispensingState;

    private VendingMachineState currentState;

    /**
     * Constructs a new vending machine object and initializes the state.
     * The initial state is set to ready state.
     */
    public VendingMachine() {
        readyState = new ReadyState(this);
        hasCoinState = new HasCoinState(this);
        dispensingState = new DispensingState(this);
        currentState = readyState;
    }

    /**
     * Sets the current state of the vending machine.
     * @param state the new state of the vending machine.
     */
    public void setState(VendingMachineState state) {
        this.currentState = state;
    }

    /**
     * Gets the current state of the vending machine.
     * @return the ready state.
     */
    public VendingMachineState getReadyState() {
        return readyState;
    }

    /**
     * Gets the current state of the vending machine.
     * @return the selection state.
     */
    public VendingMachineState getHasCoinState() {
        return hasCoinState;
    }

    /**
     * Gets the current state of the vending machine.
     * @return the dispensing state.
     */
    public VendingMachineState getDispensingState() {
        return dispensingState;
    }

    /**
     * Handles the event of inserting a coin with respect to current state.
     */
    public void insertCoin(){
        currentState.insertCoin();
    }

    /**
     * Handles the event of selecting an item with respect to current state.
     */
    public void selectItem(){
        currentState.selectItem();
    }

    /**
     * Handles the event of dispensing an item with respect to current state.
     */
    public void dispenseItem(){
        currentState.dispenseItem();
    }

    /**
     * Gets the current state of the vending machine.
     * @return the name of the current state of the vending machine.
     */
    public String getCurrentStateName(){
        if(currentState instanceof ReadyState){
            return "Ready State";
        }else if(currentState instanceof HasCoinState){
            return "Has Coin State";
        }else if(currentState instanceof DispensingState){
            return "Dispensing State";
        }else{
            return "Unknown State";
        }
    }
}
