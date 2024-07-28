import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Used to represent an assignment in a classroom.
 * Contains assignment details such as ID, Description, Due date and Classroom.
*/
public class Assignment {
    private String id;
    private String description;
    private LocalDateTime duedate;
    private String classroomName;
    private Set<String> assignedStudentIds;

    /**
     * Constructs an Assignment
     * @param id - Identifier for the assignment
     * @param description - Description for the assignment.
     * @param dueDate - Due date of the assignment
     * @param classroomName - Name of the classroom associated with.
     */
    public Assignment(String id, String description, LocalDateTime dueDate, String classroomName){
        if(id == null || id.trim().isEmpty()){
            throw new IllegalArgumentException("Assignment ID cannot be empty");
        }
        if(description == null || description.trim().isEmpty()){
            throw new IllegalArgumentException("Assignment Description cannot be empty");
        }
        if(dueDate == null){
            throw new IllegalArgumentException("Due Date cannot be null");
        }
        if(classroomName == null || classroomName.trim().isEmpty()){
            throw new IllegalArgumentException("Classroom name cannot be empty");
        }
        this.id = id;
        this.description = description;
        this.duedate = dueDate;
        this.classroomName = classroomName;
        this.assignedStudentIds = new HashSet<>();
    }

    /**
     * Gets the assignment ID.
     * @return The assignment ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the description for the assignment.
     * @return The description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the due date of the assignment.
     * @return The due date.
     */
    public LocalDateTime getDuedate() {
        return duedate;
    }

    /**
     * Gets the Name of the classroom for the assignment.
     * @return The classroom name.
     */
    public String getClassroomName() {
        return classroomName;
    }

    /**
     * Sets the id of the assignment.
     * @param id The new ID of the assignment.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the description of the assignment.
     * @param description The new description of the assignment.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the due date of the assignment.
     * @param duedate The new due date of the assignment.
     */
    public void setDuedate(LocalDateTime duedate) {
        this.duedate = duedate;
    }

    /**
     * Sets the classroom name of the assignment.
     * @param classroomName The classroom name of the assignment.
     */
    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    /**
     * Adds the student who is assigned the assignment.
     * @param studentId the ID of the student.
     */
    public void addStudent(String studentId) {
        assignedStudentIds.add(studentId);
    }

    /**
     * Gets the list of assignments assigned to students.
     * @return the set of assignments and students.
     */
    public Set<String> getAssignedStudentIds() {
        return assignedStudentIds;
    }

    @Override
    public String toString(){
        return "Assignment { id= " + id + ", description= " + description + ", duedate= " + duedate + ", classroomName= " + classroomName + "}";
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Assignment that = (Assignment) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
