package sorting;

public class SortArray {

  public static <T extends Comparable<? super T>> void bubbleSort(T[] a, int n) {
    boolean sorted = false;
    for (int pass = 1; pass < n && !sorted; pass++) {
      sorted = true;
      for (int index = 0; index < n - pass; index++) {
        // swap adjacent elements if first is greater than second
        if (a[index].compareTo(a[index + 1]) > 0) {
          swap(a, index, index + 1); // swap adjacent elements 
          sorted = false;  // array not sorted because a swap was performed
        }
      } // end inner for
    }
  }

  /**
   * Task: Swaps the array elements a[i] and a[j].
   *
   * @param a an array of objects
   * @param i an integer >= 0 and < a.length @par
   * am j an integer >= 0 and < a.length
   *
   */
  private static void swap(Object[] a, int i, int j) {
    Object temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  } // end swap

  // method quickSort()
  public static <T extends Comparable<? super T>> void quickSort(T[] a, int n) {
    quickSort(a, 0, n - 1);
  }

  // recursive private overloaded method quickSort() 
  private static <T extends Comparable<? super T>> void quickSort(T[] a, int first, int last) {
    System.out.printf("\n*** TRACE: quickSort(a, %d, %d):\n", first, last);
    if (first < last) {
      System.out.printf("\npartition(a, %d, %d):\n", first, last);
      int pivotIndex = partition(a, first, last);
      System.out.print("\n*** TRACE: array contents after partition:  ");
      printArray(a);
      quickSort(a, first, pivotIndex - 1);
      quickSort(a, pivotIndex + 1, last);
    }
  }

  // private method partition() - to partition the array based on the pivot value
  private static <T extends Comparable<? super T>> int partition(T[] a, int first, int last) {
    int pivotIndex = last;
    T pivot = a[last];
    int indexFromLeft = first;
    int indexFromRight = last - 1;
    boolean done = false;

    while (!done) {
      while (indexFromLeft < last && a[indexFromLeft].compareTo(pivot) < 0) {
        indexFromLeft++;
      }

      while (indexFromRight > first && a[indexFromRight].compareTo(pivot) > 0) {
        indexFromRight--;
      }

      if (indexFromLeft < indexFromRight) {
        swap(a, indexFromLeft, indexFromRight);
        indexFromLeft++;
        indexFromRight--;
      } else {
        done = true;
      }
    } // end while
    swap(a, pivotIndex, indexFromLeft);
    pivotIndex = indexFromLeft;
    return pivotIndex;
  }

  public static void main(String[] args) {
//    String[] nameArray = {"Dan", "Ann", "Zoe", "Jet", "Ben"};
//
//    printArray(nameArray);
//    bubbleSort(nameArray, nameArray.length);
//    System.out.println("After sorting: ");
//    printArray(nameArray);
//
//    Integer[] numArray = {90, 40, 10, 30, 20, 50};
//
//    printArray(numArray);
//    bubbleSort(numArray, numArray.length);
//    System.out.println("After sorting: ");
//    printArray(numArray);

    // To test quicksort
    
     Integer[] numArray2 = {3, 5, 0, 4, 6, 1, 2, 4};
     System.out.println("Original array:");
     printArray(numArray2);
     quickSort(numArray2, numArray2.length);
     System.out.println("\nAfter sorting: ");
     printArray(numArray2);
     
  }

  public static <T> void printArray(T[] a) {
    for (int i = 0; i < a.length; ++i) {
      System.out.print(a[i] + "\t");
    }
    System.out.println("\n");
  }
} // end SortArray
