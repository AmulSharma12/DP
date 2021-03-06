import java.util.Scanner;

//In order to convert string a to string b we have to calculate the minimum no of deletion and insertion 
public class L25_ConversionStringThroughInsertionDeletion
{
	public static void main(String[] args)
	{
		String a = "seak";
		String b = "pea";
		int m = a.length();
		int n = b.length();


		int[][] dp = new int[m+1][n+1];
		for(int i = 0; i<=m; i++)
		{
			for(int j = 0; j<=n; j++)
			{
				if(i == 0 || j == 0)
					dp[i][j] = 0;
			}
		}


		for(int i = 1; i<=m; i++)
		{
			for(int j = 1; j<=n; j++)
			{
				if(a.charAt(i-1) == b.charAt(j-1))
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}


		int lcs = dp[m][n];

		//seak(String a) -> ea(lcs)  -> pea(String b)
		System.out.println("min deletions : " + (m-lcs));
		System.out.println("min insertions : " + (n-lcs));
	}



}