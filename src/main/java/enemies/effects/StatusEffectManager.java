package enemies.effects;

import characters.Character;
import java.util.*;


/**
 * Manages status effects applied to characters within the game.
 * This class allows for the application, updating, and removal of temporary effects on characters,
 * such as buffs or debuffs, which can alter a character's stats or behaviors for a duration.
 */
public class StatusEffectManager {
    private Map<Character, List<Effect>> effects = new HashMap<>();

    /**
     * Applies a specified effect to a character. If the character does not have any effects,
     * a new list is created and the effect is added to it.
     *
     * @param character The character to whom the effect will be applied.
     * @param effect The effect to be applied to the character.
     */
    public void applyEffect(Character character, Effect effect) {
        effects.computeIfAbsent(character, k -> new ArrayList<>()).add(effect);
        effect.applyEffect(character);
    }

    /**
     * Updates the status effects on a specific character by decreasing their duration,
     * and removes them if their duration has expired.
     *
     * @param character The character whose effects need to be updated.
     */
    public void updateEffects(Character character) {
        List<Effect> characterEffects = effects.get(character);
        if (characterEffects != null) {
            Iterator<Effect> it = characterEffects.iterator();
            while (it.hasNext()) {
                Effect effect = it.next();
                effect.decreaseDuration();
                if (effect.isExpired()) {
                    effect.removeEffect(character);
                    it.remove();
                }
            }
        }
    }
}