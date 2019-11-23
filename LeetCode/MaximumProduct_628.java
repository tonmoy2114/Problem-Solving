public class MaximumProduct_628 {
    public static void main (String args[]){
        int[] arr1 = new int[]{7,1,5,3,6,4};
        int[] arr2 = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] arr3 = new int[]{2,3, -2,4};
        int[] arr4 = new int[]{7,100};
        int[] arr5 = new int[]{1,2,3,4,5};
        System.out.println("Max value"+ maximumProduct(arr3));
    }

    public static int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for(int n: nums){
            if(n<min1){
                min2 = min1;
                min1 = n;
            }
            else if(n<=min2){
                min2 = n;
            }
            if(n>max1){
                max3 = max2;
                max2 = max1;
                max1 = n;
            }else if(n>max2){
                max3 = max2;
                max2 = n;
            }else if(n>=max3){
                max3 = n;
            }
        }
        return Math.max(max1*max2*max3, min1*min2*max1);

    }
}
