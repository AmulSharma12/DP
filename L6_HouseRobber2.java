// 

class L6_HouseRobber2 {

	public static void main(String[] args)
	{
		int[] nums = {2, 3, 2};
		System.out.println(rob(nums));
	}

    public static  int rob(int[] nums) {
        int n = nums.length;
        int[] ans1 = new int[n];
        int[] ans2 = new int[n];
        
        if(n == 1)      return nums[0];
        //ignoring first element
        int index = 0;
        for(int i = 0; i<n; i++)
        {
            if(i != 0)
                ans1[index++] = nums[i];
                
        }
        
        
        //ignoring last element
        index = 0;
        for(int i = 0; i<n; i++)
        {
            if(i != n-1)
                ans2[index++] = nums[i];
                
        }
        
        
        // then you have to call the maximum of both array
        return maximum(findMax(n-2, ans1) , findMax(n-2, ans2));
    }
    
    
    
    // ---------------------------------------------------
    //findMax function  to calculate the maximum for array
    public static int findMax(int index , int[] nums)
    {
        if(index == 0)      return nums[0];
        if(index < 0)       return 0;
        
        
        //pick call 
        int pick = nums[index] + findMax(index-2, nums);
        
        //notpick call
        int notpick = 0 + findMax(index-1, nums);
        
        
        return maximum(pick, notpick);
    }
    
    
    // ------------------------------------------------------
    //maximum function
    public static int maximum(int first, int second)
    {
        return first > second ? first : second;
    }
}