import java.util.Scanner;


public class L13_UnboundedKnapsack
{
	public static void main(String[] args)
	{
		// Scanner sc = new Scanner(System.in);
		int[] wt = {1, 3, 4, 5};
		int[] val = {1, 4, 5, 7};
		int w = 7;
		int n = 4;

		int maxProfit = unboundedKnapsack(wt, val, w, n);
		System.out.println(maxProfit);
	}


	// for the maximum profit
	public  static int unboundedKnapsack(int[] wt, int[] val, int w, int n)
	{
		if(n == 0 || w == 0)
			return 0;

		// if item is selectable
		if(wt[n-1] <= w)
		{
			//if selected it means it is unprocessed
			int selected = val[n-1] + unboundedKnapsack(wt, val, w-wt[n-1], n);
			int notSelected = unboundedKnapsack(wt, val, w, n-1);
			return max(selected, notSelected);
		}

		// else if(wt[n-1] > w)
			return unboundedKnapsack(wt, val, w , n-1);
	}

	//maximum function
	public static int max(int first ,int second)
	{
		if(first > second)
			return first;
		return second;
	}
}