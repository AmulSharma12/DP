import java.util.Scanner;


public class L33_McmRecursive
{
	public static void main(String[] args)
	{
		int[] arr = {40, 20, 30, 10, 30};
		int n = arr.length;

		int result = mcm(arr, 1, n-1);
		System.out.println(result);
	} 


	public static int mcm(int[] arr, int i, int j)
	{
		if(i>=j)
			return 0;
		int min = Integer.MAX_VALUE;

		for(int k = i ; k<j; k++)
		{
			int tempAns = mcm(arr, i, k) + mcm(arr, k+1, j) + arr[i-1]*arr[k]*arr[j];
			if(tempAns < min)
				min = tempAns;
		}


		return min;
	}
}