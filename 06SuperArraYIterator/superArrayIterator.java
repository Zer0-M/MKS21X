import java.util.*;
public class superArrayIterator implements Iterator<String>{
  private int current,size;
  private SuperArray data;
  public superArrayIterator(SuperArray dat){
    current=0;
    data=dat;
    size=data.size();
  }

}
