public class abstract Book{
    private String author;
    private String title;
    private String ISBN;
    public Book(){
    }
    public Book(String writer,String name,String isbn){
	author=writer;
	title=name
	ISBN=isbn
    }
    public String toString(){
	return title+", "+author+", "+ISBN
    }
    public String getAuthor(){
	return author;
    }
    public String getTitle(){
	return title;
    }
    public String getISBN(){
	return ISBN;
    }
    public boolean setAuthor(String writer){
	author=writer;
	return author==writer;
    }
    public boolean setTitle(String name){
	title=name;
	return title==name;
    }
    public boolean setISBN(String isbn){
	ISBN=isbn;
	return ISBN==isbn;
    }
    
    
    
}
