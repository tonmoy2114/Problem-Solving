public class MaxProfitStock_121 {
    public static void main (String args[]){
        int[] arr1 = new int[]{7,1,5,3,6,4};
        int[] arr2 = new int[]{7,6,5,4,3,2,1};
        int[] arr3 = new int[]{7};
        int[] arr4 = new int[]{7,100};
        int[] arr5 = new int[]{700,100};
        System.out.println("Max Profit"+ maxProfit(arr1));
        System.out.println("Max Profit"+ maxProfit(arr2));
        System.out.println("Max Profit"+ maxProfit(arr3));
        System.out.println("Max Profit"+ maxProfit(arr4));
        System.out.println("Max Profit"+ maxProfit(arr5));
    }

    public static int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int lowPrice = prices[0];
        int profit = 0;
        for(int i=0; i< prices.length;i++){
            if(prices[i]<lowPrice){
                lowPrice = prices[i];
            }
            else if(profit < (prices[i]-lowPrice)){
                profit = prices[i]-lowPrice;
            }
        }
        return profit;
    }
}
