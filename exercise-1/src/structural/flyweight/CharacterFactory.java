package structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Responsible for creating and managing instances of characters/
 */
public class CharacterFactory {
    private Map<String, CharacterProperties> propertiesMap = new HashMap<>();

    /**
     * Retrieves an instance with the specified name and color.
     * If an instance is not present it is created.
     * @param name the name of the character.
     * @param color the color of the character.
     * @return a character instance with specified name and color.
     */
    public CharacterProperties getCharacterProperties(String name, String color) {
        String key = name + ":" + color;
        if(!propertiesMap.containsKey(key)) {
            propertiesMap.put(key, new CharacterProperties(name, color));
        }
        return propertiesMap.get(key);
    }
}
