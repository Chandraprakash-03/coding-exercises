package structural.composite;

/**
 * Represents a file in the file system.
 */
public class File implements FileSystemComponent{
    private String name;

    /**
     * Constructs a File with a given name.
     * @param name the name of the file.
     */
    public File(String name) {
        this.name = name;
    }

    /**
     * Displays the file's name.
     * @param indent the indentation string used for displaying the hierarchical structure.
     */
    @Override
    public void display(String indent) {
        System.out.println( indent +"File: " + name);
    }
}
