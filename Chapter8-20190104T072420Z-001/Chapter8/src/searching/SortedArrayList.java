package searching;

/**
 * SortedArrayList - A class that implements the ADT sorted list by using an
 * expandable array and includes the binarySearch method which implements the
 * recursive binary search algorithm
 */
public class SortedArrayList<T extends Comparable<? super T>> implements SortedListInterface<T> {

  private T[] list;			 	// array of list entries
  private int length;  			 	// current number of entries on list
  private static final int DEFAULT_INITIAL_CAPACITY = 25; 	// initial length of list 

  public SortedArrayList() {
    this(DEFAULT_INITIAL_CAPACITY);
  } // end default constructor

  public SortedArrayList(int initialCapacity) {
    length = 0;
    list = (T[]) new Comparable[initialCapacity];
  } // end default constructor

  // method contains invokes method binarySearch
  public boolean contains(T anEntry) {
    return binarySearch(0, length - 1, anEntry);
  } // end contains

  // recursive binary search
  private boolean binarySearch(int first, int last, T desiredItem) {
    boolean found;
    int mid = (first + last) / 2;

    if (first > last) {
      found = false;
    } else if (desiredItem.equals(list[mid])) {
      found = true;
    } else if (desiredItem.compareTo(list[mid]) < 0) {
      found = binarySearch(first, mid - 1, desiredItem);
    } else {
      found = binarySearch(mid + 1, last, desiredItem);
    }

    return found;
  } // end binarySearch

  /*
   // ----------------------------------------------------------
   // recursive sequential search
   public boolean contains(T anEntry) {
   search(0, length - 1, anEntry);
   } // end contains
	
   private boolean search(int first, int last, T desiredItem) {
   boolean found;
	  
   if (first > last)
   found = false; // no elements to search
   else if (desiredItem.equals(list[first]))
   found = true;
   else
   found = search(first + 1, last, desiredItem);
  
   return found;
   } // end search
   */
  public boolean add(T newEntry) {
    if (isArrayFull()) {
      doubleArray();
    }

    int toIndex, fromIndex;

    // beginning at the end of the array, shift entries to next higher position 
    // until proper sorted position for newEntry is found
    for (fromIndex = length - 1, toIndex = fromIndex + 1; (fromIndex >= 0)
            && (newEntry.compareTo(list[fromIndex]) < 0);
            toIndex--, fromIndex--) {
      list[toIndex] = list[fromIndex];
    } // end for

    list[toIndex] = newEntry;
    length++;
    return true;
  } // end add

  public boolean remove(T anEntry) {
    boolean found = false;

    if (!isEmpty()) {
      int position = getPosition(anEntry);
      if (position >= 0) {
        removeGap(position);
        length--;
        found = true;
      } // end if
    } // end if

    return found;
  } // end remove

  public int getPosition(T anEntry) {
    int position = 1;

    while ((position <= length) && (anEntry.compareTo(getEntry(position)) > 0)) {
      position++;
    } // end while

    if ((position > length) || !anEntry.equals(getEntry(position))) {
      position = -position;
    } // end if

    return position;
  } // end getPosition

// list operations
  public T remove(int givenPosition) {
    T result = null; // return value

    if ((givenPosition >= 1) && (givenPosition <= length)) { // test catches empty list

      result = list[givenPosition - 1]; // get entry to be removed

      // move subsequent entries towards entry to be removed, 
      // unless it is last in list
      if (givenPosition < length) {
        removeGap(givenPosition);
      }

      length--;
    } // end if

    return result; // return reference to removed entry,
    // or null if list is empty
  } // end remove

  public void clear() {
    for (int index = 0; index < length; index++) {
      list[index] = null;
    }

    length = 0; // no need to create a new array
  } // end clear

  public boolean replace(int givenPosition, T newEntry) {
    boolean isSuccessful = true;

    if ((givenPosition >= 1) && (givenPosition <= length)) { // test catches empty list
      list[givenPosition - 1] = newEntry;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  } // end replace

  public T getEntry(int givenPosition) {
    T result = null; // result to return

    if (givenPosition >= 1 && givenPosition <= length) {
      result = list[givenPosition - 1];
    } // end if

    return result;
  } // end getEntry

  public int getLength() {
    return length;
  } // end getLength

  public boolean isEmpty() {
    return length == 0;
  }// end isEmpty

  public boolean isFull() {
    return false;
  } //end isFull

  public void display() {
    for (int index = 0; index < length; ++index) {
      System.out.printf("%3d. %-50s\n", index + 1, list[index]);
    }
  }  // end display

  /**
   * @return true if the array of list entries is full, that is, if the length
   * of the list equals the size of the array.
   */
  private boolean isArrayFull() {
    return length == list.length;
  }  //end isArrayFull

  /**
   * Task: Doubles the size of the array of list entries.
   */
  private void doubleArray() {
    T[] oldList = list; // save reference to array of list entries
    int oldSize = oldList.length;     // save old max size of array

    list = (T[]) new Comparable[2 * oldSize];    // double size of array

    // copy entries from old array to new, bigger array
    for (int index = 0; index < oldSize; index++) {
      list[index] = oldList[index];
    }
  } //end doubleArray

  /**
   * Task: Shifts entries that are beyond the entry to be removed to the next
   * lower position. Precondition: list is not empty; 1 <= givenPosition <
   * length; length is list�s length before removal.
   */
  private void removeGap(int givenPosition) {
    // move each entry to next lower position starting at entry after the  
    // one removed and continuing until end of array
    int removedIndex = givenPosition - 1;
    int lastIndex = length - 1;

    for (int index = removedIndex; index < lastIndex; index++) {
      list[index] = list[index + 1];
    }
  }  //end removeGap

} //end SortedArrayList
