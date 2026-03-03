package Practice;

public class CountCipher {
   
    public static long countPairs(String[] words) {
        int count=0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(isSimilar(words[i],words[j])){
                    count++;
                }
            }
        }
        return count;
    }
    public static  boolean isSimilar(String s,String t){
        if(s.equals(t)) return true;
        if(s.length()!=t.length()) return false;
        char c[]=s.toCharArray();
        char ch[]=t.toCharArray();
         int n=c[0]-'a';
         int n2=ch[0]-'a';
        
         StringBuilder st=new StringBuilder();
         StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            
            char k=(char)((c[i]-'a'-n+26)%26+'a');
            char j=(char)((ch[i]-'a'-n2+26)%26+'a');
           st.append(k);
        sb.append(j);
        }
       String ss=st.toString();
       String tt=sb.toString();
        return ss.equals(tt);
    }
    public static void main(String[] args) {
        String words[]={"ab","aa","za","aa"};
       long n= countPairs(words);
       System.out.println(n);
    }
}

