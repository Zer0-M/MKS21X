public class OrderedSuperArray extends SuperArray{
    public OrderedSuperArray(){
	//Complete this.
      super();
    }

    public OrderedSuperArray(int capacity){
      super(capacity);
    }
    public OrderedSuperArray(String [] ary){
      super();
      for(int i=0;i<ary.length;i++){
        add(ary[i]);
      }
    }
    /*call the proper add.*/
    public void add(int index, String value){
      add(value);
    }
    public String set(int index,String value){
      throw new UnsupportedOperationException();
    }

    /*Write this method and any
    appropriate helper methods.*/
    private int findIndex(String str){
      for(int i=size()-1;i>=0;i--){
        if(str.compareTo(get(i))>0){
          return i+1;
        }
      }
      return 0;
    }
    public int findIndexBinary(String element){
    int start=0;
    int end=size()-1;
    int middle=(end-start)/2;
    while(middle!=start&&middle!=end){
      if(element.compareTo(get(middle))<0){
          end=middle;
          middle=(end-start)/2+start;
        }
      if (element.compareTo(get(middle))>0){
          start=middle;
          middle=(end-start)/2+start;

        }
      if(element.equals(get(middle))){
        return middle+1;
      }
    }
    for(int i=end;i>=start;i--){
        if(element.compareTo(get(i))>0){
          return i+1;
        }
      }
      return start;
  }
  public int lastIndexOf(String element){
     if (size()<3){
       return super.lastIndexOf(element);
       }
    int start=0;
    int end=size()-1;
    int middle=(end-start)/2;
    if(contains (element)){
    while(middle-1!=start||middle+1!=end&&end!=start&&start+1==end){
      if(get(middle).compareTo(element)>0){
          end=middle;
          middle=(end-start)/2+start;
        }
        else {
          start=middle;
          middle=(end-start)/2+start;
        }
    }
    if(element.compareTo(get(end))==0){
          return end;
       }

    if(element.compareTo(get(start))==0){
      for(int i=start;i<=end;i++){
        if(get(i).equals(element)){
         start=i;
        }
      }
      return start;

    }
    return middle;
    }
    else{
       return -1;
    }
 }
    public int indexOf(String element){
     if (size()<3){
       return super.indexOf(element);
       }
    int start=0;
    int end=size()-1;
    int middle=(end-start)/2;
    if(contains(element)){
    while(middle-1!=start||middle+1!=end&&end!=start&&start+1==end){
      if(get(middle).compareTo(element)>0){
          end=middle;
          middle=(end-start)/2+start;
        }
        else {
          start=middle;
          middle=(end-start)/2+start;
        }
    }
    if(element.equals(get(end))){
      for(int i=end;i>=start;i--){
        if(get(i).equals(element)){
         end=i;
        }
      }
      return end;
       }

    if(element.equals(get(start))){
      return start;
    }
    return middle;
    }
    else{
        return -1;    }
 }



    public boolean add(String value){
      //add to the correct spot.
      //you may still use super.add(index,value)
      int index=findIndexBinary(value);
      super.add(index,value);
      return true;
    }
}
