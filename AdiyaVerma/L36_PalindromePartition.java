import java.util.Scanner;

public class L36_PalindromePartition
{
	public static void main(String[] args)
	{
		String s = "aab";
		System.out.println(minCut(s));
	}


	 public static int minCut(String s) {
        int n = s.length();

        return minCutToMakePalindrome(s, 1, n-1);
    }



    public static int minCutToMakePalindrome(String s, int i, int j)
    {
    	if(i >= j)
    		return 0;

    	if(isPalindrome(s, i, j))
    		return 0;

    	int minPartitions = Integer.MAX_VALUE;

    	for(int k = i; k<j; k++)
    	{
    		int tempAns = 1 + minCutToMakePalindrome(s,i,k) + minCutToMakePalindrome(s,k+1, j);
    		if(tempAns < minPartitions)
    			minPartitions = tempAns;

    	}


    	return minPartitions;
    }



    public static boolean isPalindrome(String x, int i, int j)
    {
    	if(i >= j)
    		return true;

    	if(x.charAt(i) != x.charAt(j))
    		return false;
    	i++;
    	j--;

    	return true;

    }
}