class Solution {
    static class ItemComparator implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            double a1=1.0*a[0]/a[1];
            double b1=1.0*b[0]/b[1];
            return Double.compare(b1,a1);
        }
    }
    double fractionalKnapsack(int[] values, int[] weights, int W) {
        // code here
        int n=values.length;
        int[][] items=new int[n][2];
        for(int i=0;i<n;i++){
            items[i][0]=values[i];
            items[i][1]=weights[i];
        }
        Arrays.sort(items,new ItemComparator());
        double res=0.0;
        int curcap=W;
        for(int j=0;j<n;j++){
            if(items[j][1]<=curcap){
                res+=items[j][0];
                curcap-=items[j][1];
            }
            else{
                res+=(1.0*items[j][0]/items[j][1])*curcap;
                break;
            }
        }
        return res;
    }
}