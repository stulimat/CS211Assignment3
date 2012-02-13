import java.lang.Comparable;
import java.lang.Integer;
public class SearcherTester
{
  public static void main(String[] args)
  {
    Integer[] sortedArray = {1,2,3,4,5,6,7,8,9};
    System.out.println("Finding 2 in the list");
    System.out.println("2 Found at " + Integer.toString(Searcher.binarySearch(2,sortedArray)));
    System.out.println("Looking for 20 in the list");
    System.out.println("20 Found at " + Integer.toString(Searcher.binarySearch(20,sortedArray)));
  }
}
