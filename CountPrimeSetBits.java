import java.util.HashSet;
/*
 Given two integers L and R, find the count of numbers in the range [L, R] (inclusive) having a prime number of set bits in their binary representation.
(Recall that the number of set bits an integer has is the number of 1s present when written in binary. For example, 21 written in binary is 10101 which has 3 set bits. Also, 1 is not a prime.)*/
public class CountPrimeSetBits{

   public static void main(String []args){
      System.out.println("Result"+ countPrimeSetBits(6,10));
   }
	 
   static public int countPrimeSetBits(int L, int R) {
      HashSet<Integer> primeSet= new HashSet<>();
      primeSet.add(2);
      primeSet.add(3);
      primeSet.add(5);
      primeSet.add(7);
      primeSet.add(11);
      primeSet.add(13);
      primeSet.add(17);
      primeSet.add(19);
      primeSet.add(23);
      primeSet.add(29);
      primeSet.add(31);
   
      int countPrime =0;
      for(int i = L; i<= R; i++)
      {
         int countSetBit= countSetBit(i);
             
         if(primeSet.contains(countSetBit))
         {
            countPrime++;
         }
      }
      return countPrime;
   }
   static int countSetBit(int num)
   {
      int count = 0;
      while(num!=0)
      {
         num = num & (num-1);
         count++;
      }
      return count;
   }
}
