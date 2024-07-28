package behavioral.command;

/**
 * Handles the commands given for a light.
 */
public class LightCommand implements Command{
    public enum lightState{
        ON, OFF
    }

    private String lightName;
    private lightState state;

    /**
     * Constructs the Light
     * @param lightName the name of the light
     * @param state the current state of the light
     */
    public LightCommand(String lightName, lightState state) {
        this.lightName = lightName;
        this.state = state;
    }

    /**
     * Invokes the corresponding state of the light.
     */
    @Override
    public void execute() {
        if(state == lightState.ON){
            System.out.println("Turning on "+ lightName);
        }else{
            System.out.println("Turning off "+ lightName);
        }

    }
}
