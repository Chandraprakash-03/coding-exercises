/**
 * Factory class for creating instances of students.
 */
public class StudentFactory {

    /**
     * Creates a new student instance.
     * @param id The ID of the student.
     * @param name The name of the student.
     * @return A new student instance.
     * @throws IllegalArgumentException If the is null or empty.
     */
    public static Student createStudent(String id, String name){
        if(id == null || id.trim().isEmpty()){
            throw new IllegalArgumentException("Student ID cannot be empty");
        }
        return new Student(id, name);
    }
}
