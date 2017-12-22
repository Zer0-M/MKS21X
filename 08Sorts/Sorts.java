import java.util.*;
public class Sorts{
  /**EDIT THIS METHOD TO MATCH YOUR NAME
   */
  public static String name(){
    return "10.Jamil.Mohammed";
  }
  /**isSorted method created by Mr. K
   */
  public static boolean isSorted(int[]ary){
    for(int i = 0; i < ary.length - 1 ; i++){
      if(ary[i] > ary[i+1]){
        return false;
      }
    }
    return true;
      
  }
  /**swap method made by Mr. K
   */
  private static void swap(int[]ary,int a, int b){
        int c =ary[a];
        ary[a] = ary[b];
        ary[b] = c;
  }

  /**Selection sort of an int array.
   *Upon completion, the elements of the array will be in increasing order.
   *@param data  the elements to be sorted.
   */
  public static void selectionSort(int[] data){
    int indexOfSmallest=0;
    for(int ind=0;(!isSorted(data))&&ind<data.length-1;ind++){
      for(int i=ind;i<data.length;i++){
        if(data[i]<data[indexOfSmallest]){
          indexOfSmallest=i;
        }
      }
      swap(data,ind,indexOfSmallest);
    }
  }
  public static void insertionSort(int[] data){
      for(int i=1;i<data.length;i++){
        int startVal=data[i];
        int tempint=i-1;
        while(tempint>=0&&data[tempint]>startVal){
          data[tempint+1]=data[tempint];
          tempint--;  
        }
        data[tempint+1]=startVal;
        
      }
  }
  public static void bubbleSort(int[] data){
    for(int ind=0;ind<data.length;ind++){
      for(int i=1;i<data.length-ind;i++){
        if(data[i-1]>data[i]){
          swap(data,i-1,i);
        }
      }
    }
  }

}
