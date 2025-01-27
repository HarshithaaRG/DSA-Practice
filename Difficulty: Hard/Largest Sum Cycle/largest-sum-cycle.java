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
        ArrayList<Integer> tmp=new ArrayList<>();
        long ans=-1;
        for(int y=0;y<N;y++){
            if(vis[y]==0){
                ans=Math.max(ans,dfs(vis,par,tmp,adj,y,-1));
                for(int j:tmp){
                    vis[j]=2;
                }
                tmp.clear();
            }
            
        }
        return ans;
        
    }
    public static long dfs(int[] vis, int[] par, List<Integer> tmp,List<List<Integer>> adj, int node, int parent ){
        vis[node]=1;
        par[node]=parent;
        tmp.add(node);
        long summ=-1;
        for(int r:adj.get(node)){
            if(vis[r]==0){
                summ=dfs(vis,par,tmp,adj,r,node);
                if(summ==-1){
                    return summ;
                }
            }
            else if(vis[r]==1){
                long sum=r;
                while(node!=r){
                    sum=sum+node;
                    node=par[node];
                }
                if(node==r){
                    return sum;
                }
                
            }
        }
        return summ;
        
    }
}