package creational.prototype;

/**
 * Represents a warrior character that can be cloned.
 */
public class Warrior implements Character{
    private String name;
    private int level;

    /**
     * Constructs a warrior with name and level.
     * @param name the name of the warrior.
     * @param level the level of the warrior.
     */
    public Warrior(String name, int level) {
        this.name = name;
        this.level = level;
    }

    /**
     * Gets the name of the warrior.
     * @return the name of the warrior.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the warrior.
     * @param name the name of the warrior.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the level of the warrior.
     * @return the level of the warrior.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets the level of the warrior.
     * @param level the level of the warrior.
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Creates a clone of the warrior.
     * @return a clone of the warrior.
     */
    @Override
    public Character clone() {
        try{
            return (Character) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Returns a string representation of the warrior.
     * @return a string representation of the warrior with name and level.
     */
    @Override
    public String toString() {
        return "Warrior [name=" + name + ", level=" + level + "]";
    }
}
