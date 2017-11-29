public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
  String private callNumber;
  public LibraryBook(String au,String name,String isbn, String call){
    super(au,name,isbn);
    callNumber=call;
  }
  public String getCallNumber(){
    return callNumber;
  }
  public boolean setCallNumber(String call){
    callNumber=call;
    return callNumber==call;
  }
}
