package de.devland.training.filltanks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        int[] heights = Arrays.stream(args)
                .mapToInt(Integer::parseInt)
                .toArray();
        int vol = Calculator.calculateVolume(heights);

        System.out.println("Accumulated Volume: " + vol);
    }
}
