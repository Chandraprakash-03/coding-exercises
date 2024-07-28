package structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a directory in a file system.
 */
public class Directory implements FileSystemComponent{
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    /**
     * Constructs a Directory with the specified name.
     * @param name the name of the directory.
     */
    public Directory(String name) {
        this.name = name;
    }

    /**
     * Adds a component to the current directory.
     * @param component the component to be added.
     */
    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    /**
     * Removes a component from this directory.
     * @param component the component to be removed.
     */
    public void removeComponent(FileSystemComponent component) {
        components.remove(component);
    }

    /**
     * Displays the directory name.
     * @param indent the indentation string used for displaying the hierarchical structure.
     */
    @Override
    public void display(String indent) {
        System.out.println(indent + "Directory: " + name);
        for (FileSystemComponent component : components) {
            component.display(indent + "  ");
        }
    }
}
