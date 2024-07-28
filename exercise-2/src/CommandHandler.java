import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * Handles commands given by user as inputs.
 * Parses commands and invokes appropriate methods in VirtualClassroomManager.
 */

public class CommandHandler {

    private VirtualClassroomManager vcManager;

    /**
     * Constructs a command handler with VirtualClassroomManager.
     * @param vcManager The instance of VirtualClassroomManager class.
     */
    public CommandHandler(VirtualClassroomManager vcManager) {
        this.vcManager = vcManager;
    }

    /**
     * Parses a command and invokes corresponding functions.
     * @param command The command to be processed.
     */
    public void handleCommand(String command) {
        String[] parts = command.split(" ", 2);
        String action = parts[0];
        String data = (parts.length > 1) ? parts[1] : "";

        try{
            switch (action) {
                case "add_classroom":
                    handleAddClassroom(data);
                    break;
                case "add_student":
                    handleAddStudent(data);
                    break;
                case "schedule_assignment":
                    handleScheduleAssignment(data);
                    break;
                case "submit_assignment":
                    handleSubmitAssignment(data);
                    break;
                case "list_students":
                    handleListStudents(data);
                    break;
                case "list_assignments":
                    handleListAssignments(data);
                    break;
                case "list_classrooms":
                    handleListClassroom();
                    break;
                case "remove_classroom":
                    handleRemoveClassroom(data);
                    break;
                case "remove_student":
                    handleRemoveStudent(data);
                    break;
                case "assign_for_student":
                    handleAssignForStudents(data);
                    break;
                case "list_assignment_for_student":
                    handleListAssignmentsForStudent(data);
                    break;
                default:
                    Logger.getInstance().warn("Unknown command: " + action);
            }
        } catch (Exception e){
            Logger.getInstance().logException(e);
        }
    }

    /**
     * Handles 'add_classroom' command.
     * @param data The data that contains classroom name.
     */
    private void handleAddClassroom(String data) {
        if(data.trim().isEmpty()){
            throw new IllegalArgumentException("Classroom name cannot be empty");
        }
        Classroom classroom = ClassroomFactory.createClassroom(data.trim());
        vcManager.addClassroom(classroom);
        Logger.getInstance().info("Classroom " + data + " has been created");
    }

    /**
     * Handles the 'add_student' command.
     * @param data The data that contains student id and classroom name.
     */
    private void handleAddStudent(String data) {
        String[] parts = data.split(" ", 3);
        if(parts.length < 3 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty() || parts[2].trim().isEmpty()){
            throw new IllegalArgumentException("Invalid student data");
        }
        String studentId = parts[0].trim();
        String studentName = parts[1].trim();
        String classroomName = parts[2].trim();
        Student student = StudentFactory.createStudent(studentId, studentName);
        vcManager.enrollStudent(student, classroomName);
        Logger.getInstance().info("Student " + studentId + " has been enrolled in " + classroomName + ".");
    }

    /**
     * Handles the 'schedule_assignment' command.
     * @param data The data that contains classroom name, assignment ID, assignment description, and Due date.
     */
    private void handleScheduleAssignment(String data) {
        String[] parts = data.split(" ", 3);
        if(parts.length < 3 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty() || parts[2].trim().isEmpty()){
            throw new IllegalArgumentException("Invalid assignment data");
        }
        String classroomName = parts[0].trim();
        String assignmentId = parts[1].trim();
        String description = parts[2].trim();
        LocalDateTime dueDate = LocalDateTime.now().plusDays(7);

        Assignment assignment = AssignmentFactory.createAssignment(assignmentId,description,dueDate,classroomName);
        vcManager.scheduleAssignment(assignment);
        Logger.getInstance().info("Assignment for " + classroomName + " has been scheduled.");
    }

