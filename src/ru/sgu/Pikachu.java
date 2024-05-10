package ru.sgu;

import java.util.Random;

class Pikachu extends BasePokemon implements Battle {
    public Pikachu(String name, int healthPoints) {
        super(name, healthPoints);
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
    public Pikachu clone() {
        return new Pikachu(this.getName(), this.getHealthPoints());
    }
}