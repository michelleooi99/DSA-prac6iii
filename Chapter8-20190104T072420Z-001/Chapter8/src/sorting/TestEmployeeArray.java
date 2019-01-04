package sorting;

public class TestEmployeeArray {

  public static void main(String[] args) {
    Employee[] empArray = new Employee[5];

    empArray[0] = new Employee(5555, "Jack Bauer", "50 Hollywood Drive", 8888.88);
    empArray[1] = new Clerk(7777, "Lee Hom", "2 Hong Kong", 7897.55, 10, 7.90);
    empArray[2] = new Manager(2222, "Col. Sanders", "81 Kentucky Lane", 5000.00, 900.00);
    empArray[3] = new Clerk(8888, "John Doe", "32 Manchester FC", 2000.00, 4, 4.50);
    empArray[4] = new Manager(3333, "Tony Fey", "7 AirAsia Street", 7000.00, 127.00);

    System.out.println("Printing empArray before sorting: ");
    for (int i = 0; i < empArray.length; ++i) {
      System.out.println((i + 1) + ". " + empArray[i]);
    }

    SortArray.bubbleSort(empArray, empArray.length);
    System.out.println("Printing empArray after sorting: ");
    for (int i = 0; i < empArray.length; ++i) {
      System.out.println((i + 1) + ". " + empArray[i]);
    }

  }
}
