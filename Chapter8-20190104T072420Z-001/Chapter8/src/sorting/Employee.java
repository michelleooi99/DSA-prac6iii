package sorting;

public class Employee implements Comparable<Employee> {

  private int employeeID;
  private String name;
  private String address;
  private double basicSalary;

  public Employee(int employeeID, String name, String address, double basicSalary) {
    this.employeeID = employeeID;
    this.name = name;
    this.address = address;
    this.basicSalary = basicSalary;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getEmployeeID() {
    return employeeID;
  }

  public void setEmployeeID(int employeeID) {
    this.employeeID = employeeID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getBasicSalary() {
    return basicSalary;
  }

  public void setBasicSalary(double basicSalary) {
    this.basicSalary = basicSalary;
  }

  public int compareTo(Employee e) {
//    if (this.employeeID > e.employeeID) {
//      return 1;
//    } else if (this.employeeID < e.employeeID) {
//      return -1;
//    } else {
//      return 0;
//    }
    return (int) (this.employeeID - e.employeeID);
  } 
  

  @Override
  public String toString() {
    return "ID: " + employeeID + "\nName: " + name + "\nAddress: " + address
            + String.format("\nBasic Salary: RM%,.2f\n", basicSalary);
  }
}
