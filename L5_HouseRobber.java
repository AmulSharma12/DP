//maximum sum of non adjacent elements in all the subsequences
// https://leetcode.com/problems/house-robber/

public class L5_HouseRobber
{
	public static void main(String[] args)
	{
		int[] nums = {1,2,3,1};
		System.out.println(rob(nums));

	}



	//1.-------------------------using recursion gives tle
	 // public static  int rob(int[] nums) {
  //       int n = nums.length;
  //      return findMax(n-1,nums); 
  //   }
    
    
    
  //   public static  int findMax(int index, int[] nums)
  //   {
  //       if(index == 0)    return nums[index];
  //       if(index < 0)      return 0;
        
  //       int pick = nums[index] + findMax(index-2, nums);
  //       int notPick = 0 + findMax(index-1 , nums);
        
        
  //       return maximum(pick,notPick);
  //   }


//--------------------------------------------------------------------------------------------
	// 2.-----------------------------------using memoization
	 // public static int rob(int[] nums) {
  //       int n = nums.length;
  //       int[] dp = new int[n];
        
  //       for(int i = 0; i<n; i++)
  //           dp[i] = -1;
  //      return findMax(n-1,nums,dp); 
  //   }
    
    
    
  //   public static int findMax(int index, int[] nums, int[] dp)
  //   {
  //       if(index == 0)    return nums[index];
  //       if(index < 0)      return 0;
        
        
  //       if(dp[index] != -1)     return dp[index];
        
  //       int pick = nums[index] + findMax(index-2, nums, dp);
  //       int notPick = 0 + findMax(index-1 , nums, dp);
        
        
  //       return dp[index] = maximum(pick,notPick);
  //   }
    
  //----------------------------------------------------------------------------
// 3. Tabulation

	// public static int rob(int[] nums) {
 //        int n = nums.length;
 //        int[] dp = new int[n];
        
 //        dp[0] = nums[0];
 //        int neg = 0;
        
 //        for(int i = 1; i<n; i++)
 //        {
 //            //pick case
 //            int pick = nums[i];
 //            if(i > 1)
 //                pick += dp[i-2];
            
            
 //            //not pick
 //            int notpick = 0 + dp[i-1];
            
 //            dp[i] = maximum(pick, notpick);
 //        }
        
 //        return dp[n-1];
 //    } 

	//------------------------------------------------------------------------Space Optimisation
	public static int rob(int[] nums) {
        int n = nums.length;
        int prev2 = 0;  //negative case
        int prev = nums[0];
        
        for(int i = 1; i<n; i++)
        {
            //pick call
            int pick = nums[i];
            if(i > 1)       pick += prev2;
            
            //not pick call
            int notpick = 0 + prev;
            
            int curri  = maximum(pick , notpick);
            
            prev2 = prev;
            prev = curri;
        }
        
        return prev;
    }
    
    public static int maximum(int a, int b)
    {
        return a>b ? a: b;
    }





}