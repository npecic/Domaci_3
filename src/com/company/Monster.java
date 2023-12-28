package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// ... (Your existing code)

// Base Monster class
abstract class Monster {
    protected double HP;
    protected boolean isDead;

    public Monster(double HP) {
        this.HP = HP;
        this.isDead = false;
    }

    public abstract void receiveHit();

    public boolean isDead() {
        return isDead;
    }
}

// Goblin monster
class Goblin extends Monster {
    public Goblin() {
        super(15);
    }

    @Override
    public void receiveHit() {
        if (!isDead) {
            this.HP -= 10;
            if (this.HP <= 0) {
                this.isDead = true;
                System.out.println("Goblin is defeated!");
            }
        }
    }
}

// Dragon monster
class Dragon extends Monster {
    public Dragon() {
        super(50);
    }

    @Override
    public void receiveHit() {
        if (!isDead) {
            this.HP -= 20;
            if (this.HP <= 0) {
                this.isDead = true;
                System.out.println("Dragon is defeated!");
            }
        }
    }
}

// Base Road class
abstract class Road {
    public abstract List<Monster> getMonsters();
}

// Forest road with goblins
class Forest extends Road {
    @Override
    public List<Monster> getMonsters() {
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Goblin());
        monsters.add(new Goblin());
        monsters.add(new Goblin());
        return monsters;
    }
}

// Mountain road with dragons
class Mountain extends Road {
    @Override
    public List<Monster> getMonsters() {
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Dragon());
        monsters.add(new Dragon());
        return monsters;
    }
}

// Desert road with a mix of goblins and dragons
class Desert extends Road {
    @Override
    public List<Monster> getMonsters() {
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Goblin());
        monsters.add(new Dragon());
        return monsters;
    }
}
