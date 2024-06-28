package characters.consumables;

import characters.Character;
import service.SingleUse;

// PLACE HOLDER CLASS
public class MagicScroll extends Consumable implements SingleUse {
    private int power;

    public MagicScroll(String name, String description, int power) {
        super(name, description);
        this.power = power;
    }

    @Override
    public void use(Character character) {
        //Maybe A free skill use with no mana cost
        System.out.println("Using " + name + ", effect power: " + power);
    }
    public String getName(){
        return super.name;
    }
    public String getDescription(){
        return super.description;
    }
}