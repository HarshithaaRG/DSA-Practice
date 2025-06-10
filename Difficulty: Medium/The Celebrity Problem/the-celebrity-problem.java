class Solution {
    public int celebrity(int mat[][]) {
        // code here
        int i=0;
        int j=mat.length-1;
        while(i<j){
            if(mat[i][j]==1){
                i++;
            }else{
                j--;
            }
        }
        int c=i;
        for(int y=0;y<mat.length;y++){
            if(y==c){
                continue;
            }
            else{
                if(mat[y][c]==0 || mat[c][y]!=0){
                    return -1;
                }
            }
        }
        return c;
    }
}