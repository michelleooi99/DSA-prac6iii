package sorting;

public class Manager extends Employee {

  private double allowance;

  public Manager(int employeeID, String name, String address, double basicSalary, double allowance) {
    super(employeeID, name, address, basicSalary);
    this.allowance = allowance;
  }

  public double getAllowance() {
    return allowance;
  }

  public void setAllowance(double allowance) {
    this.allowance = allowance;
  }

  @Override
  public String toString() {
    return super.toString() + String.format("\nAllowance: RM%,.2f\n", allowance);
  }
}
