class Solution {
    int maxSubarraySum(int[] arr) {
        int sum=0;
        int maxsum=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            maxsum=Math.max(sum,maxsum);
            if(sum<0){
                sum=0;
            }
        }
        return maxsum;
    }
}
