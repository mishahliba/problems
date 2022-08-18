package main.java.leetcode;

public class BestTimeToBuyAndSell121 {
    public static void main(String[] args) {

        var solution = new BestTimeToBuyAndSell121();
        int[] pricesArray = {3, 3, 5, 0, 0, 3, 1, 4};
        var profit = solution.maxProfitDumb(pricesArray);
        System.out.println(profit);

    }

    public int maxProfitDumb(int[] prices) {
        int lowest = Integer.MAX_VALUE;
        int highest = Integer.MIN_VALUE;
        int highestIndex = 0;
        int lowestIndex = 0;
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < lowest) {
                lowest = prices[i];
                lowestIndex = i;
            }
            if (prices[i + 1] >= highest || prices[i + 1] - lowest >= profit) {
                highest = prices[i + 1];
                highestIndex = i + 1;
            }
            if (highest - lowest >= profit && highestIndex > lowestIndex) profit = highest - lowest;
        }
        return profit;
    }

}
