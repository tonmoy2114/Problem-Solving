public class MaxProfitStock2_122 {

    public static void main (String args[]){
        int[] arr1 = new int[]{7,1,5,3,6,4};
        int[] arr2 = new int[]{7,6,5,4,3,2,1};
        int[] arr3 = new int[]{7};
        int[] arr4 = new int[]{7,100};
        int[] arr5 = new int[]{1,2,3,4,5};
        System.out.println("Max Profit"+ maxProfit(arr1));
        System.out.println("Max Profit"+ maxProfit(arr2));
        System.out.println("Max Profit"+ maxProfit(arr3));
        System.out.println("Max Profit"+ maxProfit(arr4));
        System.out.println("Max Profit"+ maxProfit(arr5));
    }

    public static int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int buyPrice = prices[0];
        int sellPrice = 0;
        int i=0;
        int profit = 0;

        while(i<prices.length){
            while(i<prices.length && buyPrice >= prices[i]){
                buyPrice = prices[i];
                i++;
            }
            if(i>=prices.length) break;
            sellPrice = prices[i];
            while(i<prices.length && sellPrice <= prices[i]){
                sellPrice = prices[i];
                i++;
            }
            profit= profit + sellPrice-buyPrice;
            if(i<prices.length) buyPrice = prices[i++];
        }
        return profit;
    }
}
