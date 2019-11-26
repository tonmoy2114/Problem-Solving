public class FindMinRatatedArray_153 {
    public static void main (String args[]){
        int[] arr1 = new int[]{0,1,3,4,5,6};
        int[] arr2 = new int[]{-2,-1,0};
        int[] arr3 = new int[]{2,3, -2,1};
        int[] arr4 = new int[]{4,5,6,7,0,1,2};
        int[] arr5 = new int[]{1,2,3,4,5};
        System.out.println("Max value"+ findMin(arr1));
        System.out.println("Max value"+ findMin(arr2));
        System.out.println("Max value"+ findMin(arr3));
        System.out.println("Max value"+ findMin(arr4));
    }

    public static int findMin(int[] nums) {
        return binarySearchMin(nums, nums[0], 0, nums.length-1);
    }

    public static int binarySearchMin(int[] nums, int min, int low, int high){
        int mid = (high+low)/2;
        if(low == high) return Math.min(min, nums[mid]);
        if(nums[mid]<min){
            return binarySearchMin(nums, nums[mid], low, mid);
        }else{
           return binarySearchMin(nums, min, mid+1, high);
        }

    }
}
