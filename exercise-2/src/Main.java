import java.util.Scanner;
/**
 * This is the Main class of the Virtual Classroom Manager application
 * It initializes the manager, command handler and logger classes.
 *  Handles user commands and provides an interactive console interface.
*/
public class Main {
    public static void main(String[] args) {

        // Initialization
        VirtualClassroomManager manager = new VirtualClassroomManager();
        CommandHandler commandHandler = new CommandHandler(manager);
        Logger logger = Logger.getInstance();

        //Console menu
        System.out.println("Virtual Classroom Manager");
        System.out.println("Commands");
        System.out.println("1. add_classroom <class_name>");
        System.out.println("2. add_student <student_id> <class_name>");
        System.out.println("3. schedule_assignment <class_name> <assignment_id> <description> <due_date>");
        System.out.println("4. submit_assignment <student_id> <class_name> <assignment_id>");
        System.out.println("5. list_students <class_name>");
        System.out.println("6. list_assignments <class_name>");
        System.out.println("7. list_classrooms");
        System.out.println("8. remove_classroom <class_name>");
        System.out.println("9. remove_student <student_id> <class_name>");
        System.out.println("10. assign_for_student <student_id> <assignment_id> <description> <due_date>");
        System.out.println("11. list_assignment_for_student <student_id>");
        System.out.println("Type 'exit' to quit");

        Scanner scanner = new Scanner(System.in);
        String command;

        // loop to handle user commands
        while(true) {
            System.out.println("Enter command: ");
            command = scanner.nextLine();

            if("exit".equalsIgnoreCase(command.trim())) {
                break;
            }

            try{
                commandHandler.handleCommand(command);
            }catch (Exception e){
                logger.error("Error while handling command: " + command);
                logger.logException(e);
            }
        }

        // Closing Logger and Scanner
        logger.close();
        scanner.close();
    }
}
