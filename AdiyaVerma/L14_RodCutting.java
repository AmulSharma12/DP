import java.util.Scanner;

public class L14_RodCutting
{
	public static void main(String[] args)
	{
//		int n = ;
//		int[] length = {};
//		int[] price = {};
//		int l = ;
//
//
//		int maxProfit = rodCutting(length, price, l, n);
//		System.out.println(maxProfit);
	}



	public static int rodCutting(int[] length, int[] price, int l, int n)
	{
		if(n == 0 || l == 0)
			return 0;


		if(length[n-1] <= l)
		{
			return max(price[n-1] + rodCutting(length, price, l-length[n-1], n-1), rodCutting(length, price, l, n-1));
		}

		return rodCutting(length, price, l, n-1);
	}



	public static int max(int first, int second)
	{
		return first > second ? first : second;
	}
}