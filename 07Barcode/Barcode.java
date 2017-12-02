public class Barcode {
  private String zip;
  public Barcode(String z){
    zip=z;
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
  public static void main(String[] args){
    Barcode B=new Barcode("11103");
    System.out.println(B.getZip());
  }
}
