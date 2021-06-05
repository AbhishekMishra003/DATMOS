class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(true){
            String s = sc.nextLine();
            System.out.println("Print 1 for exit");
            // str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            if(s.length() > 26){
                break;
            }else if(s.equals("1")){
                break;
            }
        }
        System.out.print("Length of smallest Subsequence is" + countSubsequence(s)); 
    }
    public int countSubsequence(String s){
        StringBuffer b = new StringBuffer();
        // for(int i=0;i<str.length();i++){
        //     b += s.charAt(i);
        // }
        // int maxI = Index.MIN_VALUE;
        // int minI = Index.MAX_VALUE;
        Stack<Integer> sMin = new Stack<Integer>();
        Stack<Integer> sMax = new Stack<Integer>();
        sMin.push(Index.MAX_VALUE);
        sMax.push(Index.MIN_VALUE);

        getMinCount(s,b, 0, s.length() -1, sMin);
        return sMin.pop();
    }
    public void getMinCount(String s,StringBuffer b, int l, int r, Stack<Integer> sMin){
        if(l > r){
            if(bufferContainsAllAlphabets(b)){
                sMin = Math.min(sMin, b.length())
                return;
            }
        }
    // we have two choices either take the character in the buffer or not take it. Then inside if block in the first condtion we check if this buffer has all the alphabets if thAT IS true then we push that value in stack
        b += s.charAt(l);
        getMinCount(s,b, l+1, r, sMin);
        b = b.substring(0, l);
        getMinCount(s,b, l+1, r, sMin);
    }
    //bufferContainsAllAlphabets
    public boolean bufferContainsAllAlphabets(StringBuffer b){
        int count = 0;
        StringBuffer bsamp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i=0;i<b.length();b++){
            if(bsamp.contains(b.charAt(i))){
                count++;
                bsamp.remove(b.charAt(i));
            }
        }
    }
}