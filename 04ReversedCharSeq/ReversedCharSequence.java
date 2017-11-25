public class ReversedCharSequence implements CharSequence{
  private String seq;
  public ReversedCharSequence(String str){
    seq=new String();
    for(int i=str.length();i>0;i--){
	    seq+=str.substring(i-1,i);
    }
	    
  }
  public String toString(){
    return seq;
  }
  public char charAt(int index){
     return seq.charAt(index);
    
  }
  public int length(){
    return seq.length();
  }
  public ReversedCharSequence subSequence(int start,int end){
    ReversedCharSequence sub=new ReversedCharSequence(toString().substring(start,end));
    sub=new ReversedCharSequence(sub.toString());
    return sub;
  } 
  public static void main(String[] args){
    ReversedCharSequence words =new ReversedCharSequence("STOOL POOL");
    System.out.println(words);// expecting LOOP LOOTS
    System.out.println(words.charAt(0));//edge case expecting L
    System.out.println(words.charAt(5));//expecting L
    System.out.println(words.charAt(words.length()-1));//edge case expecting S
    //System.out.println(words.charAt(-6));//expecting exception
    System.out.println(words.length());//expecting 10
    System.out.println(words.subSequence(0,2));//expecting LO
    System.out.println(words.subSequence(3,7));//expecting P LO
    //System.out.println(words.subSequence(-1,2));//expecting exception
    System.out.println(words.subSequence(4,words.length()));//expecting  LOOTS
    System.out.println(words);//expecting LOOP LOOTS
  }
}
