//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;


class GFG{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }

        Long nextLong(){
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws IOException
    {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-- > 0){
            int N = sc.nextInt();
            int Edge[] = new int[N];
            for(int i = 0; i < N; i++)
                Edge[i] = sc.nextInt();
            Solution ob = new Solution();
            long ans = ob.largesSumCycle(N, Edge);
            out.println(ans);            
        
out.println("~");
}
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public long largesSumCycle(int N, int Edge[]){
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<N;i++){
            adj.add(new ArrayList<>());
            if(Edge[i]!=-1){
                adj.get(i).add(Edge[i]);
            }
        }
        int[] vis=new int[N];
        int[] par=new int[N];
        long ans=-1;
        List<Integer> seen=new ArrayList<>();
        for(int y=0;y<N;y++){
            if(vis[y]==0){
                ans=Math.max(ans,dfs(vis,par,y,-1,adj, seen));
                for(int u:seen){
                    vis[u]=2;
                }
                seen.clear();
                
            }
        }
        return ans;
        
    }
    public static long dfs(int[] vis,int[] par, int node, int parent, List<List<Integer>> adj, List<Integer> seen){
        vis[node]=1;
        par[node]=parent;
        seen.add(node);
        long sum=-1;
        for(int u:adj.get(node)){
            if(vis[u]==0){
                sum=dfs(vis,par,u,node,adj,seen);
                if(sum==-1){
                    return sum;
                }
                
            }
            else if(vis[u]==1){
                sum=u;
                while(node!=u){
                    sum+=node;
                    node=par[node];
                }
                return sum;
            }
        }
        return sum;
        
    }
}