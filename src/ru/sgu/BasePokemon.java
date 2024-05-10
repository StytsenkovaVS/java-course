package ru.sgu;

interface Battle {
    void attack(BasePokemon enemy);
}

interface Pokemon {
    int compareTo(Pokemon other);
    boolean equals(Object obj);
    String toString();
    Object shallowCopy();
    Object deepCopy();
}

class BasePokemon implements Pokemon {

    private String name;
    protected int healthPoints;

    public BasePokemon(String name, int healthPoints) {
        this.name = name;
        this.healthPoints = healthPoints;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void takeDamage(int damage) {
        healthPoints -= damage;
    }

    public boolean isAlive() {
        return healthPoints > 0;
    }

    public int compareTo(Pokemon other) {
        BasePokemon otherBasePokemon = (BasePokemon) other;
        return this.name.compareTo(otherBasePokemon.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BasePokemon basePokemon = (BasePokemon) obj;
        return healthPoints == basePokemon.healthPoints &&
                name.equals(basePokemon.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + healthPoints;
        return result;
    }

    @Override
    public String toString() {
        return name + " (" + healthPoints + " HP)";
    }

    public BasePokemon shallowCopy() {
        try {
            return (BasePokemon) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public BasePokemon deepCopy() {
        return new BasePokemon(this.name, this.healthPoints);
    }
}