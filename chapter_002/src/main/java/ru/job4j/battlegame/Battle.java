package ru.job4j.battlegame;


import ru.job4j.battlegame.units.BaseRace;
import ru.job4j.battlegame.units.elf.ElvenRace;
import ru.job4j.battlegame.units.human.HumanRace;
import ru.job4j.battlegame.units.orc.OrcRace;
import ru.job4j.battlegame.units.undead.UndeadRace;
import ru.job4j.battlegame.utils.Log;

import java.util.Random;

import static ru.job4j.battlegame.utils.Log.writeLog;

/**
 * Random battle.
 *
 * @author Ruzhev Alexander
 * @since 24.06.2017
 */
public class Battle {
    /**
     * Orc`s or undead`s.
     */
    private Squad darkSquad = new Squad();
    /**
     * Human`s or elf`s.
     */
    private Squad lightSquad = new Squad();

    /**
     * Pass move to random squad.
     */
    private void moveToRandomSquad() {
        Random random = new Random();
        if (random.nextInt(50) < 25) {
            lightSquad.goToRandomUnit(darkSquad);
        } else {
            darkSquad.goToRandomUnit(lightSquad);
        }
    }

    /**
     * Create squad whit race.
     *
     * @param race  - chosen race
     * @param squad - chosen squad
     */
    private void createSquad(BaseRace race, Squad squad) {
        Random random = new Random();
        int index;
        for (index = 0; index < 4; index++) {
            if (random.nextInt(50) < 25) {
                squad.addImproved(race.getWarrior().clone());
            } else {
                squad.addNormal(race.getWarrior().clone());
            }
        }
        for (index = index; index < 7; index++) {
            if (random.nextInt(50) < 25) {
                squad.addImproved(race.getArcher().clone());
            } else {
                squad.addNormal(race.getArcher().clone());
            }
        }
        if (random.nextInt(50) < 25) {
            squad.addImproved(race.getMage().clone());
        } else {
            squad.addNormal(race.getMage().clone());
        }
    }

    /**
     * Start random battle.
     */
    private void toRandomBattle() {
        int move = 0;
        Random random = new Random();
        if (random.nextInt(50) < 25) {
            createSquad(new HumanRace(), lightSquad);
        } else {
            createSquad(new ElvenRace(), lightSquad);
        }
        if (random.nextInt(50) < 25) {
            createSquad(new OrcRace(), darkSquad);
        } else {
            createSquad(new UndeadRace(), darkSquad);
        }

        while (lightSquad.checkSquadLive() && darkSquad.checkSquadLive()) {
            Log.printInfo(String.format("move - %s%s", move++, System.lineSeparator()));
            Log.printInfo(String.format("light squad - %s dark squad - %s%s", lightSquad.getSquad().length, darkSquad.getSquad().length, System.lineSeparator()));
            moveToRandomSquad();
        }

        if (lightSquad.checkSquadLive()) {
            Log.printInfo(String.format("The light units won!%sSurvivors:%s", System.lineSeparator(), System.lineSeparator()));
            for (int i = 0; i < lightSquad.getSquad().length; i++) {
                Log.printInfo(String.format("   %s(%s)%s", lightSquad.getSquad()[i].getName(), lightSquad.getSquad()[i].getHealthPoints(), System.lineSeparator()));
            }
        } else {
            Log.printInfo(String.format("The dark units won!%sSurvivors:%s", System.lineSeparator(), System.lineSeparator()));
            for (int i = 0; i < darkSquad.getSquad().length; i++) {
                Log.printInfo(String.format("   %s(%s)%s", darkSquad.getSquad()[i].getName(), darkSquad.getSquad()[i].getHealthPoints(), System.lineSeparator()));
            }
        }
    }

    /**
     * main.
     *
     * @param args - String
     */
    public static void main(String[] args) {
        Battle battle = new Battle();
        battle.toRandomBattle();
        writeLog();
    }
}