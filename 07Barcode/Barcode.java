import java.util.*;
public class Barcode implements Comparable<Barcode>{
  private String zip;
  private static int check;
  public Barcode(String z){
    try{
      Integer.parseInt(z);
    }catch(NumberFormatException e){
      throw new IllegalArgumentException();
    }
    if(z.length()==5){
      zip=z;
    }
    else{
      throw new IllegalArgumentException();
    }
  }
  public String toString(){
    return getCode() +"("+ getZip()+")";
  }
  public static String toCode(String z){
    String[] codes={
      "||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"
    };
     try{
      Integer.parseInt(z);
    }catch(NumberFormatException e){
      throw new IllegalArgumentException();
    }
    int check=generateCheckSum(z);
    z+=check;
    try{
      Integer.parseInt(z);
    }catch(NumberFormatException e){
      throw new IllegalArgumentException();
    }
    if(z.length()!=6){
      throw new IllegalArgumentException();
    }
    String barcode="|";
    String zipWithCheck=z+check;
    for(int i=0;i<zipWithCheck.length();i++){
      int digit=Integer.parseInt(zipWithCheck.substring(i,i+1));
      barcode+=codes[digit];
    }
    return barcode+"|";
  }
  public static String toZip(String code){
    String[] codes={
      "||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"
    };
    int  checkSum=0;
    String zipCode="";
    String codeWithoutCheck=code.substring(0,31)+"|";
    if(!code.substring(0,1).equals("|")||!code.substring(code.length()-1,code.length()).equals("|")||codeWithoutCheck.length()!=32){
      throw new IllegalArgumentException();
    }
    for(int i=1;i<code.length()-6;i+=5){
      boolean found=false;
      String codeDigit=code.substring(i,i+5);
      for(int ind=0;ind<codes.length;ind++){

        if(codeDigit.equals(codes[ind])){
          if(i==code.length()-11){
            checkSum+=ind;
          }
          else{
          zipCode+=ind;
          }
          found=true;
        }
        else if(ind==codes.length-1&&!found){
          throw new IllegalArgumentException();
        }
      }

    }
    if(generateCheckSum(zipCode)!=checkSum){
      throw new IllegalArgumentException();
    }
    return zipCode;
  }
  public String  getCode(){
    return toCode(zip);
  }
  public String getZip(){
    return zip;
  }
  public int compareTo(Barcode other){
    return getZip().compareTo(other.getZip());
  }
  public boolean equals(Barcode other){
    if(compareTo(other)==0){
      return true;
    }
    return false;
  }
  private static int generateCheckSum(String z){
    int sum=0;
    for(int i=0;i<z.length();i++){
      int digit=Integer.parseInt(z.substring(i,i+1));
      sum+=digit;
    }
    return sum%10;
  }
}
