import java.util.*;
public class superArrayIterator implements Iterator<String>{
  private int current,size;
  private SuperArray data;
  public superArrayIterator(SuperArray dat){
    current=0;
    data=dat;
    size=data.size();
  }
  public String next(){
    if(hasNext()){
      current+=1;
    }
    else{System.exit(0);}
    return data.get(current-1);
  }
  public boolean hasNext(){
    return current<=size-1;
  }

}
