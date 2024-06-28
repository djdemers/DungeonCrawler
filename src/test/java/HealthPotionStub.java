import characters.consumables.Consumable;
import characters.Character;
import service.SingleUse;

class HealthPotionStub extends Consumable implements SingleUse {
    private boolean used = false;

    public HealthPotionStub() {
        super("Health Potion", "Restores health");
    }

    @Override
    public void use(Character character) {
        character.setHealth(Math.min(character.getHealth() + 50, character.getMaxHealth()));
        used = true;
    }

    public boolean isUsed() {
        return used;
    }
    public String getName(){
        return "Health Potion";
    }
    public String getDescription(){
        return "Description";
    }
}
