package com.company;

public class HumanKnight extends BaseHero {

    public HumanKnight(double HP, double MP, boolean isDead) {
        super(HP, MP, isDead);
    }

    @Override
    public void receiveHit() {
        if (!isDead) {
            this.HP -= 20;
            if (this.HP <= 0) {
                this.isDead = true;
                this.HP = 0;
                System.out.println("Human Knight is dead!");
            }
        } else {
            System.out.println("Human Knight is already dead!");
        }
    }

    @Override
    public void firePrimary() {
        if (!isDead) {
            this.MP -= 10;
            System.out.println("Human Knight uses Sword Slash. MP reduced by 10.");
        } else {
            System.out.println("Human Knight is dead and cannot use Sword Slash!");
        }
    }

    @Override
    public void fireSecondary() {
        if (!isDead) {
            this.MP -= 20;
            System.out.println("Human Knight uses Shield Bash. MP reduced by 20.");
        } else {
            System.out.println("Human Knight is dead and cannot use Shield Bash!");
        }
    }

    @Override
    public String toString() {
        return "HumanKnight : HP: " + this.HP + " MP: " + this.MP + " Dead: " + isDead;
    }
}
