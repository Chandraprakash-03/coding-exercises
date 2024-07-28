package creational.prototype;

/**
 * Demonstrates the use of Character interface and Warrior class.
 */
public class CharacterCreator {
    /**
     * The entry point of the character creation system.
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        Warrior originalWarrior = new Warrior("King Arthur", 10);
        System.out.println("Original warrior: " + originalWarrior);

        Warrior clonedWarrior = (Warrior) originalWarrior.clone();
        System.out.println("Cloned warrior: " + clonedWarrior);

        clonedWarrior.setName("Aragorn");
        clonedWarrior.setLevel(12);

        System.out.println("Modified cloned warrior: " + clonedWarrior);
        System.out.println("Original Warrior after modification: " + originalWarrior);
    }
}