    /**
     * Handles the 'submit_assignment' command.
     * @param data The data that contains student ID, classroom name and assignment ID.
     */
    private void handleSubmitAssignment(String data) {
        String[] parts = data.split(" ");
        if (parts.length < 3 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty() || parts[2].trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid submission data");
        }
        String studentId = parts[0].trim();
        String classroomName = parts[1].trim();
        String assignmentId = parts[2].trim();

        vcManager.submitAssignment(studentId, classroomName, assignmentId);
        Logger.getInstance().info("Assignment submitted by Student " + studentId + " to " + classroomName + ".");
    }

    /**
     * Handles the 'list_students' command.
     * @param data The data that contains student ID, classroom name and assignment ID.
     */
    private void handleListStudents(String data){
        String[] parts = data.split(" ");
        if(parts[0].trim().isEmpty()){
            throw new IllegalArgumentException("Classroom name cannot be empty");
        }
        String classroomName = parts[0].trim();
        vcManager.listStudents(classroomName);
        Logger.getInstance().info("Students of the Classroom " + classroomName + " has been listed.");
    }

    /**
     * Handles the 'list_assignments' command.
     * @param data The data that contains student ID, classroom name and assignment ID.
     */
    private void handleListAssignments(String data){
        String[] parts = data.split(" ");
        if(parts[0].trim().isEmpty()){
            throw new IllegalArgumentException("Classroom name cannot be empty");
        }
        String classroomName = parts[0].trim();
        vcManager.listAssignments(classroomName);
        Logger.getInstance().info("Assignments of the Classroom " + classroomName + " has been listed.");
    }

    /**
     * Handles the 'list_classrooms' command
     */
    private void handleListClassroom(){
        vcManager.listClassrooms();
        Logger.getInstance().info("Classrooms have been listed.");
    }

    /**
     * Handles the 'remove_classroom' command.
     * @param data The data that contains student ID, classroom name and assignment ID.
     */
    private void handleRemoveClassroom(String data){
        String[] parts = data.split(" ");
        if (parts[0].trim().isEmpty()){
            throw new IllegalArgumentException("Classroom name cannot be empty");
        }
        String classroomName = parts[0].trim();
        vcManager.removeClassroom(classroomName);
        Logger.getInstance().info("Classroom " + classroomName + " has been removed.");
    }

    /**
     * Handles the 'remove_student' command.
     * @param data The data that contains student ID, classroom name and assignment ID.
     */
    private void handleRemoveStudent(String data){
        String[] parts = data.split(" ");
        System.out.println(Arrays.toString(parts));
        if(parts[0].trim().isEmpty() || parts[1].trim().isEmpty()){
            throw new IllegalArgumentException("Student name cannot be empty");
        }
        String studentId = parts[0].trim();
        String classroomName = parts[1].trim();
        vcManager.removeStudent(studentId, classroomName);
        Logger.getInstance().info("Student " + studentId + " has been removed.");
    }

    /**
     * Handles the 'assign_for_student' command.
     * @param data The data that contains student ID, classroom name and assignment ID.
     */
    private void handleAssignForStudents(String data){
        String[] parts = data.split(" ");
        if (parts[0].trim().isEmpty()||parts[1].trim().isEmpty()||parts[2].trim().isEmpty()){
            throw new IllegalArgumentException("Student id or assignment id cannot be empty");
        }
        //assign_for_student <student_id> <assignment_id> <description> <due_date>
        String studentId = parts[0].trim();
        String assignmentId = parts[1].trim();
        System.out.println(studentId + " " + assignmentId);
        String description = parts[2].trim();
        vcManager.assignHomeworkToStudent(studentId, assignmentId);
        Logger.getInstance().info("Assignment " + assignmentId +  " assigned to student " + studentId + ".");
    }

    /**
     * Handles the 'list_assignment_for_student' command.
     * @param data The data that contains student ID, classroom name and assignment ID.
     */
    private void handleListAssignmentsForStudent(String data){
        String[] parts = data.split(" ");
        if(parts[0].trim().isEmpty()){
            throw new IllegalArgumentException("Student id cannot be empty");
        }
        String studentId = parts[0].trim();
        vcManager.assignmentsForStudent(studentId);
        Logger.getInstance().info("Assignments for " + studentId + " has been listed.");
    }
}
