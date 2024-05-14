package ru.sgu;

class BasePokemon implements Pokemon, Cloneable {

    private String name;
    protected int healthPoints;
    private Element element;


    public BasePokemon(String name, int healthPoints, Element element) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.element = element;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Element getElement() {
        return element;
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

    @Override
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
                name.equals(basePokemon.name) && element.equals(basePokemon.element);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + healthPoints;
        result = 31 * result + element.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return name + " (" + healthPoints + " HP), element = " + element;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public BasePokemon deepClone() throws CloneNotSupportedException {
        BasePokemon newBasePokemon = (BasePokemon) super.clone();
        newBasePokemon.element = (Element) element.clone();
        return newBasePokemon;
    }
}