package characters.consumables;

import characters.Character;
import service.SingleUse;

public class InstantLevelUp extends Consumable implements SingleUse {
    public InstantLevelUp(String name, String description, int levelIncrement){
        super(name, description);
    }
    @Override
    public void use(Character character){
        //character.levelUp();
        System.out.println(character.getName() + " uses " + name + " and levels up instantly!");
    }
    public String getName(){
        return super.name;
    }
    public String getDescription(){
        return super.description;
    }
}
