package com.company;

public class ElfMage extends BaseHero {

    public ElfMage(double HP, double MP, boolean isDead) {
        super(HP, MP, isDead);
    }

    @Override
    public void receiveHit() {
        if (!isDead) {
            this.HP -= 30;
            if (this.HP <= 0) {
                this.isDead = true;
                this.HP = 0;
                System.out.println("Elf Mage is dead!");
            }
        } else {
            System.out.println("Elf Mage is already dead!");
        }
    }

    @Override
    public void firePrimary() {
        if (!isDead) {
            this.MP -= 15;
            System.out.println("Elf Mage casts Fireball. MP reduced by 15.");
            // Increase damage for the fireball
            this.HP -= 20;
            if (this.HP <= 0) {
                this.isDead = true;
                this.HP = 0;
                System.out.println("Elf Mage is dead!");
            }
        } else {
            System.out.println("Elf Mage is dead and cannot cast Fireball!");
        }
    }

    @Override
    public void fireSecondary() {
        if (!isDead) {
            this.MP -= 50;
            System.out.println("Elf Mage casts Meteor Shower. MP reduced by 50.");
            // Increase damage for the meteor shower
            this.HP -= 40;
            if (this.HP <= 0) {
                this.isDead = true;
                this.HP = 0;
                System.out.println("Elf Mage is dead!");
            }
        } else {
            System.out.println("Elf Mage is dead and cannot cast Meteor Shower!");
        }
    }

    @Override
    public String toString() {
        return "ElfMage : HP: " + this.HP + " MP: " + this.MP + " Dead: " + isDead;
    }
}
