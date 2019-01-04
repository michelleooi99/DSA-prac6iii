package searching;

/**
 * A driver that demonstrates the class SortedArrayList.
 */
public class Driver {

  public static void main(String[] args) {
    testSortedList();
    System.out.println("\n\nDone.");
  }  // end main

  public static void testSortedList() {
    // create names for a list
    Name brent = new Name("Brent", "Barka");
    Name donna = new Name("Donna", "Dalton");
    Name jerry = new Name("Jerry", "Java");
    Name luke = new Name("Luke", "Lexter");
    Name sue = new Name("Sue", "Smith");
    Name tom = new Name("Tom", "Towers");

    // create a list
    SortedListInterface<Name> myList = new SortedArrayList<Name>();

    myList.add(luke);
    myList.add(brent);
    myList.add(donna);
    myList.add(tom);
    myList.add(sue);
    myList.add(jerry);

    // display the list
    System.out.println("List should contain\nBrent Barka, Donna Dalton, "
            + "Jerry Java, Luke Lexter, Sue Smith, Tom Towers");
    System.out.println("\n\nList actually contains:");
    myList.display();
    System.out.println();

    // test getPosition
    System.out.println("\nTest getPosition:\n");

    Name missy = new Name("Missing", "Person");
    System.out.println("Brent is at position " + myList.getPosition(brent));
    System.out.println("Donna is at position " + myList.getPosition(donna));
    System.out.println("Jerry is at position " + myList.getPosition(jerry));
    System.out.println("Luke is at position " + myList.getPosition(luke));
    System.out.println("Sue is at position " + myList.getPosition(sue));
    System.out.println("Tom is at position " + myList.getPosition(tom));

    System.out.println("Missing Person belongs at position " + Math.abs(myList.getPosition(missy)));

    // test getLength and getEntry
    System.out.println("\n\nTest getLength and getEntry:\n");

    System.out.println("\nList has " + myList.getLength() + " entries, as follows:\n");
    for (int i = 1; i <= myList.getLength(); i++) {
      System.out.println(i + ": " + myList.getEntry(i));
    }

    // test contains
    System.out.println("\n\nTest contains:\n");

    if (myList.contains(brent)) {
      System.out.println("\nBrent is in list - OK");
    } else {
      System.out.println("contains() error");
    }

    if (myList.contains(donna)) {
      System.out.println("\nDonna is in list - OK");
    } else {
      System.out.println("contains() error");
    }

    if (myList.contains(jerry)) {
      System.out.println("\nJerry is in list - OK");
    } else {
      System.out.println("contains() error");
    }

    if (myList.contains(luke)) {
      System.out.println("\nLuke is in list - OK");
    } else {
      System.out.println("contains() error");
    }

    if (myList.contains(sue)) {
      System.out.println("\nSue is in list - OK");
    } else {
      System.out.println("contains() error");
    }

    if (myList.contains(tom)) {
      System.out.println("\nTom is in list - OK");
    } else {
      System.out.println("contains() error");
    }

    if (!myList.contains(missy)) {
      System.out.println("\nMissing Person is not in list - OK");
    } else {
      System.out.println("contains() error");
    }

    // test contains and isEmpty on an empty list
    System.out.println("\n\nTest contains with an empty list:");

    SortedListInterface emptyList = new SortedArrayList();
    if (emptyList.contains(luke)) {
      System.out.println("contains() error");
    } else {
      System.out.println("Luke is not in an empty list - OK");
    }

    System.out.println("\n\nTest isEmpty with an empty list:");
    if (emptyList.isEmpty()) {
      System.out.println("OK");
    } else {
      System.out.println("isEmpty() error");
    }

    // test remove
    System.out.println("\n\nTest remove:\n");

    // remove first entry
    System.out.println("\nRemoving first item (Brent): " + myList.remove(brent));
    System.out.println("\nAfter removing Brent, list contains " + myList.getLength()
            + " items, as follows:");
    myList.display();

    // remove interior
    System.out.println("\n\nRemoving interior item (Luke): " + myList.remove(luke));
    System.out.println("\nAfter removing Luke, list contains " + myList.getLength()
            + " items, as follows:");
    myList.display();

    // remove last
    System.out.println("\n\nRemoving last item (Tom): " + myList.remove(tom));
    System.out.println("\nAfter removing last item, list contains " + myList.getLength()
            + " items, as follows:");
    myList.display();

    System.out.println("\n\nRemoving a missing item (Brent): " + myList.remove(brent));
    System.out.println("\nRemoving a missing item (Luke): " + myList.remove(luke));
    System.out.println("\nRemoving a missing item (Tom): " + myList.remove(tom));

    System.out.println("\nThe list contains " + myList.getLength()
            + " items, as follows:");
    myList.display();

    // test clear()
    System.out.println("\n\nTest clear():\n");
    myList.clear();

    if (myList.isEmpty()) {
      System.out.println("\nThe list is empty after invoking clear().");
    } else {
      System.out.println("\nclear() error");
    }
  } // end testSortedList
}  // end Driver

