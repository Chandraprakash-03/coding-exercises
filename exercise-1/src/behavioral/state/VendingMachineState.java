package behavioral.state;

/**
 * Interface representing a state in a vending machine.
 */
public interface VendingMachineState {

    /**
     * Handles the event of inserting a coin.
     */
    void insertCoin();

    /**
     * Handles the event of selecting an item.
     */
    void selectItem();

    /**
     * Handles the event of dispensing an item.
     */
    void dispenseItem();
}
