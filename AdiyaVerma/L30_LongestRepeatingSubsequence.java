import java.util.Scanner;


// longest repeating subsequence
public class L30_LongestRepeatingSubsequence
{
	public static void main(String[] args)
	{
		String s = "AABEBCDD";
		String a = s;
		int n = s.length();

		int result = lrs(s, a, n, n);
		System.out.println(result);
	}

	//ABD IS the longest repeating subsequence
	public static int lrs(String x, String y, int m, int n)
	{
		if(m == 0 || n == 0)
			return 0;

		if(x.charAt(m-1) == y.charAt(n-1)  &&  m!=n)
			return 1 + lrs(x, y, m-1, n-1);

		return Math.max(lrs(x, y, m, n-1) , lrs(x, y, m-1, n));
	}

}