package structural.composite;

/**
 * Demonstrates the use of the composite design pattern to model a file system.
 */
public class FileSystem {
    /**
     * The entry point of file system model.
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");

        Directory dir1 = new Directory("dir1");
        Directory dir2 = new Directory("dir2");

        dir1.addComponent(file1);
        dir1.addComponent(file2);

        Directory rootDir = new Directory("root");
        rootDir.addComponent(dir1);
        rootDir.addComponent(dir2);

        rootDir.addComponent(dir1);
        rootDir.addComponent(dir2);

        rootDir.display("");

    }
}
