import java.time.LocalDateTime;

/**
 * Class to create instances of Assignment.
 */
public class AssignmentFactory {

    /**
     * Creates a new Assignment interface.
     * @param id The ID of the assignment.
     * @param description The description of the assignment.
     * @param dueDate The duedate of the assignment.
     * @param classroomName The name of the classroom associated with the assignment.
     * @return A new Assignment instance.
     * @throws IllegalArgumentException If any of the parameters are invalid.
     */
    public static Assignment createAssignment(String id, String description, LocalDateTime dueDate, String classroomName){
        if(id == null || id.trim().isEmpty()){
            throw new IllegalArgumentException("Assignment id cannot be empty");
        }

        if(description == null || description.trim().isEmpty()){
            throw new IllegalArgumentException("Assignment description cannot be empty");
        }

        if(dueDate == null){
            throw new IllegalArgumentException("Due date cannot be null");
        }

        if(classroomName == null || classroomName.trim().isEmpty()){
            throw new IllegalArgumentException("Classroom name cannot be empty");
        }

        return new Assignment(id, description, dueDate, classroomName);
    }
}
