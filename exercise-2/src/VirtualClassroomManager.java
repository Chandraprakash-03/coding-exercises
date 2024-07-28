import java.util.*;

/**
 * Manages the virtual classrooms, students, and assignments.
 * Handles operations like adding classrooms, enrolling students, scheduling assignments, and submitting assignments.
*/
public class VirtualClassroomManager {

    private final Map<String, Classroom> classrooms = new HashMap<>();
    private final Map<String, Student> students = new HashMap<>();
    private final Map<String, Assignment> assignments = new HashMap<>();

    /**
     * Adds a classroom to the manager.
     * @param classroom The classroom to add.
     * @throws IllegalArgumentException If the classroom is null or already exists.
     */
    public void addClassroom(Classroom classroom) {
        if(classroom == null || classrooms.containsKey(classroom.getName())){
            throw new IllegalArgumentException("Invalid or Duplicate Classroom");
        }
        classrooms.put(classroom.getName(), classroom);
    }

    /**
     * Enrolls a student in a classroom.
     * @param student The student to enroll.
     * @param classroomName The name of the classroom.
     * @throws IllegalArgumentException If the student or classroom name is invalid or if the classroom does not exist.
     */
    public void enrollStudent(Student student, String classroomName) {
        if(student == null || classroomName == null || classroomName.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid Student or Classroom name");
        }
        if(!classrooms.containsKey(classroomName)){
            throw new IllegalArgumentException("Classroom does not exist");
        }
        students.put(student.getId(), student);
        classrooms.get(classroomName).addStudent(student);
    }

    /**
     * Schedules an assignment to a classroom
     * @param assignment The assignment to schedule.
     * @throws IllegalArgumentException If the assignment or classroom is not valid.
     */
    public void scheduleAssignment(Assignment assignment) {
        if(assignment == null || !classrooms.containsKey(assignment.getClassroomName())){
            throw new IllegalArgumentException("Invalid Assignment or Classroom");
        }
        assignments.put(assignment.getId(), assignment);
        classrooms.get(assignment.getClassroomName()).addAssignment(assignment);
    }

    /**
     * Submits assignment for a Student
     * @param studentId The ID of the enrolled student.
     * @param classroomName The name of the classroom the assignment is associated with.
     * @param assignmentId The ID of the assignment.
     * @throws IllegalArgumentException If the student ID or assignment ID or classroom name is invalid.
     */
    public void submitAssignment(String studentId, String classroomName, String assignmentId) {
        if (studentId == null || classroomName == null || assignmentId == null || assignmentId.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid submission data");
        }

        Logger.getInstance().info("Attempting to submit: Student ID: " + studentId + ", Classroom: " + classroomName + ", Assignment ID: " + assignmentId);

        Student student = students.get(studentId);
        if (student == null) {
            Logger.getInstance().error("Student not found: " + studentId);
            throw new IllegalArgumentException("Invalid student");
        }

        Assignment assignment = assignments.get(assignmentId);
        if (assignment == null) {
            Logger.getInstance().error("Assignment not found: " + assignmentId);
            throw new IllegalArgumentException("Invalid assignment");
        }

        if (!classrooms.containsKey(assignment.getClassroomName())) {
            Logger.getInstance().error("Classroom not found: " + assignment.getClassroomName());
            throw new IllegalArgumentException("Invalid classroom");
        }

        if (!assignment.getClassroomName().equals(classroomName)) {
            Logger.getInstance().error("Classroom mismatch: Expected " + assignment.getClassroomName() + ", got " + classroomName);
            throw new IllegalArgumentException("Invalid classroom");
        }

        Logger.getInstance().info("Assignment " + assignmentId + " submitted by Student " + studentId);
    }

    /**
     * Lists the Classrooms
     */
    public void listClassrooms() {
        classrooms.forEach((name, classroom) -> {
            System.out.println(name);
        });
    }

