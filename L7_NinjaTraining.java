//Ninja Training 2d concepts questions

import java.util.Scanner;

public class L7_NinjaTraining
{
	public static void main(String[] args)
	{
		int[] arr = {};
		int n = arr.length;

		int result = ninjaTraining(arr,n);
	}


	public static int ninjaTraining(int n, int arr[][]) {

		int[][] dp = new int[n][4];

		dp[0][0] = max(arr[0][1], arr[0][2]);
		dp[0][1] = max(arr[0][0], arr[0][2]);
		dp[0][2] = max(arr[0][0], arr[0][1]);
		dp[0][3] = max(arr[0][0], arr[0][1], arr[0][2]);

		for(int day = 1; day < n; day++)
		{
			for(int last = 0; last <4; last++)
			{
				dp[day][last] = Integer.MIN_VALUE;

				for(int task = 0; task < 3; task++)
				{
					if(task != last)
					{
						int point = arr[day][task] + dp[day-1][task];
						dp[day][last] = max(dp[day][last], point);
					}
				}
			}
		}

		return dp[n-1][3];
	}


	public static int max(int first, int second)
	{
		return first  > second ? first : second;
	}

	public static int max(int first, int second, int third)
	{
		int a = max(first, second);
		return max(a, third);
	}

}