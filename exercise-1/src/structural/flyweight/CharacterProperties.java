package structural.flyweight;

/**
 * Responsible the properties of a character.
 */
public class CharacterProperties {
    private final String name;
    private final String color;

    /**
     * Constructs a character properties instance with the specified name and color
     * @param name the name of the character.
     * @param color the color of the character.
     */
    public CharacterProperties(String name, String color) {
        this.name = name;
        this.color = color;
    }

    /**
     * Returns the name of the character.
     * @return the name of the character.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the color of the character.
     * @return the color of the character.
     */
    public String getColor() {
        return color;
    }

    /**
     * Displays the character properties as a string.
     * @return the string representation of the character properties.
     */
    @Override
    public String toString() {
        return "CharacterProperties [name=" + name + ", color=" + color + "]";
    }
}
