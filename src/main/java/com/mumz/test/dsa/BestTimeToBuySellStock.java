package com.mumz.test.dsa;

import java.util.Objects;

public class BestTimeToBuySellStock {

    public static int maxProfit(int[] prices) {
        if (Objects.isNull(prices) || prices.length == 0 || prices.length < 2) return 0;
        int buyPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int currentPrice = prices[i];
            if (buyPrice > currentPrice) {
                buyPrice = currentPrice;
            } else {
                int currentProfit = currentPrice - buyPrice;
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 4, 5, 3, 2, 1}));
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
