/**
 * Observer interface for receiving updates about changes in classrooms.
 */
public interface ClassroomObserver {

    /**
     * Called when an update occurs in a classroom.
     * @param classroomName The name of the classroom where the update has occured.
     * @param message The message describing the update.
     */
    void update(String classroomName, String message);
}
