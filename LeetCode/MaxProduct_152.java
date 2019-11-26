public class MaxProduct_152 {

  public static void main(String[] args) {
    int[] arr1 = new int[] {7, 1, 5, 3, 6, 4};
    int[] arr2 = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int[] arr3 = new int[] {2, 3, -2, 4};
    int[] arr4 = new int[] {7, 100};
    int[] arr5 = new int[] {1, 2, 3, 4, 5};
    System.out.println("Max value" + maxProduct(arr3));
  }

  public static int maxProduct(int[] nums) {
    int result = nums[0];
    int localMin = result;
    int localMax = result;
    for (int i = 1; i < nums.length; i++) {
      int prevLocalMax = localMax;
      localMax = Math.max(nums[i], localMax * nums[i]);
      localMax = Math.max(localMax, localMin * nums[i]);

      localMin = Math.min(nums[i], localMin * nums[i]);
      localMin = Math.min(localMin, prevLocalMax * nums[i]);

      result = Math.max(localMax, result);
      result = Math.max(localMin, result);
    }
    return result;
  }
}
