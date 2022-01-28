import java.util.Scanner;


public class L28_MinDelToMakePalindrome
{
	public static void main(String[] args)
	{
		String s = "agbcba";
		int n = s.length();
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		String x = sb.toString();


		int lps = lcs(s, x, n, n);

		//min deletions lead to longest palindromic string so in order to calculate we take the difference (s.length() - lps )
		int result = n -  lps;
		System.out.println(result);
	}



	public static int lcs(String x, String y, int m, int n)
	{
		if(m == 0 || n == 0)
			return 0;

		if(x.charAt(m-1) == y.charAt(n-1))
			return 1 + lcs(x,y, m-1, n-1);

		return Math.max(lcs(x, y, m, n-1)  , lcs(x, y, m-1, n));
	}
}