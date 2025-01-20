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
        for(int y=0;y<exits.length;y++){
            if(exits[y]!=-1){
                arr[exits[y]]+=y;
            }
        }
        int maxi=Integer.MIN_VALUE;
        int ans=0;
        for(int t=0;t<exits.length;t++){
            if(arr[t]>maxi || (arr[t]==maxi && t>ans)){
                maxi=arr[t];
                ans=t;
            }
            
        }
        return ans;
    }
}