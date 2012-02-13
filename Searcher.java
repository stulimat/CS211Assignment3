import java.lang.Comparable;

public class Searcher
{
  public static int binarySearch(Comparable element,  Comparable[] array)
  {
    int min = 0;
    int max = array.length;
    while( min < max)
    {
      int mid = (min + max) / 2;
      switch(element.compareTo(array[mid]))
      {
         case 1:
         {
           min = mid + 1;
           break;
         }
         case -1:
         {
           max = mid - 1;
           break;
         }
         case 0:
         {
           return mid;
         }
      }
    }
    return -1;
  }
}
