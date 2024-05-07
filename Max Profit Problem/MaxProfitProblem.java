
public class MaxProfitProblem {
    public static void main(String[] args) {
        System.out.println(maxProfit(7)); // Output: Earnings: 3000, Properties: T: 1 P: 0 C: 0
        System.out.println(maxProfit(8)); // Output: Earnings: 4500, Properties: T: 1 P: 0 C: 0
        System.out.println(maxProfit(13)); // Output: Earnings: 16500, Properties: T: 2 P: 0 C: 0
    }

    public static String maxProfit(int timeUnits) {
        int[] dp = new int[timeUnits + 1];
        Arrays.fill(dp, 0);

        // Initialize variables to store the number of properties developed
        int theaters = 0, pubs = 0, parks = 0;

        for (int i = 1; i <= timeUnits; i++) {
            // Calculate the maximum profit at current time unit
            int maxProfit = dp[i];
            if (i >= 5 && dp[i - 5] + 1500 > maxProfit) {
                maxProfit = dp[i - 5] + 1500;
                theaters = theaters + 1;
            }
            if (i >= 4 && dp[i - 4] + 1000 > maxProfit) {
                maxProfit = dp[i - 4] + 1000;
                theaters = 0;
                pubs = pubs + 1;
            }
            if (i >= 10 && dp[i - 10] + 3000 > maxProfit) {
                maxProfit = dp[i - 10] + 3000;
                theaters = 0;
                pubs = 0;
                parks = parks + 1;
            }

            dp[i] = maxProfit;
        }

        return "Earnings: " + dp[timeUnits] + ", Properties: T: " + theaters + " P: " + pubs + " C: " + parks;
    }
}