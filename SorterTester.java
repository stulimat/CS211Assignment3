import java.lang.Integer;
import java.util.ListIterator;
import java.util.LinkedList;
import java.util.List;
public class SorterTester
{
  LinkedList<Integer> listInsertionSort;
  LinkedList<Integer> listBubbleSort;
  LinkedList<Integer> listSelectionSort;
  Integer[] arrayInsertionSort;
  Integer[] arrayBubbleSort;
  Integer[] arraySelectionSort;

  public SorterTester(LinkedList<Integer> unsortedList)
  {
    this.listInsertionSort = unsortedList;
    this.listBubbleSort = unsortedList;
    this.listSelectionSort = unsortedList; 
  }

  public SorterTester(Integer[] unsortedArray)
  {
    this.arrayInsertionSort = unsortedArray;
    this.arrayBubbleSort = unsortedArray;
    this.arraySelectionSort = unsortedArray;
  }

  public static void testBubbleSort(LinkedList<Comparable> unsortedList)
  {
     List<Comparable> sortedList = new LinkedList<Comparable>();
     //Run a bubble sort on the list. 
     sortedList = Sorter.bubbleSort(unsortedList);
     //Now verify that the sortedList is in sorted order somehow
     ListIterator<Comparable> litr = sortedList.listIterator();
     int flag = 0;
     
     while(litr.hasNext())
     {
       Integer i;
       Integer iPlusOne;

       i = (Integer) litr.next();
       if(litr.hasNext())
       {
         iPlusOne = (Integer) litr.next();
       }
       else
       {
         break;
       }

       if(i.compareTo(iPlusOne) < 1 )
       {
              // Do nothing
       }
       else
       {
         flag = 1;
         break; 
       }
         
         //Do some stuff to the listIterator
         litr.previous();
      
     }
     if (flag == 1) 
     {
       System.out.println("Bubble Sort Test Failed");
     }
     else 
     { 
       System.out.println("Bubble sort test passed");
     }
     
  }

  public static void  testSelectionSort()
  {
    Integer[] passArray = {1,2,3,4,5,6,7};
    Integer[] failArray = {5,9,7,2,6,8,4};
    System.out.println("Testing Failing Selection Sorted Unsorted Array");
    testSort(failArray);
    System.out.println("Testing Passing Selection Sorted Unsorted Array");
    testSort(passArray);
    System.out.println("Testing Passing Selection Sorted Array");
    testSort(Sorter.selectionSort(passArray));
    System.out.println("Testing Failing Selection Sorted Array");
    testSort(Sorter.selectionSort(failArray));
  
  }

  public static void  testInsertionSort()
  {
    Integer[] passArray = {1,2,3,4,5,6,7};
    Integer[] failArray = {5,9,7,2,6,8,4};
    System.out.println("Testing Failing Insertion  Sorted Unsorted Array");
    testSort(failArray);
    System.out.println("Testing Passing Insertion Sorted Unsorted Array");
    testSort(passArray);
    System.out.println("Testing Passing Insertion Sorted Array");
    testSort(Sorter.insertionSort(passArray));
    System.out.println("Testing Failing Insertion Sorted Array");
    testSort(Sorter.insertionSort(failArray));
  }
  public static void  testMergeSort()
  {
    Integer[] passArray = {1,2,3,4,5,6,7};
    Integer[] failArray = {5,9,7,2,6,8,4};
    System.out.println("Testing Failing Insertion  Sorted Unsorted Array");
    testSort(failArray);
    System.out.println("Testing Passing Insertion Sorted Unsorted Array");
    testSort(passArray);
    System.out.println("Testing Passing Insertion Sorted Array");
    assert Sorter.mergeSort(passArray).equals(passArray);
    testSort(Sorter.mergeSort(passArray));
    assert Sorter.mergeSort(failArray).length == failArray.length;

    System.out.println("Testing Failing Insertion Sorted Array");
    testSort(Sorter.mergeSort(failArray));
  }
  public static void testSort(Comparable[] array)
  {
    boolean flag = false; 
    for(int i = 0; i < (array.length - 1); i ++)
    {
      if(array[i].compareTo(array[i+1])>= 0)
      {
        flag = true;
        break;
      }
      System.out.println(array[i].toString() +',');
    }

    if(flag)
    {
        System.out.println("Sort Test failed");
    }
    else
    {
       System.out.println("Sort Test passed");
    }
  }


  public static void testInsertionSort(LinkedList<Integer> unsortedList)
  {
    //Implement like above. 
  }

  public static void main(String[] args)
  {
    LinkedList<Comparable> testList = new LinkedList<Comparable>();
    LinkedList<Comparable> failList = new LinkedList<Comparable>();
    Comparable[] passArray = {1,2,3,4,5,6};
    Comparable[] failArray = {2,3,4,1,5,6};

    testList.addFirst(4);
    testList.addFirst(3);
    testList.addFirst(2);
    testList.addFirst(1);
  
    failList.addFirst(2);
    failList.addFirst(5);
    failList.addFirst(1);
    failList.addFirst(7);
    System.out.println("Testing Bubble Sort----");
    System.out.println("Testing Passing List");
    testBubbleSort(testList);
    System.out.println("Testing Failing List");
    testBubbleSort(failList);
    System.out.println("Testing passing array");
    testSort(passArray);
    System.out.println("Testing failing array");
    testSort(failArray);

    testSelectionSort();
    testInsertionSort();
    testMergeSort();
  }
}
