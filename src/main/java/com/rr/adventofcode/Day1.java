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
public class Day1 {

    public static void main(String[] args) throws IOException {
        Path input = Paths.get("/home/matt/family/adventofcode/day1.txt");
        List<String> numbers = FileUtils.readLines(input.toFile(), "UTF-8");
        int[] nums = new int[numbers.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(numbers.get(i));
        }

        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            for (int j = 0; j < nums.length; j++) {
                int num2 = nums[j];
                int p1Total = num1 + num2;
                if (p1Total == 2020) {
                    System.out.println(num1 + " " + num2 + " " + num1 * num2);
                }
                for (int k = 0; k < nums.length; k++) {
                    int num3 = nums[k];
                    int total = num1 + num2 + num3;
                    if (total == 2020) {
                        System.out.println(num1 + " " + num2 + " " + " " + num3 + " " + num1 * num2 * num3);
                    }
                }
            }
        }
    }
}
