package com.company;

public abstract class BaseHero {
    public double HP, MP;
    public boolean isDead;

    public BaseHero(double HP, double MP, boolean isDead) {
        this.HP = HP;
        this.MP = MP;
        this.isDead = isDead;
    }

    public void areaOfEffect() {
        // Implement your logic for area of effect
    }

    public abstract void receiveHit();

    public abstract void firePrimary();

    public abstract void fireSecondary();

    public boolean isDead() {
        return isDead;
    }
}
