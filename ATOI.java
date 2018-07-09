/*
Leetcode 8. String to Integer (atoi)


Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
Example 1:

Input: "42"
Output: 42
Example 2:

Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.
Example 3:

Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
Example 4:

Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical 
             digit or a +/- sign. Therefore no valid conversion could be performed.
Example 5:

Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Thefore INT_MIN (−231) is returned.

*/


class ATOI{
	static String testStrings[]=new String[]{"   -42","4193 with words", "words and 987","-91283472332", "2147483647", "2147483648","-2147483648","-2147483649","0","-1","-"," ","+", "00000121212132","2147483800", "     000000    " ,"2147483646","1175109307q7"};
	public static void main(String args[])
	{
		for(int i=0; i<testStrings.length;i++)
		{
			System.out.println(testStrings[i] + "becomes : " + myAtoi(testStrings[i]));
		}
	}
	
	public static int myAtoi(String str) {
	if(str==null || str.length() == 0)
		return 0;
	int i=0;
	while(i<str.length() && str.charAt(i)==' ')
		i++;
		
	if(i>=str.length() || !((str.charAt(i) >= '0' && str.charAt(i)<= '9') || str.charAt(i)== '+' || str.charAt(i)== '-'))
		return 0;
	int sign = 1;
	if(str.charAt(i)== '-')
	{
		sign = -1;
		i++;
	}else if(str.charAt(i)== '+')
	{
		sign = 1;
		i++;
	}
	while(i<str.length() && str.charAt(i)=='0')
		i++;
	int limit = i+10;
	int startIndex = i;
	int endIndex = -1;
	for(;i<str.length(); i++)
	{
		if(str.charAt(i) < '0' || str.charAt(i)> '9') 
		{
			break;
		}
		endIndex = i;
		if(endIndex>=limit) // large number
		{
			return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
		}
	}
	if(endIndex>=str.length() || endIndex==-1)return 0;
	int multiplyer =1;
	int number = 0;
	int j=endIndex;
	for(; j>startIndex; j--)
	{
		int temp = (str.charAt(j)-'0') * multiplyer;
		number+=temp;
		multiplyer *=10;
	}
	System.out.println(""+number);
	if(endIndex-startIndex==9)
	{
		if(str.charAt(j)>'2' && sign == -1)
		{
			return Integer.MIN_VALUE;
			
		}else if(str.charAt(j)>'2' && sign == 1)
		{
			return Integer.MAX_VALUE;
		}else if(str.charAt(j)=='2' && Integer.MAX_VALUE%2000000000 <= number && sign == 1)
		{
			return Integer.MAX_VALUE;
		}else if(str.charAt(j)=='2' && Integer.MAX_VALUE%2000000000 + 1 <= number  && sign == -1)
		{
			return Integer.MIN_VALUE;
		}
	}
	int temp = (str.charAt(j)-'0') * multiplyer;
	number+=temp;
	return number*sign;
	}
}
