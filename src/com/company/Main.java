package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select a race (1. Dwarf Warrior, 2. Elf Mage, 3. Human Knight, 4. Orc Shaman): ");
        int selectedRace = scanner.nextInt();

        BaseHero hero = createHero(selectedRace);

        if (hero != null) {
            System.out.println("Do you want to go on an adventure? (yes/no): ");
            String adventureChoice = scanner.next().toLowerCase();

            if (adventureChoice.equals("yes")) {
                System.out.println("Choose a road (1. Forest, 2. Mountain, 3. Desert): ");
                int selectedRoad = scanner.nextInt();
                Road road = createRoad(selectedRoad);
                if (road != null) {
                    encounterMonsters(hero, road);
                } else {
                    System.out.println("Invalid road selection.");
                }
            } else {
                System.out.println("Maybe next time. Goodbye!");
            }
        } else {
            System.out.println("Invalid race selection.");
        }
    }

    private static BaseHero createHero(int selectedRace) {
        switch (selectedRace) {
            case 1:
                return new DwarfWarrior(1850, 750, false);
            case 2:
                return new ElfMage(1000, 2500, false);
            case 3:
                return new HumanKnight(2500, 500, false);
            case 4:
                return new OrcShaman(1200, 2500, false);
            default:
                return null;
        }
    }

    private static Road createRoad(int selectedRoad) {
        switch (selectedRoad) {
            case 1:
                return new Forest();
            case 2:
                return new Mountain();
            case 3:
                return new Desert();
            default:
                return null;
        }
    }

    private static void encounterMonsters(BaseHero hero, Road road) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entering the " + road.getClass().getSimpleName());
        System.out.println("Encountering monsters...");

        for (Monster monster : road.getMonsters()) {
            System.out.println("You encounter a " + monster.getClass().getSimpleName());
            System.out.println("Do you want to fight? (yes/no): ");
            String fightChoice = scanner.next().toLowerCase();

            if (fightChoice.equals("yes")) {
                battle(hero, monster);
            } else {
                System.out.println("You choose not to fight and continue on the road.");
            }
        }

        System.out.println("You have completed the adventure!");
        System.out.println(hero);
    }

    private static void battle(BaseHero hero, Monster monster) {
        System.out.println("Battle started!");

        while (!hero.isDead() && !monster.isDead()) {
            hero.receiveHit();
            monster.receiveHit();
        }

        if (hero.isDead()) {
            System.out.println("You were defeated by the " + monster.getClass().getSimpleName());
        } else {
            System.out.println("You defeated the " + monster.getClass().getSimpleName());
        }
    }
}
