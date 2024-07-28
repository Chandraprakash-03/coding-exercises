package structural.flyweight;

/**
 * Represents a character.
 */
public class Character {
    private final CharacterProperties properties;
    private String position;

    /**
     * Constructs a character with specified properties and position.
     * @param properties the properties of the character.
     * @param position the position of the character.
     */
    public Character(CharacterProperties properties, String position) {
        this.properties = properties;
        this.position = position;
    }

    /**
     * Gets the position of the character.
     * @return the position of the character.
     */
    public String getPosition() {
        return position;
    }

    /**
     * Sets the current position of the character.
     * @param position the current position of the character.
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Displays the character's position and its properties.
     */
    public void display(){
        System.out.println("Character position: " + position + ", " + properties);
    }
}
