package com.company;

public class DwarfWarrior extends BaseHero {


    public DwarfWarrior(double HP, double MP, boolean isDead) {
        super(HP, MP, isDead);
    }

    @Override
    public void receiveHit() {
        if (!isDead){
            this.HP -=  10;
            if(this.HP<=0){
                this.isDead = true;
                this.HP =0;
                System.out.println("Hero is dead!");
            }
        } else {
            System.out.println("Hero is dead!");
        }

    }

    @Override
    public void firePrimary() {
        this.MP -=  5;
    }

    @Override
    public void fireSecondary() {
        this.MP -=  10;
    }
    @Override
    public String toString(){
        return "DwarfWarrior : HP: "+this.HP + " MP:"+ this.MP + " Dead: " + isDead;
    }
}
