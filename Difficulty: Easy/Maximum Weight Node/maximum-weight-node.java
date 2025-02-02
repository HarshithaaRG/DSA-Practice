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
        int n=exits.length;
        int[] temp=new int[n];
        for(int y=0;y<n;y++){
            if(exits[y]!=-1){
                temp[exits[y]]+=y;
            }
        }
        int maxi=Integer.MIN_VALUE;
        int node=-1;
        for(int t=0;t<n;t++){
            if(temp[t]>=maxi){
                maxi=temp[t];
                node=t;
            }
        }
        return node;
    }
}