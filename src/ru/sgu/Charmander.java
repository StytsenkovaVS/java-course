package ru.sgu;

import java.util.Random;

class Charmander extends BasePokemon implements Battle, Cloneable {
    public Charmander(String name, int healthPoints, Element element) {
        super(name, (int) (healthPoints * 1.3), element);
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
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
