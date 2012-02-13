import java.lang.Comparable;
import java.util.LinkedList;

/**
 * Class sorter contains sorting methods for both LinkedLists and arrays
 * @author Sam Tulimat 
 **/ 

public class Sorter
{ 
/**
 * SelectionSort methods sorts comparable elements in an array 
 * @param Comparable [] 
 * @return Comparable [] array 
 **/

  public static Comparable[] selectionSort(Comparable[] array)
  {
    //instance variables 
    int minValue;
    Comparable innerValue;

    //traverses the array to set the the minValue as the outer 
    for (int outer = 0; outer < array.length; outer++)
    {
      minValue = outer;

      //traverses the array comparing the minValue to the innerValue 
      for( int inner = outer + 1; inner < array.length; inner++)
      {
        //if inner value is not the minValue 
        if (array[inner].compareTo(array[minValue]) < 0)
        {
          //sets the inner to be the MinValue
          minValue = inner;
        }    
      }
      //if the first value is not the minValue
      if (outer != minValue) 
      {
        //swaps the outer value with the minValue
        array = swap(array,outer,minValue);
      }

    }
    //returns the array 
    return array;
  } 

  public static Comparable[] mergeSort(Comparable[] array)
  {
    //Check to see if the list is 1 element or smaller. If so, consider list sorted and return
    if (array.length <= 1) 
    {
      return array;
    }
    else 
    {
       int middle = array.length / 2;
       Comparable[] left = new Comparable[middle];
       Comparable[] right = new Comparable[middle + 1];
       for(int index = 0; index < middle; index++)
       {
         left[index] = array[index];
       }
       for(int index = 0; index + middle <= array.length; index++)
       {
         right[index] = array[index + middle];
       }
       left = mergeSort(left);
       right = mergeSort(right);
       return merge(left,right);
    }
  }

  private static Comparable[] merge(Comparable[] left, Comparable[] right)
  {
    Comparable[] result = new Comparable[left.length + right.length];
    int resultIndex = 0;
    int leftIndex = 0;
    int rightIndex = 0;
    while(leftIndex < left.length && rightIndex < right.length)
    {
      if(left[leftIndex].compareTo(right[rightIndex]) <= 0)
      {
        result[resultIndex] = left[leftIndex];
        leftIndex++;
      }
      else
      {
        result[resultIndex] = right[resultIndex];
        rightIndex++;
      }
      resultIndex++;
    }
    
    Comparable remainder[];
    int remainderIndex = 0;

    if(leftIndex >= left.length)
    {
      remainder = right;
      remainderIndex = rightIndex;
    }
    else
    {
      remainder = left;
      remainderIndex = leftIndex;
    }
    //Copy the rest of the array
    for(int index = remainderIndex; index < remainder.length; index++)
    { 
      result[resultIndex] = remainder[remainderIndex];
      resultIndex++;
    }
    
    return result;
  }
 /**
  * Sorts an array by insertionSort 
  * @param Comparable[] array 
  * @return Comparable[]
  **/
  public static Comparable[] insertionSort(Comparable[] array)
  { 
    //instance variable flag 
    boolean flag = true;
    // while the flag is false 
    while(flag  == false);
    { 
      // sets the flag as false
      flag = false;
      
      //traverses the array from index 1  
      for (int i=1; i < array.length; i++) 
      { 
      //traverses the array back 
        for (int j = i-1; ( j >= 0 ); j-- ) 
        {
          
          if((array[j].compareTo(array[i] ) > 0 ))
          {
            System.out.println(array[j].toString()+" is greater than"+ array[i].toString());
            array = swap(array,j+1,j);
            flag = true;
            break;
          }
        }
        if(flag)
        {
          break;
        }
      }
    }
    return array; 
  }
  /**
   * BubbleSort method to sort the array 
   *@param Comparable [] array 
   *@return Comparable[]
   **/
  public static Comparable[] bubbleSort(Comparable[] array)
  {
    boolean swapped; 
    swapped = true;
    Comparable valueOne;
    Comparable valueTwo;
    while(swapped == false)
    {
      swapped = false;
      for(int i = 1; i < (array.length -1); i++)
      {
        valueOne= array[i-1];
        valueTwo = array[i];
        if(valueOne.compareTo(valueTwo) < 0 )
        {
          array = swap(array,i-1,i);
          swapped = true;
        }
      }
    }
    return array;
  }

  public static void selectionSort(LinkedList<Comparable> list)
  {
    
  }
  
  public static void insertionSort(LinkedList<Comparable> list)
  {

  }

  public static LinkedList<Comparable> bubbleSort(LinkedList<Comparable> list)
  {
  
    return list;
  }


  /**
   * Swap method that swaps between two indexes in the array
   * @param Comparable[] array , @param indexOne , @param indexTwo 
   **/
  private static Comparable[] swap( Comparable[] array, int indexOne, int indexTwo)
  {
    Comparable temp;
    //temprorary value holding the indexOne of the array 
    temp = array[indexOne];
    //sets the indexTwo of the array as the IndexOne
    array[indexOne] = array[indexTwo];
    //sets the temp value to be the new indexTwo
    array[indexTwo] = temp;
    //returns the array 
    return array;
  }
}
      
