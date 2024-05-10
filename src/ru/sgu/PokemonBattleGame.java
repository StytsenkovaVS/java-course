package ru.sgu;

import java.util.Random;

public class PokemonBattleGame {
    public static void main(String[] args) {
        Pikachu pikachu = new Pikachu("Пикачу", 100);
        Charmander charmander = new Charmander("Чармандер", 100);

        Random random = new Random();
        BasePokemon attacker, defender;

        while (pikachu.isAlive() && charmander.isAlive()) {
            boolean isPikachuAttacking = random.nextBoolean();

            if (isPikachuAttacking) {
                attacker = pikachu;
                defender = charmander;
            } else {
                attacker = charmander;
                defender = pikachu;
            }

            if (defender.isAlive()) {
                ((Battle) attacker).attack(defender);
            }

        }

        if (pikachu.isAlive()) {
            System.out.println(pikachu.getName() + " победил!");
        } else {
            System.out.println(charmander.getName() + " победил!");
        }
    }
}
