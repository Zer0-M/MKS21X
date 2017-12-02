public class Barcode implements Comparable<Barcode>{
  private String zip;
  public Barcode(String z){
    zip=z;
  }
  public String toString(){
    return getCode() +"("+ getZip()+")";
  }
  public String  getCode(){
    String[] codes={
      "||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"
    };
      String barcode="";
      for(int i=0;i<getZip().length();i++){
        int digit=Integer.parseInt(getZip().substring(i,i+1));
        barcode+=codes[digit];
      }
      return barcode;
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

}
