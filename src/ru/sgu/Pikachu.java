package ru.sgu;

import java.util.Random;

class Pikachu extends BasePokemon implements Battle, Cloneable {
    public Pikachu(String name, int healthPoints, Element element) {
        super(name, healthPoints, element);
    }

    @Override
    public void attack(BasePokemon enemy) {
        System.out.println(getName() + " использует Статическое электричество!");
        Random random = new Random();
        int damage = random.nextInt(20) + 15;
        enemy.takeDamage(damage);
        System.out.println(this.getName() + " атакует противника и наносит " + damage + " урона.");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}