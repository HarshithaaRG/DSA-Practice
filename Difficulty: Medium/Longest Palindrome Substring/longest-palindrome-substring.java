//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Static method to find the longest palindromic substring
    static String longestPalindrome(String s) {
        String ans="";
        int maxlen=0;
        int n=s.length();
        int dp[][]=new int[n][n];
        for(int diff=0;diff<s.length();diff++){
            for(int i=0,j=i+diff;j<s.length();i++,j++){
                if(diff==0){
                    dp[i][j]=1;
                }
                else if(diff==1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=2;
                    }
                }
                else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]>0){
                        dp[i][j]=dp[i+1][j-1]+2;
                    }
                    
                }
                if(dp[i][j]>0){
                    int len=j-i+1;
                    if(len>maxlen){
                        maxlen=len;
                        ans=s.substring(i,j+1);
                    }
                    
                }
                    
            }
        }
        return ans;
    }
}