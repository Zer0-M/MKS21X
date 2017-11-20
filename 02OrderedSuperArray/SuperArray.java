public class SuperArray{
  private String[] data;
  private int size;
  public SuperArray(){
      size=0;
      data=new String[10];
   }
  public SuperArray(int capacity){
    size=0;
    data=new String[capacity];
  }
  /**
     Returns the data in the format: "[A, B, FISH, cat, Dog]" Without double quotes around the data elements.
   */

  public String toString(){
    int nonNulls=0;
    String printable="[";
    for(int i=0;i<size;i+=1){

	    if(data[i]!=null){
        if(nonNulls>=1){
          printable+=",";
        }
        nonNulls+=1;
        printable+=data[i];

	    }


    }
    printable+="]";
    return printable;

   

   }
  /**
    Returns the number of elements in this list.
   */
  public int size(){
    return size;
  }
  /**
     Appends the specified element to the end of this list. Returns true.

   */
  public boolean add(String element){
        if(size()==data.length){
          resize();
        }
        
      
        data[size()]=element;
        size+=1;
      
   
    return true;
  }
  /**
    Removes all of the elements from this list.

   */
  public void clear(){
    data=new String[data.length];
    size=0;
  }
  /**
     Returns the element at the specified position in this list.
  */
  public String get(int index){
    if(index>=0&&index<size()){
      return data[index];
    }
    else{
      throw new IndexOutOfBoundsException();
    }
  }

  /**
     Replaces the element at the specified position in this list with the specified element, returns the old element.
   */
  public String set(int index, String element){
    String old="";

    if(index<size()&&index>=0){
       old+=data[index];

       data[index]=element;
    }
    else{
      throw new IndexOutOfBoundsException();
    }
    return old;
  }
  /**
     Returns true if this list contains no elements.
   */
  public boolean isEmpty(){
    return size()==0;
  }

  private void resize(){
    String[] newdata=new String[data.length*2+1];
    for(int i=0;i<data.length;i+=1){
      newdata[i]=data[i];
      if(data[i]!=null){ 
      }
    }
    data=newdata;
  }
    
  /**
     Returns true if this list contains the specified element.
   */
  public boolean contains(String element){
    for(int i=0;i<data.length&&data[i]!=null;i+=1){
      if(data[i].equals(element)){
        return data[i].equals(element);
      }

    }
    return false;
  }

  /**
     Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
   */

  public int indexOf(String element){
   for(int i=0;i<data.length&&data[i]!=null;i+=1){
     if(data[i].equals(element)){
        return i;
      }

    }
    return -1;

  }
  public int indexOfBinary(String element){
    int start=0;
    int end=size()-1;
    int middle=(end-start)/2;
    if(contains(element)){
      while(end!=start){
        if(data[middle].compareTo(element)>0){
          end=middle;
          middle=(end-start)/2+start;
        }
        else if(data[middle+1].compareTo(element)==0){
	          end=middle+1;
	          start=middle+1;
        }
        else if(data[middle].compareTo(element)==0){
          end=middle;
          start=middle;
        }
        
	        
        else{
          start=middle;
          middle=(end-start)/2+start;
        }
      }
    }
    else{
      return -1;
    }
    return start;
  }
  /**
     Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
   */
  public int lastIndexOf(String element){
    int lastI=-1;
    for(int i=0;i<data.length&&data[i]!=null;i+=1){
      if(data[i].equals(element)){
       lastI=i;
      }

    }
    return lastI;
  }
  /**
     All elements at the index or to the right, are shifted to the right to make space, then insert the specified element at the specified position in this list.
   */
  public void add(int index,String element){
      if (size()==data.length){
        resize();

      }
      for(int i=size()-1;i>=index;i--){
          data[i+1]=data[i];
      }
      data[index]=element;
      size+=1;
      /*int relativeIndex=0;
      String nextEl=data[index+relativeIndex];
      String nextNextEl="";
      data[index]=element;

      while(nextEl!=null){
        relativeIndex+=1;
        nextNextEl=data[index+relativeIndex];
        data[index+relativeIndex]=nextEl;
        System.out.println(relativeIndex);
        nextEl=nextNextEl;
      */

      
    }



  /**
     Removes the element at the specified position in this list and shifts all subsequent elements to the left. Return the element removed.
   */
  public String remove(int index){
    String removed=data[index];
    if(index>=0&&index<size()){
      for(int i=0;i<size();i++){
        if(i>=index){
          data[i]=data[i+1];
        }
      }
      return removed;
    }
    else{
      throw new IndexOutOfBoundsException();
    }
  }

  /**
     Removes the first occurrence of the specified element from this list if it is present. Shift all the subsequent elements to the left.
   */
  public boolean remove(String element){
    boolean removed=false;
    if(contains(element)){
      remove(indexOf(element));
      removed=true;
    }
    return removed;
  }

}
