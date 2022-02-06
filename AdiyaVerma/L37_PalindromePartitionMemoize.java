import java.util.Scanner;

public class L37_PalindromePartitionMemoize
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = "nitim";
		int n = s.length();

		int[][] dp = new int[n+1][n+1];

		for(int i = 0; i<n; i++)
			for(int j = 0; j<n; j++)
				dp[i][j] = -1;
		System.out.println(minParition(s,0,n-1, dp));
	}

	public static int minParition(String x, int i, int j, int[][] dp)
	{
		if(i >= j)
			return 0;


		if(isPalindrome(x, i, j));
			return 0;



		if(dp[i][j] != -1)
			return dp[i][j];

		
		int min = Integer.MAX_VALUE;
		for(int k = i; k<j; k++)
		{
			int tempAns = 1 + minParition(x, i, k, dp) + minParition(x, k+1, j, dp);
			if(tempAns < min)
				min = tempAns;
		}



		return dp[i][j] = min;
	}



	public static boolean isPalindrome(String x, int i , int j)
	{
		if(i >= j)
			return true;


		if(x.charAt(i) != x.charAt(j))
			return false;


		return isPalindrome(x, i+1, j-1);
	}
}