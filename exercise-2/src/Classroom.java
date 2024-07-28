import java.util.*;

/**
 * Represents a classroom in the virtual classroom manager.
 * Maintains a list of students and assignments associated with the classroom.
 */
public class Classroom {

    private String name;
    private Set<Student> students;
    private Set<Assignment> assignments;

    /**
     * Constructs a new Classroom.
     * @param name The name of the classroom.
     */
    public Classroom(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Classroom Name cannot be null or empty");
        }
        this.name = name;
        this.students = new HashSet<>();
        this.assignments = new HashSet<>();
    }

    /**
     * Adds a student to the classroom.
     * @param student The student to be added.
     */
    public synchronized void addStudent(Student student) {
        if(student == null){
            throw new IllegalArgumentException("Student cannot be null");
        }
        students.add(student);
        Logger.getInstance().info("Student " + student.getId() + " added to " + name);
    }

    /**
     * Removes a student from the classroom.
     * @param student The student to be removed.
     */
    public synchronized void removeStudent(Student student) {
        if(student == null){
            throw new IllegalArgumentException("Student cannot be null");
        }
        if(students.remove(student)){
            Logger.getInstance().info("Student " + student.getId() + " removed from " + name);
        }else{
            Logger.getInstance().info("Student " + student.getId() + " not found in  " + name);
        }
    }

    /**
     * Adds an assignment to the classroom.
     * @param assignment The assignment to be given.
     */
    public synchronized void addAssignment(Assignment assignment) {
        if(assignment == null){
            throw new IllegalArgumentException("Assignment cannot be null");
        }
        assignments.add(assignment);
        Logger.getInstance().info("Assignment added to " + name);
    }

    /**
     * Removes an assignment.
     * @param assignment The assignment to be removed.
     */
    public synchronized void removeAssignment(Assignment assignment) {
        if(assignment == null){
            throw new IllegalArgumentException("Assignment cannot be null");
        }
        if(assignments.remove(assignment)){
            Logger.getInstance().info("Assignment removed from " + name);
        }else{
            Logger.getInstance().info("Assignment not found in  " + name);
        }
    }

    /**
     * Lists the students enrolled in a class.
     * @return A list of students.
     */
    public List<Student> listStudents() {
        return new ArrayList<>(students);
    }

    /**
     * List the assignments given to a class.
     * @return A list of assignments.
     */
    public List<Assignment> listAssignments() {
        return new ArrayList<>(assignments);
    }

    // Getters and Setters

    /**
     * Gets a list of students enrolled in the classroom.
     * @return A set containing all students in the classroom.
     */
    public Set<Student> getStudents() {
        return new HashSet<>(students);
    }

    /**
     * Gets a list of assignments given to the classroom.
     * @return A set containing all assignments given to the classroom.
     */
    public Set<Assignment> getAssignments() {
        return new HashSet<>(assignments);
    }

    /**
     * Gets the name of the classroom.
     * @return The name of the classroom.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a new name for the classroom.
     * @param name The new name for the classroom.
     * @throws IllegalArgumentException If the provided name is null or empty.
     */
    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Classroom Name cannot be null or empty");
        }
        this.name = name;
    }
}
