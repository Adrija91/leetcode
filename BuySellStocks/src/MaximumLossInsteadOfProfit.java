public class MaximumLossInsteadOfProfit {

    public int maxLoss(int[] prices) {

        int maxPrice = Integer.MIN_VALUE;


        int maxLoss = 0;

        for(int i:prices)
        {
            maxPrice=Math.max(i,maxPrice);
            maxLoss=Math.min(i-maxPrice,maxLoss);
        }

        return maxLoss;
    }

    public static void main(String[] args) {

        MaximumLossInsteadOfProfit solution = new MaximumLossInsteadOfProfit();

        int[] prices = {7, 1, 5, 3, 6, 4};

        int result = solution.maxLoss(prices);

        System.out.println("Maximum Loss: " + result);
    }
}