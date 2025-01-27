//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String temp[] = sc.nextLine().trim().split(" ");
            int n = temp.length;
            int exits[] = new int[n];
            for (int i = 0; i < n; i++) exits[i] = Integer.parseInt(temp[i]);
            Solution sln = new Solution();
            System.out.println(sln.maxWeightCell(exits));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxWeightCell(int[] exits) {
        int[] arr=new int[exits.length];
        for(int i=0;i<arr.length;i++){
            if(exits[i]!=-1){
                arr[exits[i]]+=i;
            }
        }
        int maxi=Integer.MIN_VALUE;
        int ans=-1;
        for(int y=0;y<arr.length;y++){
            if(arr[y]>maxi || (arr[y]==maxi && y>ans)){
                maxi=arr[y];
                ans=y;
            }
        }
        return ans;
    }
}