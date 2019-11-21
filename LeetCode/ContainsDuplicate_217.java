import java.util.Set;
import java.util.HashSet;

public class ContainsDuplicate_217 {
    public static void main(String args[]){

        int[] arr1 = new int[]{7,1,5,3,6,7};
        int[] arr2 = new int[]{7,6,5,4,3,2,1};
        int[] arr3 = new int[]{7};
        int[] arr4 = new int[]{7,100};
        int[] arr5 = new int[]{1,2,2,4,5};
        System.out.println("Duplicate check" + containsDuplicate(arr1));
        System.out.println("Duplicate check" + containsDuplicate(arr2));
        System.out.println("Duplicate check" + containsDuplicate(arr3));
        System.out.println("Duplicate check" + containsDuplicate(arr4));
        System.out.println("Duplicate check" + containsDuplicate(arr5));


    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> sets = new HashSet<Integer>();
        for(int i=0; i< nums.length; i++){
            if(!sets.add(nums[i])){
                return true;
            }
        }
        return false;

    }
}
