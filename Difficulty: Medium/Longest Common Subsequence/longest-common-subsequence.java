class Solution {
    static int lcs(String s1, String s2) {
        // code here
        int l1=s1.length();
        int l2=s2.length();
        int prev[]=new int[l2+1];
        int curr[]=new int[l2+1];
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    curr[j]=1+prev[j-1];
                }
                else{
                    curr[j]=Math.max(prev[j],curr[j-1]);
                }
            }
            prev=(int[])(curr.clone());
        }
        return prev[l2];
        
    }
}