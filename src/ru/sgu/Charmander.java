package ru.sgu;

import java.util.Random;

class Charmander extends BasePokemon implements Battle {
    public Charmander(String name, int healthPoints) {
        super(name, (int) (healthPoints * 1.3));
    }

    @Override
    public void attack(BasePokemon enemy) {
        System.out.println(getName() + " использует Яростное пламя!");
        Random random = new Random();
        int damage = random.nextInt(20) + 10;
        enemy.takeDamage(damage);
        System.out.println(this.getName() + " атакует противника и наносит " + damage + " урона.");
    }

    @Override
    public Charmander clone() {
        return new Charmander(this.getName(), this.getHealthPoints());
    }
}
