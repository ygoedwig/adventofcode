/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rr.adventofcode;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author matt
 */
public class Day3 {

    public static void main(String[] args) throws IOException {
        Path input = Paths.get("/home/matt/family/adventofcode/day3.txt");
        List<String> lines = FileUtils.readLines(input.toFile(), "UTF-8");
        System.out.println(lines.size());
        List<Route> routes = new ArrayList<>();
        routes.add(new Route(1, 1));
        routes.add(new Route(3, 1));
        routes.add(new Route(5, 1));
        routes.add(new Route(7, 1));
        routes.add(new Route(1, 2));
        long answer = 1;
        for (Route route : routes) {
            System.out.println(route);
            int subTotal = 0;
            int count = 0;
            int col = 0;
            for (Iterator<String> iterator = lines.iterator(); iterator.hasNext();) {
                String line = iterator.next();

                if (route.down == 2) {
                    //  System.out.println(line + " " + line.length() + " " + "x " + col);
                }
                if (line.charAt(col) == '#') {
                    subTotal++;
                }
                col += route.right;
                col = col % line.length();
                count++;
                if (route.down == 2) {
                    if (!iterator.hasNext()) {
                        break;
                    }
                    line = iterator.next();
                }
            }
            answer *= subTotal;
            System.out.println("SubTotal " + subTotal + " / " + count + "  " + answer);
        }
        System.out.println(answer);
    }

    static class Route {

        int right;
        int down;

        public Route(int right, int down) {
            this.right = right;
            this.down = down;
        }

        @Override
        public String toString() {
            return "Route{" + "right=" + right + ", down=" + down + '}';
        }

    }
}
