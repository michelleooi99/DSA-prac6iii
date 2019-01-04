package sorting;

public class Clerk extends Employee {

  private int overtimeHours;
  private double overtimeRate;

  public Clerk(int employeeID, String name, String address, double basicSalary, int overtimeHours, double overtimeRate) {
    super(employeeID, name, address, basicSalary);
    this.overtimeHours = overtimeHours;
    this.overtimeRate = overtimeRate;
  }

  public int getOvertimeHours() {
    return overtimeHours;
  }

  public void setOvertimeHours(int overtimeHours) {
    this.overtimeHours = overtimeHours;
  }

  public double getOvertimeRate() {
    return overtimeRate;
  }

  public void setOvertimeRate(double overtimeRate) {
    this.overtimeRate = overtimeRate;
  }

  @Override
  public String toString() {
    return super.toString() + "Overtime Hours: " + overtimeHours
            + String.format("\nOvertime Rate: RM%,.2f\n", overtimeRate);
  }
}
