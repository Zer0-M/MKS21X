import java.util.*;
public class Barcode implements Comparable<Barcode>{
  private String zip;
  private int checkSum;
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
    generateCheckSum();

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
    if(z.length()!=5){
      throw new IllegalArgumentException();
    }
    String barcode="|";
    String zipWithCheck=z+checkSum;
    for(int i=0;i<zipWithCheck.length();i++){
      int digit=Integer.parseInt(zipWithCheck.substring(i,i+1));
      barcode+=codes[digit];
    }
    return barcode+"|";
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
  private void generateCheckSum(){
    int sum=0;
    for(int i=0;i<getZip().length();i++){
      int digit=Integer.parseInt(getZip().substring(i,i+1));
      sum+=digit;
    }
    checkSum=sum%10;
  }
  public static void main(String[] args){
    Barcode B=new Barcode("13136");
  }


}
