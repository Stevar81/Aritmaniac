/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aritmaniac.actors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Class for the high scores-list
 * @author Tomi
 */
public final class Scores {

    private List<Player> scores;
    private Scanner in;
    final String chars = "1234567890";
    private File f;

    /**
     *
     * @throws FileNotFoundException
     */
    public Scores() throws FileNotFoundException {
        this.scores = new ArrayList<>();
        this.f = new File("src/main/resources/filename.txt");
        makeList();
    }

    /**
     *
     * @param player
     */
    public void setScore(Player player) {
        this.scores.add(player);
    }

    /**
     * The list of high scores in order
     * @return
     */
    public List<Player> getList() {
        Collections.sort(this.scores, new Comparator<Player>() {
            @Override
            public int compare(Player player1, Player player2) {
                return player1.compareTo(player2);
            }
        });
        return this.scores;
    }

    /**
     * Separating players name and points from the text file. Creating Player-objects from them and putting them in the scores-list.
     * @throws FileNotFoundException
     */
    public void makeList() throws FileNotFoundException {
        if (f.exists() && !f.isDirectory()) {
            this.in = new Scanner(f);

            while (in.hasNext()) {
                int i = 0;
                String line = in.next();
                String points = "";
                String name = "";
                while (chars.contains(Character.toString(line.charAt(i)))) {
                    points += line.charAt(i);
                    i++;
                }
                while (i < line.length()) {
                    name += line.charAt(i);
                    i++;
                }
                Player player = new Player(name, Integer.parseInt(points));
                setScore(player);
            }
        }
    }

}
