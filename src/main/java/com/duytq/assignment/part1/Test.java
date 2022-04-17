package com.duytq.assignment.part1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public void endGame(int finalScore) throws IOException {
        List<String> scores = retrieveScores();
        addNewScore(finalScore, scores);
        writeScores(scores);
        showLeaderBoard(scores);
    }

    private List<String> retrieveScores() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("score.json"));
        String scoreLine = reader.readLine(); // read line that contains scores
        List<String> scores = new ArrayList<>();
        if (scoreLine != null) { // in case of first game
            String[] tempScore = scoreLine.split(", ");
            scores = new ArrayList<>(Arrays.asList(tempScore));
        }
        reader.close();
        return scores;
    }

    private void addNewScore(int finalScore, List<String> scores) {
        boolean foundSpotForNewScore = false;
        int i = 0;
        while (!foundSpotForNewScore && i < scores.size()) {
            if (finalScore <= Integer.parseInt(scores.get(i))) {
                foundSpotForNewScore = true;
            }
            i++;
        }
        scores.add(i, String.valueOf(finalScore));
    }

    private void writeScores(List<String> scores) throws IOException {
        FileWriter writer = new FileWriter("./score.json");
        String outputScores = scores.toString();
        outputScores = outputScores.replace("[", "");
        outputScores = outputScores.replace("]", "");

        writer.write(outputScores + "\n");
        writer.close();
    }

    private void showLeaderBoard(List<String> scores) {
        System.out.println("*** TOP 5 LEADERBOARD ***");
        int i = 0;
        while (i < 5 && i < scores.size()) {
            System.out.println(scores.get(i));
            i++;
        }
        System.out.println("*** TOP 5 LEADERBOARD ***");
    }


    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        System.out.println(list);


        //Replace C with C_NEW


        //1 - In multiple steps

        int index = list.indexOf("C1");

        list.set(index, "C_NEW");

        System.out.println(list);
    }
}
