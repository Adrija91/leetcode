public class MaxProfitAndWays {

    public int[] maxProfitAndWays(int[] prices) {

        if (prices == null || prices.length < 2) {
            return new int[]{0, 0};
        }

        int minPrice = Integer.MAX_VALUE;
        int minPriceCount = 0;

        int maxProfit = 0;
        int ways = 0;

        for (int price : prices) {

            // Calculate profit using the minimum seen so far
            if (minPrice != Integer.MAX_VALUE) {

                int profit = price - minPrice;

                if (profit > maxProfit) {

                    maxProfit = profit;
                    ways = minPriceCount;

                } else if (profit == maxProfit && profit > 0) {

                    ways += minPriceCount;
                }
            }

            // Update minimum price information
            if (price < minPrice) {

                minPrice = price;
                minPriceCount = 1;

            } else if (price == minPrice) {

                minPriceCount++;
            }
        }

        return new int[]{maxProfit, ways};
    }

    public static void main(String[] args) {

        MaxProfitAndWays solution = new MaxProfitAndWays();

        int[] prices = {1, 5, 1, 5};

        int[] result = solution.maxProfitAndWays(prices);

        System.out.println("Maximum Profit: " + result[0]);
        System.out.println("Number of Ways: " + result[1]);
    }
}