package com.company;

public class OrcShaman extends BaseHero {

    public OrcShaman(double HP, double MP, boolean isDead) {
        super(HP, MP, isDead);
    }

    @Override
    public void receiveHit() {
        if (!isDead) {
            this.HP -= 25;
            if (this.HP <= 0) {
                this.isDead = true;
                this.HP = 0;
                System.out.println("Orc Shaman is dead!");
            }
        } else {
            System.out.println("Orc Shaman is already dead!");
        }
    }

    @Override
    public void firePrimary() {
        if (!isDead) {
            this.MP -= 15;
            System.out.println("Orc Shaman casts Lightning Bolt. MP reduced by 15.");
        } else {
            System.out.println("Orc Shaman is dead and cannot cast Lightning Bolt!");
        }
    }

    @Override
    public void fireSecondary() {
        if (!isDead) {
            this.MP -= 30;
            System.out.println("Orc Shaman casts Heal. MP reduced by 30.");
        } else {
            System.out.println("Orc Shaman is dead and cannot cast Heal!");
        }
    }

    @Override
    public String toString() {
        return "OrcShaman : HP: " + this.HP + " MP: " + this.MP + " Dead: " + isDead;
    }
}
