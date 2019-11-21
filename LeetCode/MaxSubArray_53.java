import java.util.Arrays;

public class MaxSubArray_53 {
    public static void main (String args[]){
        int[] arr1 = new int[]{7,1,5,3,6,4};
        int[] arr2 = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] arr3 = new int[]{7};
        int[] arr4 = new int[]{7,100};
        int[] arr5 = new int[]{1,2,3,4,5};
        System.out.println("Max value"+ maxSubArray(arr1));
        System.out.println("Max value"+ maxSubArray(arr2));
    }

    public static int maxSubArray(int[] nums) {
        if(nums.length==0) return 0;
        int tempMax= 0;
        int finalMax = nums[0];
        for(int i=0; i< nums.length; i++){
            tempMax = Math.max(nums[i], tempMax+nums[i]);
            finalMax = Math.max(finalMax, tempMax);
        }
        return finalMax;

    }
}
