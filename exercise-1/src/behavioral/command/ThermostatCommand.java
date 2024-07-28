package behavioral.command;

/**
 * Handles the commands for a thermostat.
 */
public class ThermostatCommand implements Command{
    private int temperature;

    /**
     * Constructs a thermostat.
     * @param temperature the temperature of the thermostat.
     */
    public ThermostatCommand(int temperature) {
        this.temperature = temperature;
    }

    /**
     * Executes the thermostat commands.
     */
    @Override
    public void execute() {
        System.out.println("Setting temperature to " + temperature + " degrees");
    }
}
