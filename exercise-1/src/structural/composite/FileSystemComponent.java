package structural.composite;

/**
 * Interface representing a file in the file system.
 */
public interface FileSystemComponent {
    /**
     * Displays the component's in a file system.
     * @param indent the indentation string used for displaying the hierarchical structure.
     */
    void display(String indent);
}
