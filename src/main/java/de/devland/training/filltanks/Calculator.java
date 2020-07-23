package de.devland.training.filltanks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public static int calculateVolume(int... wallHeights) {
        List<Tank> tanks = new ArrayList<>();
        if (wallHeights.length < 2) {
            throw new IllegalArgumentException("A tank needs at least two walls");
        }

        // add initial walls
        tanks.add(new Tank(wallHeights[0], wallHeights[1]));

        for (int i = 2; i < wallHeights.length; i++) {
            int height = wallHeights[i];
            boolean end = backtrack(height, tanks);
            if (end) {
                break;
            }
        }

        int volume = tanks.stream()
                .peek(System.out::println)
                .mapToInt(Tank::getVolume)
                .sum();


        return volume;
    }

    private static boolean backtrack(int currentHeight, List<Tank> tanks) {
        Tank previous = tanks.get(tanks.size() - 1);
        if (previous.getHeightRight() > currentHeight) {
            tanks.add(new Tank(previous.getHeightRight(), currentHeight));
            return false;
        }


        Tank first = tanks.get(0);
        if (currentHeight > first.getHeightLeft()) {
            previous.setHeightRight(currentHeight);
            previous.setWidth(previous.getWidth() + 1);
            return true;
        }


        if (currentHeight >= previous.getHeightRight()) {
            previous.setHeightRight(currentHeight);
            previous.setWidth(previous.getWidth() + 1);
            return false;
        }


        return false;
    }
}
