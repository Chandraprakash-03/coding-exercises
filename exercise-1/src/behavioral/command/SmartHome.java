package behavioral.command;

/**
 * The main class to demonstrate the smart home controller and its different commands.
 */
public class SmartHome {
    /**
     * The entry point of the application.
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        SmartHomeController controller = new SmartHomeController();

        Command lightOn = new LightCommand("Living Room Light", LightCommand.lightState.ON);
        Command lightOff = new LightCommand("Living Room Light", LightCommand.lightState.OFF);
        Command thermostatSet = new ThermostatCommand(22);

        controller.addCommand(lightOn);
        controller.addCommand(lightOff);
        controller.addCommand(thermostatSet);

        controller.executeCommands();
    }
}
