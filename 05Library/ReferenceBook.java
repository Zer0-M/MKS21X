public class ReferenceBook extends LibraryBook{
  private String collection;
  public ReferenceBook(String au,String name,String isbn, String call,String collect){
    super(au,name,isbn,call);
    collection=collect;
  }
  public String getCollection(){
    return collection;
  }
  public boolean setCollection(String coll){
    collection=coll;
    return collection==coll;
  }
  public void checkout(String patron,String due){
    System.out.println("cannot check out a reference book");
  }
  public void returned(){
    System.out.println("reference book could not have been checked out -- return impossible");
  }
  public String circulationStatus(){
    return "non-circulating refernce book";
  }
  public String toString(){
    return super.toString()+", "+getCollection();
  }
  public static void main(String[] args){
    ReferenceBook D= new ReferenceBook("An unicycle","Every Aglet Ever Made","1314141352","12313","Shoelaces");
    System.out.println(D.getCollection());
  }
}
