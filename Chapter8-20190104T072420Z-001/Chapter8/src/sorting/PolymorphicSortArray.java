package sorting;

public class PolymorphicSortArray {

  public static <T extends Comparable<? super T>>
          void bubbleSort(T[] a, int n) {
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
   * @param i an integer >= 0 and < a.length
   * @par
   * am j an integer >= 0 and < a.length 
   *
   */
  private static void swap(Object[] a, int i, int j) {
    Object temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  } // end swap

  public static void main(String[] args) {
    String[] nameArray = {"Dan", "Ann", "Zoe", "Jet", "Ben"};

    printArray(nameArray);
    bubbleSort(nameArray, nameArray.length);
    System.out.println("After sorting: ");
    printArray(nameArray);

    Integer[] numArray = {90, 40, 10, 30, 20, 50};

    printArray(numArray);
    bubbleSort(numArray, numArray.length);
    System.out.println("After sorting: ");
    printArray(numArray);
  }

  public static <T> void printArray(T[] a) {
    for (int i = 0; i < a.length; ++i) {
      System.out.print(a[i] + "\t");
    }
    System.out.println("\n");
  }
} // end PolymorphicSortArray
