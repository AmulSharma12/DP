import java.util.Scanner;


public class L34_McmMemoize
{
	public static void main(String[] args)
	{
		int[] arr = {40, 20, 30, 10, 30};
		int n = arr.length;
		int[][] dp = new int[n+1][n+1];

		for(int i = 0; i<n; i++)
			for(int j = 0; j<n; j++)
				dp[i][j] = -1;

		int result = mcm(arr, 1, n-1, dp);
		System.out.println(result);
	}


	public static int mcm(int[] arr, int i, int j, int[][] dp)
	{
		if(i >= j)
			return 0;


		if(dp[i][j] != -1)
			return dp[i][j];


		int min = Integer.MAX_VALUE;
		for(int k = i; k<j; k++)
		{
			int tempAns = mcm(arr,i ,k, dp) + mcm(arr, k+1, j, dp) + arr[i-1]*arr[k]*arr[j];

			if(tempAns < min)
				min = tempAns;
		}

		return dp[i][j] = min;
	}
}