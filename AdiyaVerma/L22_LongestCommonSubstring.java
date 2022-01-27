import java.util.Scanner;
// import java.util.Math;
public class L22_LongestCommonSubstring
{
	public static void main(String[] args)
	{
		String a = "abcde";
		String b = "abcef";
		int m = a.length();
		int n = b.length();
		int[][] dp = new int[m+1][n+1];

		//Initialisation-> base condition
		for(int i = 0; i<=m; i++)
			for(int j = 0; j<=n; j++)
				if(i == 0 || j == 0) 	dp[i][j] = 0;



		for(int i = 1; i<=m ;i++)
		{
			for(int j = 1; j<=n; j++)
			{
				if(a.charAt(i-1) == b.charAt(j-1))
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = 0;
			}
		}


		//refining the largest length in a matrix
		int length = Integer.MIN_VALUE;
		for(int i = 0; i<=m; i++)
		{
			for(int j = 0; j<=n; j++)
			{
					length = Math.max(length, dp[i][j]);
			}
		}



		System.out.println(length);
	}


}