import java.net.Inet4Address;
import java.util.*;

public class ThreeSum_15 {
  public static void main(String[] args) {
    int[] arr1 = new int[] {-1, 0, 1, 2, -1, -4};
    int[] arr2 = new int[] {3, 0, -2, -1, 1, 2}; // expected [[-2,-1,3],[-2,0,2],[-1,0,1]]
    int[] arr3 = new int[] {-2, 0, 0, 2, 2}; // expected [[-2,0,2]]
    int[] arr4 = new int[] {0, 0, 0}; // expected [[0,0,0]]
    int[] arr5 = new int[] {1, 2, 3, 4, 5};
    System.out.println("threeSum: " + threeSum(arr1));
    System.out.println("threeSum: " + threeSum(arr2));
    System.out.println("threeSum: " + threeSum(arr3));
    System.out.println("threeSum: " + threeSum(arr4));
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Set<String> resultSet = new HashSet<String>();
    List<Integer> positiveNums = new ArrayList<Integer>();
    List<Integer> negativeNums = new ArrayList<Integer>();
    int i = 0;
    int j = 0;
    for (; i < nums.length; i++) {
      if (nums[i] >= 0) {
        positiveNums.add(nums[i]);
      } else {
        negativeNums.add(nums[i]);
      }
    }
    Collections.sort(positiveNums);
    Collections.sort(negativeNums);
    for (i = 0; i < positiveNums.size(); i++) {
      for (j = i + 1; j < positiveNums.size(); j++) {
        int a = positiveNums.get(i);
        int b = positiveNums.get(j);
        if (a + b == 0) {
          for (int k = 0; k < positiveNums.size() && positiveNums.get(k) <= 0; k++) {
            if (k == i || k == j) continue;
            resultSet.add("0,0,0");
            break;
          }
          continue;
        }
        int index = Collections.binarySearch(negativeNums, (a + b) * -1);
        if (index >= 0) {
          String data = "";
          if (a < b) {
            data += negativeNums.get(index) + "," + a + "," + b;
          } else {
            data += negativeNums.get(index) + "," + b + "," + a;
          }
          resultSet.add(data);
        }
      }
    }

    for (i = 0; i < negativeNums.size(); i++) {
      for (j = i + 1; j < negativeNums.size(); j++) {
        int a = negativeNums.get(i);
        int b = negativeNums.get(j);
        int index = Collections.binarySearch(positiveNums, (a + b) * -1);
        if (index >= 0) {
          String data = "";
          if (a < b) {
            data += a + "," + b + "," + positiveNums.get(index);
          } else {
            data += b + "," + a + "," + positiveNums.get(index);
          }
          resultSet.add(data);
        }
      }
    }
    for (String str : resultSet) {
      String[] arrOfStr = str.split(",");
      List<Integer> list = new ArrayList<Integer>(3);
      list.add(Integer.parseInt(arrOfStr[0]));
      list.add(Integer.parseInt(arrOfStr[1]));
      list.add(Integer.parseInt(arrOfStr[2]));
      result.add(list);
    }

    return result;
  }
}
