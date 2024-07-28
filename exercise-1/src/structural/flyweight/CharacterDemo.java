package structural.flyweight;

/**
 * Demonstrates the use of flyweight design pattern using character model.
 */
public class CharacterDemo {
    /**
     * The entry point of the character model.
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();

        CharacterProperties properties1 = factory.getCharacterProperties("Warrior", "Red");
        Character character1 = new Character(properties1, "Pos1");

        CharacterProperties properties2 = factory.getCharacterProperties("Mage", "Blue");
        Character character2 = new Character(properties2, "Pos2");

        character1.display();
        character2.display();

        System.out.println(properties1 == properties2);
    }
}
