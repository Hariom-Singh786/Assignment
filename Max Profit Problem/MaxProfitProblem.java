import java.util.*;

class LandDevelopment {
    static class Building {
        String type;
        int time;
        int earning;

        Building(String type, int time, int earning) {
            this.type = type;
            this.time = time;
            this.earning = earning;
        }
    }

    public static void main(String[] args) {
        // Define the buildings: Theatre, Pub, and Commercial Park
        Building theatre = new Building("Theatre", 5, 1500);
        Building pub = new Building("Pub", 4, 1000);
        Building commercialPark = new Building("Commercial Park", 10, 3000);
        int timeUnits = 13;
        int theatreCount = 0;
        int pubCount = 0;
        int commercialParkCount = 0;

        // Calculate the maximum profit
        int maxProfit = 0;

        // Try all possible combinations of buildings
        for (int t = 0; t <= timeUnits; t++) {
            for (int p = 0; p <= timeUnits - t; p++) {
                int c = timeUnits - t - p; // Remaining time for Commercial Park

                // Calculate earnings for this combination
                int totalEarnings = t * theatre.earning + p * pub.earning + c * commercialPark.earning;

                // Update maxProfit if this combination yields higher earnings
                if (totalEarnings > maxProfit) {
                    maxProfit = totalEarnings;
                    theatreCount = t;
                    pubCount = p;
                    commercialParkCount = c;
                }
            }
        }

        // Output the solution
        System.out.println("Time Unit: " + timeUnits);
        System.out.println("Earnings: $" + maxProfit);
        System.out.println("Solutions:");
        System.out.println("T: " + theatreCount + " P: " + pubCount + " C: " + commercialParkCount);
    }
}
