import java.util.Scanner;

//printing longest common subsequence
public class L23_PrintingLcs
{
	public static void main(String[] args)
	{
		String a = "abcde";
		String b = "abce";
		int m = a.length();
		int n = b.length();
		int[][] dp = new int[m+1][n+1];


		// initialisation
		for(int i = 0; i<=m ; i++)
		{
			for(int j = 0; j<=n; j++)
			{
				if( i == 0 || j == 0)	dp[i][j] = 0;
			}
		}


		//choice diagram
		for(int i = 1; i<=m ; i++)
		{
			for(int j = 1; j<=n; j++)
			{
				if(a.charAt(i-1) == b.charAt(j-1))
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = dp[i][j-1] + dp[i-1][j];
			}
		}

		String result =  printLCS(a, b, m, n, dp);
		System.out.println(result);
	}



	public static String printLCS(String x, String y, int m , int n, int[][] dp)
	{

		//will start from last cell 
		
		int i = m, j = n;
		StringBuilder sb = new StringBuilder();

		while(i>0 && j> 0)
		{
			if(x.charAt(i-1) == y.charAt(j-1))
			{
				sb.append(x.charAt(i-1));
				i--;
				j--;
			}
			else
			{
				if(dp[i][j-1] > dp[i-1][j])
					i--;
				else
					j--;
			}
		}



		//will reverse the string at end
		return sb.reverse().toString();
	}
}