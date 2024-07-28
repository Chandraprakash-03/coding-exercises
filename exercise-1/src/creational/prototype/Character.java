package creational.prototype;

/**
 * Interface to create a copy of a character.
 */
public interface Character extends Cloneable{
    /**
     * Creates a clone of the character.
     * @return a clone of the character.
     */
    Character clone();
}
