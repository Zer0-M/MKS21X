import java.util.*;
public class Sorts{
  /**EDIT THIS METHOD TO MATCH YOUR NAME
   */
  public static String name(){
    return "10.Jamil.Mohammed";
  }
  /**isSorted method created by Mr. K
     improved based on Mr.K's advice on using built-in method
   */
  public static boolean isSorted(int[]ary){
      //for(int i = 0; i < ary.length - 1 ; i++){
      //if(ary[i] > ary[i+1]){
      //  return false;
      // }
      //}
      //return true;
      int[] arr=ary;
      Arrays.sort(arr);
      return Arrays.equals(ary,arr);
      
  }

  /**Selection sort of an int array.
   *Upon completion, the elements of the array will be in increasing order.
   *@param data  the elements to be sorted.
   */
  public static void selectionSort(int[] data){
    int indexOfSmallest=0;
    for(int ind=0;!isSorted(data);ind++){
      int smallest=data[ind];
      for(int i=ind;i<data.length;i++){
        if(data[i]<smallest){
          smallest=data[i];
          indexOfSmallest=i;
        }
      }
      int temp=data[ind];
      data[ind]=smallest;
      data[indexOfSmallest]=temp;
    }
  }
  public static void insertionSort(int[] data){
    while(!isSorted(data)){
      for(int i=0;i<data.length;i++){
        int temp=data[i];
        if(i!=0&&data[i-1]>data[i]){
          data[i]=data[i-1];
          data[i-1]=temp;
        }
      }
    }  
  }

}
