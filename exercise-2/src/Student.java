import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a student in the virtual classroom.
 * Holds Student ID and name.
 */
public class Student {

    private String id;
    private String name;

    /**
     * Constructs a new Student
     * @param id The ID of the Student.
     * @param name The name of the Student.
     */
    public Student(String id, String name) {
        if(id == null || id.trim().isEmpty()){
            throw new IllegalArgumentException("Student id cannot be empty");
        }
        this.id = id;
        this.name = name;
    }

    /**
     * Gets the ID of the student.
     * @return The student's ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the name of the student.
     * @return The student's name.
     */
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{ id = " + id + ", name = " + name +" }";
    }


}
