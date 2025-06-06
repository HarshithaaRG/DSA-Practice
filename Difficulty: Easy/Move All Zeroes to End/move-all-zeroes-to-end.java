// User function Template for Java

class Solution {
    void pushZerosToEnd(int[] nums) {
        // code here
        int ind=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                int temp=nums[i];
                nums[i]=nums[ind];
                nums[ind]=temp;
                ind++;
            }
        }
        return;
    }
}