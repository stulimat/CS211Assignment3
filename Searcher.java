import java.lang.Comparable;
import java.util.ArrayList;

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
  
  public static String binarySearchHint(String destinationWord, String guess,  ArrayList<String> dictionary)
  {
    int min = 0;
    int max = dictionary.size();
    String closestWord = ""; //The "guess" 
    ArrayList<String> wordList = new ArrayList<String>();
    int mid = 0;
    //Find the closest corresponding word in the dictionary:
    while( min < max)
    {
      mid = (min + max) / 2;
      if(guess.compareTo(dictionary.get(mid)) > 0)
      {
        min = mid + 1;
      }
      else if(guess.compareTo(dictionary.get(mid)) < 0)
      {
        max = mid - 1;
      }
      else if(guess.compareTo(dictionary.get(mid)) == 0)
      {
        //The word exists in the dictionary, so just add it by terminating the loop.
        break;
      }
    }
    //In case the loop fell through, just assign the closest word anyway. 
    closestWord = dictionary.get(mid);
    
    int closestWordPosition = dictionary.indexOf(closestWord);
    int destinationWordPosition = dictionary.indexOf(destinationWord);
    if(closestWordPosition  > destinationWordPosition)
    {
      min = 0;
      max = closestWordPosition;
    }
    else
    {
      min = closestWordPosition;
      max = dictionary.size();
    }
    //This loop builds the wordlist leading to the source by binary search based on the current word. 
    while( min < max)
    {
      mid = (min + max) / 2;
      if(guess.compareTo(dictionary.get(mid)) > 0)
      {
        min = mid + 1;
      }
      else if(guess.compareTo(dictionary.get(mid)) < 0)
      {
        max = mid - 1;
      }
      else if(guess.compareTo(dictionary.get(mid)) == 0)
      {
        //The word exists in the dictionary, so just add it by terminating the loop.
        break;
      }
      wordList.add(dictionary.get(mid));
    }
    //Return the middle of the word list - gets them closer to their original goal without giving it to them.
    return wordList.get(wordList.size() / 2);
    
  }
}
