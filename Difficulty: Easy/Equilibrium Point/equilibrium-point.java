//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(
                    token)); // Use Integer.parseInt to parse int values
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            Solution obj = new Solution();

            // calling equilibriumPoint() function
            System.out.println(obj.equilibriumPoint(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int equilibriumPoint(int arr[]) {
        int rightsum=0;
        for(int i=0;i<arr.length;i++){
            rightsum+=arr[i];
        }
        int leftsum=0;
        for(int i=0;i<arr.length;i++){
            rightsum-=arr[i];
            if(leftsum==rightsum){
                return i+1;
            }
            leftsum+=arr[i];
        }
        return -1;
    }
}
