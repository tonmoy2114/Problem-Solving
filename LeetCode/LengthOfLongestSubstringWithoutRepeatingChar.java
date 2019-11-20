import java.util.HashMap;

class LengthOfLongestSubstringWithoutRepeatingChar {

    public static void main(String args[]){
        System.out.println("Result"+ lengthOfLongestSubstring("abba"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int resultLowIndex = 0;
        int resultHighIndex = 0;
        int low = 0;
        int high = 0;

        HashMap<Character, Integer> charIndexMap = new HashMap<Character, Integer>();

        char[] charArray = s.toCharArray();
        for(; high < s.length();){
            if(charIndexMap.containsKey(charArray[high]) && charIndexMap.get(charArray[high]) > low){
                low = charIndexMap.get(charArray[high]) + 1;
            }
            charIndexMap.put(charArray[high], high);
            high++;
            if( (high-low) > (resultHighIndex - resultLowIndex)){
                resultHighIndex = high;
                resultLowIndex = low;
            }
        }
        return resultHighIndex-resultLowIndex;

    }
}