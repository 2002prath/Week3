package Stack;

import java.util.*;

class CircularTour {
    // Function to find the starting petrol pump index
    public static int findStartingPump(int[] petrol, int[] distance) {
        int totalSurplus = 0, currentSurplus = 0, startIndex = 0;

        for (int i = 0; i < petrol.length; i++) {
            int balance = petrol[i] - distance[i];
            totalSurplus += balance;
            currentSurplus += balance;

            // If surplus becomes negative, reset starting index
            if (currentSurplus < 0) {
                startIndex = i + 1;
                currentSurplus = 0;
            }
        }

        // If total petrol is less than total distance, circular tour is impossible
        return (totalSurplus >= 0) ? startIndex : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int startIndex = findStartingPump(petrol, distance);
        System.out.println("Starting Index = " + startIndex);
    }
}

