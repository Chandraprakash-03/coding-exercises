import java.time.LocalDateTime;

/**
 * Class that handles Submission of assignments.
 */
public class AssigmentSubmission {

    private Student student;
    private Assignment assignment;
    private LocalDateTime submissionTime;

    /**
     * Constructs the AssignmentSubmission class.
     * @param student The student who submits the assignment.
     * @param assignment The assignment that is being submitted.
     * @param submissionTime The time of submission.
     */
    public AssigmentSubmission(Student student, Assignment assignment, LocalDateTime submissionTime) {
        if(student == null || assignment == null || submissionTime == null){
            throw new IllegalArgumentException("Student or Assignment or Submission cannot be null");
        }
        this.student = student;
        this.assignment = assignment;
        this.submissionTime = submissionTime;
    }

    //Getters and Setters

    /**
     * Gets the student who made the submission.
     * @return The student.
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Gets the assignment that is being submitted.
     * @return The assignment.
     */
    public Assignment getAssignment() {
        return assignment;
    }

    /**
     * Gets the submission time.
     * @return The submission time.
     */
    public LocalDateTime getSubmissionTime() {
        return submissionTime;
    }

    @Override
    public String toString() {
        return "AssignmentSubmission{ " +
                "Student= " + student.getId() +
                ", Assignment= " + assignment.getId() +
                ", submissionTime= " + submissionTime +
                "}";
    }
}
