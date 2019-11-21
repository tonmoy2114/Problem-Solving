import java.util.Arrays;

public class ProductExceptSelf_238 {

    public static void main (String args[]){
        int[] arr1 = new int[]{7,1,5,3,6,4};
        int[] arr2 = new int[]{7,6,5,4,3,2,1};
        int[] arr3 = new int[]{7};
        int[] arr4 = new int[]{7,100};
        int[] arr5 = new int[]{1,2,3,4,5};
        System.out.println("Product"+ Arrays.toString(productExceptSelf(arr1)));
        System.out.println("Product"+ Arrays.toString(productExceptSelf(arr2)));
        System.out.println("Product"+ Arrays.toString(productExceptSelf(arr3)));
        System.out.println("Product"+ Arrays.toString(productExceptSelf(arr4)));
        System.out.println("Product"+ Arrays.toString(productExceptSelf(arr5)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        if(nums.length==0) return result;
        result[0] = nums[0];
        if(nums.length==1) return result;
        int i=1;
        for(; i<nums.length; i++){
            result[i] = nums[i] * result[i-1];
        }
        i = nums.length-1;
        int rightSum =nums[i];
        result[i] = result[i-1];
        i--;
        for(; i>=1; i--){
            result[i] = rightSum * result[i-1];
            rightSum*=nums[i];
        }
        result[0] = rightSum;
        return result;
    }
}
