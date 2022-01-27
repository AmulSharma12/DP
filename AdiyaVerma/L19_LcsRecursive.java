import java.util.Scanner;

public class L19_LcsRecursive
{
	public static void main(String[] args)
	{
		String a = "abcde";
		String b = "ace";
		int result = longestCommonSubsequence(String text1, String text2);
		System.out.println(result);

	}


	//recursive approach
	public static  int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        return lcs(text1, text2, n, m);
    }

    public static int lcs(String x, String y, int n , int m)
    {
    	if(n == 0 || m == 0)	return 0;


    	//1 is added because we found one subsequences
    	if(x.charAt(n-1) == y.charAt(m-1))
    		return 1 + lcs(x, y, n-1, m-1);

    	return max(lcs(x, y, n, m-1)  , lcs(x, y, n-1, m));
    }


    public static int max(int first , int second)
    {
    	return (first > second) ? first : second;
    }
}