//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Arrays;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution obj = new Solution();
            obj.convertToWave(arr);
            StringBuffer sb = new StringBuffer("");
            for (int i : arr) {
                sb.append(i + " ");
            }
            System.out.println(sb.toString());
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public static void convertToWave(int[] arr) {
        // code here
        if(arr.length%2==0){
            for(int i=1;i<arr.length;i+=2){
                int temp=arr[i-1];
                arr[i-1]=arr[i];
                arr[i]=temp;
            }
        }
        else{
            for(int j=1;j<arr.length-1;j+=2){
                int temp=arr[j-1];
                arr[j-1]=arr[j];
                arr[j]=temp;
            }
        }
        return;
    }
}