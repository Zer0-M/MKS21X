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
}
