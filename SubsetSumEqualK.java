import java.util.Scanner;
import java.util.Arrays;

public class SubsetSumEqualK
{
	public static void main(String[] args)
	{
	   Scanner sc = new Scanner(System.in);
	   int n = sc.nextInt();
	   int[] arr = new int[n];


	   for(int i = 0; i<n;i++)
	   {
	   	   arr[i] = sc.nextInt();
	   }


	   int k = sc.nextInt();
	   int[][] dp = new int[n][k+1];

	   // for(int[] element : dp)
	   // {
	   // 	  Arrays.fill(element, -1);
	   // }

	   //whether the subset with sum equals to k exist or not
	   boolean isExist = checkSumEqualsTarget(arr, arr.length, arr.length-1, k, dp);
	   if(isExist)
	   	System.out.println("subset with sum as k exist");
	   else
	   	System.out.println("subset with sum as k not exist in array ");
	}



	//normal recursive solution
	public static boolean checkSumEqualsTarget(int[] arr, int n, int index, int target,int[][] dp)
	{
		if(target == 0)
			return true;
		if(index == 0)
			return arr[0] == target;

		if(dp[index][target] != -1)
			return dp[index][target] == 0 ? false : true;


		//what to do in each index
		boolean notTake = checkSumEqualsTarget(arr, n, index-1,  target, dp);

		boolean take = false;
		if(arr[index] <= target)
		take = checkSumEqualsTarget(arr, n, index-1, target- arr[index], dp);
		dp[index][target] = notTake||take ? 1 : 0;
		return take||notTake;
	}


	//tabulation
	public static boolean tabulation(int[] arr, int n, int index, int tar, int[][] d)

	{
		int k = tar;
		boolean[][] dp = new boolean[n][k+1];

		//filling up with the base cases
		// for target 0 in every row mark as true
		for(int i = 0; i<n; i++)
			dp[i][0] = true;
		dp[0][arr[0]] = true;


		//now   filling the table
		for(int ind = 1; ind<n; ind++)
		{
			for(int target = 1 ; target<=k; target++)
			{
				boolean notTake = dp[ind-1][target];
				boolean take = false;
				if(arr[ind] <= target)
				  	take = dp[ind-1][target-arr[ind]];

				dp[ind][target] = take||notTake;

			}
		}


		return dp[n-1][k];
	}
}