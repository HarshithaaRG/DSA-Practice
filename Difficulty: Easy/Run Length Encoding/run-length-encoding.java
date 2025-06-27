class Solution {
    public static String encode(String s) {
        int count=1;
        StringBuilder st=new StringBuilder();
        st.append(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)!=s.charAt(i-1)){
                st.append(count);
                st.append(s.charAt(i));
                count=0;
            }
            count++;
        }
        st.append(count);
        return st.toString();
        
        
    }
}