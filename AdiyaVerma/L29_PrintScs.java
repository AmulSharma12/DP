import java.util.Scanner;


public class L29_PrintScs
{
	public static void main(String[] args)
	{
		String a = "abcdaf";
		String b = "acbcf";
		int m = a.length();
		int n = b.length();
		int[][] dp = new int[m+1][n+1];

		//intialisation
		for(int i = 0; i<=m; i++)
		{
			for(int j = 0; j<=n; j++)
			{
				if(i == 0 || j == 0)
					dp[i][j] = 0;

			}
		}



		//choice diagram
		for(int i = 1; i<=m; i++)
		{
			for(int j = 1; j<=n; j++)
			{
				if(a.charAt(i-1) == b.charAt(j-1))
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i][j-1] , dp[i-1][j]); 
			}
		}


		String result = scs(a, b, m, n, dp);
		System.out.println(result);
	}


	public static String scs(String x, String y, int m , int n, int[][] dp)
	{
		int i = m;
		int j = n;
		String s = "";


		while(i>0  && j>0)
		{
			if(x.charAt(i-1) == y.charAt(j-1))
			{
				s += x.charAt(i-1);
				i--;
				j--;
			}
			else if(dp[i][j-1] > dp[i-1][j])
			{
				s += y.charAt(j-1);
				j--;
			}
			else{
				s += x.charAt(i-1);
				i--;
			}

		}



		//printing rest of the string if other becomes empty
		while(i>0)    //j becomes 0 that is b string empty
		{
			s += x.charAt(i-1);
			i--;
		}

		//printing rest of the string if other becomes empty
		while(j>0)    //i becomes 0 that is a string empty
		{
			s += y.charAt(j-1);
			j--;
		}



		//return the reverse as we have start from last cell that is from ending
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		return sb.toString();
	}
}