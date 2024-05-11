package ru.sgu;

import java.util.Random;

public class PokemonBattleGame {
    public static void main(String[] args) throws CloneNotSupportedException {
        Element el = new Element ("Электричество");
        Element fire = new Element ("Огонь");
        Pikachu pikachu = new Pikachu("Пикачу", 100, el);
        Charmander charmander = new Charmander("Чармандер", 100, fire);

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

        if (pikachu.equals(charmander)) {
            System.out.println("Объекты эквивалентны");
        } else {
            System.out.println("Объекты не эквивалентны");
        }

        System.out.println("hashCode для пикачу: " + pikachu.hashCode());
        System.out.println("hashCode для чармандера: " + charmander.hashCode());

        System.out.println("Результат compareTo: " + pikachu.compareTo(charmander));

        System.out.println("toString: " + pikachu.toString());

        BasePokemon shallowCopyOfPikachu = (BasePokemon) pikachu.clone();
        Element copiedEl = shallowCopyOfPikachu.getElement();
        System.out.println(copiedEl.getName());
        copiedEl.setName("Вода");
        System.out.println(copiedEl.getName());
        System.out.println(el.getName());
        System.out.println();
        BasePokemon deepCopyOfCharmander = (BasePokemon) charmander.deepClone();
        Element deepCopiedEl = deepCopyOfCharmander.getElement();
        System.out.println(deepCopiedEl.getName());
        deepCopiedEl.setName("Вода");
        System.out.println(deepCopiedEl.getName());
        System.out.println(fire.getName());
    }
}