    /**
     * Lists the Students in the specified class.
     * @param classroomName The name of the classroom.
     */
    public void listStudents(String classroomName) {
        Classroom classroom = classrooms.get(classroomName);
        if(classroom == null){
            Logger.getInstance().warn("Classroom not found: " + classroomName);
            return;
        }
        Set<Student> students = classroom.getStudents();
        if(students.isEmpty()){
            Logger.getInstance().info("No Students found for classroom: " + classroomName);
        }else{
            students.forEach((student) -> {
                System.out.println(student);
            });
        }
    }

    /**
     * Lists the Assignments given for the specified classroom
     * @param classroomName The name of the classroom.
     */
    public void listAssignments(String classroomName) {
        Classroom classroom = classrooms.get(classroomName);
        if(classroom == null){
            Logger.getInstance().warn("Classroom not found: " + classroomName);
            return;
        }
        Set<Assignment> assignments = classroom.getAssignments();
        if(assignments.isEmpty()){
            Logger.getInstance().info("No Assignments found for classroom: " + classroomName);
        }else {
            assignments.forEach((assignment) -> {
                System.out.println(assignment);
            });
        }
    }

    /**
     * Removes a classroom.
     * @param classroomName the name of the classroom to be removed.
     */
    public void removeClassroom(String classroomName) {
        if(!classrooms.containsKey(classroomName)){
            Logger.getInstance().warn("Classroom not found: " + classroomName);
            return;
        }
        classrooms.remove(classroomName);
    }

    /**
     * Removes a student from a classroom
     * @param studentId
     */
    public void removeStudent(String studentId, String classroomName) {
        if(studentId == null || studentId.trim().isEmpty()){
            Logger.getInstance().warn("Invalid student ID");
        }
        if(!students.containsKey(studentId)){
            Logger.getInstance().warn("Student not found: " + studentId);
            return;
        }
        Student student = students.get(studentId);
        if(classroomName == null || classroomName.trim().isEmpty()){
            Logger.getInstance().warn("Invalid classroom name");
            return;
        }
        Classroom classroom = classrooms.get(classroomName);
        if(classroom == null){
            Logger.getInstance().warn("Classroom not found: " + classroomName);
            return;
        }
        if(!classroom.getStudents().contains(student)){
            Logger.getInstance().warn("Student not found: " + studentId);
            return;
        }
        classroom.removeStudent(student);
        students.remove(studentId);
        Logger.getInstance().info("Student " + studentId + " removed from Classroom " + classroomName);
    }

    /**
     * Assigns an assignment to a student.
     * @param studentId The ID of the student.
     * @param assignmentId The ID of the student.
     */
    public void assignHomeworkToStudent(String studentId, String assignmentId){
        Student student = students.get(studentId);
        Assignment assignment = assignments.get(assignmentId);
        if(student == null){
            Logger.getInstance().warn("Student not found: " + studentId);
            throw new IllegalArgumentException("Student not found");
        }
        if(assignment.getAssignedStudentIds().contains(studentId)){
            Logger.getInstance().warn("Assignment already assigned to student: " + studentId);
            return;
        }
        assignment.addStudent(studentId);
        Logger.getInstance().info("Assignment " + assignmentId + " assigned to Student " + studentId);
    }

    public void assignmentsForStudent(String studentId) {
        Student student = students.get(studentId);
        if(student == null){
            Logger.getInstance().warn("Student not found: " + studentId);
            throw new IllegalArgumentException("Student not found");
        }
        List<Assignment> studentAssignments = new ArrayList<>();
        for(Map.Entry<String, Assignment> entry : assignments.entrySet()){
            Assignment assignment = entry.getValue();
            if(assignment.getAssignedStudentIds().contains(studentId)){
                studentAssignments.add(assignment);
            }

            Logger.getInstance().info("Retrieved" + studentAssignments.size() + " Assignment for Student " + studentId);
            for(Assignment assignments : studentAssignments){
                System.out.println(assignments);
            }

        }
    }
}
