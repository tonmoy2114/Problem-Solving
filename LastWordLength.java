/*
LeetCode 58. Length of Last Word

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5

*/

class LastWordLength{

static String testStrings[] = new String []{"cat","I love Bangladesh",null,"       ","I love Bangladesh   "};

public static void main(String args[])
{
	for(int i=0; i<testStrings.length;i++)
	{
		System.out.println("Length of "+ testStrings[i] + ": " + lengthOfLastWord(testStrings[i]));
	}
}
public static int lengthOfLastWord(String s) {
	if(s==null || s.length()==0)
		return 0;
	int i=s.length()-1;
	int length = 0;
	for(; i>=0; i--)
	{
		if(s.charAt(i)-'A'>=0 && s.charAt(i)-'z'<=0 )
		{
			length++;
			i--;
			break;
		}
	}
	
	for(; i>=0; i--)
	{
		if(s.charAt(i)-'A'>=0 && s.charAt(i)-'z'<=0 )
		{
			length++;
			continue;
		}
		break;
	}
	return length;
}

}
