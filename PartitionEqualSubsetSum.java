import java.util.Scanner;


public class PartitionEqualSubsetSum
{
	public static void main(String[] args)
	{
		Scanner  sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for(int  i = 0; i<n; i++)
		{
			arr[i] = sc.nextInt();

		}


		//partition equal sum of subset
		int totalSum = 0;
		for(int i = 0; i<n; i++)
			totalSum += arr[i];

		if(totalSum % 2 != 0)
			System.out.println("Not possible");
		else
		{
			int target = totalSum/2;
			boolean search = search(arr, arr.length-1, target);
			if(search)
				System.out.println("Possible to make equal subset sum");
			else
				System.out.println("Not pOsssible to make equal subset sum");

		}
	}



	public static boolean search(int[] arr , int index, int target)
	{
		if(target == 0)
			return true;
		if(index == 0)
			return arr[0] == target;


		// doing stuff at that index
		boolean notTaken = search(arr, index-1, target);
		boolean take = false;

		if(arr[index]<= target)
			take = search(arr,index-1, target-arr[index]);

		return notTaken || take;
	}
}