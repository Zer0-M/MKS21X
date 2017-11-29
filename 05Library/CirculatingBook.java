public class CirculatingBook extends LibraryBook{
  private String currentHolder;
  private String dueDate;
  public CirculatingBook(String au,String name,String isbn, String call){
    super(au,name,isbn, call)
  }
  public String getCurrentHolder(){
    return currentHolder;
  }
  public String getDueDate(){
    return dueDate;
  }
  public boolean setCurrentHolder(String patron){
    currentHolder=patron;
    return currentHolder==patron;
  }
  public boolean setDueDate(String due){
    dueDate=due;
    return dueDate==due;
  }
  public void checkout(String patron,String due){
    currentHolder=patron;
    dueDate=due;
  }
  public void returned(){
    currentHolder=new String();
    dueDate=new String();
  }
  public String circulationStatus(){
    if(currentHolder!=null){
      return currentHolder+" "+dueDate;
    }
    return "book available on shelves";
  }
}
