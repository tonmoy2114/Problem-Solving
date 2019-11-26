public class SearchRotatedSortedArray_33 {
  public static void main(String[] args) {
    int[] arr1 = new int[] {0, 1, 3, 4, 5, 6};
    int[] arr2 = new int[] {3, 1};
    int[] arr3 = new int[] {2, 3, -2, 1};
    int[] arr4 = new int[] {4, 5, 6, 7, 0, 1, 2};
    int[] arr5 = new int[] {1, 2, 3, 4, 5};
    System.out.println("Max value" + findRotatePointIndex(arr1, 0, 0, arr1.length - 1));
    System.out.println("Max value" + findRotatePointIndex(arr2, 0, 0, arr2.length - 1));
    System.out.println("Max value" + search(arr4, 4));
    System.out.println("Max value" + search(arr2, 1));
  }

  public static int search(int[] nums, int target) {
    int index = findRotatePointIndex(nums, 0, 0, nums.length - 1);
    if (index == 0) {
      return binarySearch(nums, target, 0, nums.length - 1);
    } else {
      int a = binarySearch(nums, target, 0, index - 1);
      int b = binarySearch(nums, target, index, nums.length - 1);
      if (a == -1 && b == -1) return -1;
      else if (a == -1) return b;
      else return a;
    }
  }

  public static int findRotatePointIndex(int[] nums, int index, int low, int high) {
    int mid = (low + high) / 2;
    if (low == high) {
      if (nums[0] < nums[mid]) {
        return 0;
      } else {
        return mid;
      }
    }
    if (nums[index] <= nums[mid]) {
      return findRotatePointIndex(nums, index, mid + 1, high);
    } else {
      return findRotatePointIndex(nums, index, low, mid);
    }
  }

  public static int binarySearch(int[] nums, int target, int low, int high) {
    if (low > high) {
      return -1;
    }
    int mid = (low + high) / 2;
    if (nums[mid] == target) {
      return mid;
    } else if (nums[mid] < target) {
      return binarySearch(nums, target, mid + 1, high);
    } else {
      return binarySearch(nums, target, low, mid - 1);
    }
  }
}
