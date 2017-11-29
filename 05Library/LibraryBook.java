public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
  private String callNumber;
  public LibraryBook(String au,String name,String isbn, String call){
    super(au,name,isbn);
    callNumber=call;
  }
  public String toString(){
    return super.toString()+", "+getCallNumber()+", "+circulationStatus();
  }
  public String getCallNumber(){
    return callNumber;
  }
  public boolean setCallNumber(String call){
    callNumber=call;
    return callNumber==call;
  }
  public abstract void checkout(String patron,String due);
  public abstract void returned();
  public abstract String circulationStatus();
  public int compareTo(LibraryBook other){
    return getCallNumber().compareTo(other.getCallNumber());
  }

}
