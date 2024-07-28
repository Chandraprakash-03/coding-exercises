/**
 * Factory class for creating Classroom instances.
 */
public class ClassroomFactory {

    /**
     * Creates a new Classroom instance.
     * @param name The name of the classroom.
     * @return A new classroom instance.
     * @throws IllegalArgumentException If the name is null or empty.
     */
    public static Classroom createClassroom(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Classroom Name cannot be null or empty");
        }
        Classroom classroom = new Classroom(name);
        Logger.getInstance().info("Classroom " + name + " created" );
        return classroom;
    }
}
