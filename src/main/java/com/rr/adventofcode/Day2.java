/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rr.adventofcode;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author matt
 */
public class Day2 {

    public static void main(String[] args) throws IOException {
        Path input = Paths.get("/home/matt/family/adventofcode/day2.txt");
        List<String> rules = FileUtils.readLines(input.toFile(), "UTF-8");
        int part1Total = 0;
        int part2Total = 0;
        for (String number : rules) {

            String[] parts = number.split(":");
            String rule = parts[0];
            String word = parts[1].trim();
            String[] p2 = rule.split("\\s+");
            char letter = p2[1].charAt(0);
            p2 = p2[0].split("-");
            int low = Integer.parseInt(p2[0]);
            int high = Integer.parseInt(p2[1]);

            System.out.println(low + " " + high + " " + letter + " " + word);
            int count = 0;
            for (int i = 0; i < word.length(); i++) {
                if (letter == word.charAt(i)) {
                    count++;
                }
            }
            if (count >= low && count <= high) {
                System.out.println("   Part 1");
                part1Total++;
            }
            int match = 0;
            if (word.charAt(low - 1) == letter) {
                match++;
            }
            if (word.charAt(high - 1) == letter) {
                match++;
            }
            if (match == 1) {
                part2Total++;
                System.out.println("   Part 2");
            }
        }
        System.out.println("Totals " + rules.size());
        System.out.println("Part 1 = " + part1Total);
        System.out.println("Part 2 = " + part2Total);
    }
}
