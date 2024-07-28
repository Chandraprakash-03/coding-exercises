package behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles commands given to various objects.
 */
public class SmartHomeController {
    private List<Command> commands = new ArrayList<>();

    /**
     * Adds a command to the commands list.
     * @param command the command to be added.
     */
    public void addCommand(Command command) {
        commands.add(command);
    }

    /**
     * Executes the command in the commands list.
     */
    public void executeCommands() {
        for (Command command : commands) {
            command.execute();
        }
        commands.clear();
    }
}
