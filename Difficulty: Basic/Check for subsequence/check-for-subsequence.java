// User function Template for Java

class Solution {
    boolean isSubSequence(String A, String B) {
        int pos=0;
        int pot=0;
        while(pos<A.length() && pot<B.length()){
            if(A.charAt(pos)==B.charAt(pot)){
                pos++;
            }
            pot++;
        }
        return pos==A.length();
    }
}