import java.util.Comparator;

public class Employee implements Comparable<Employee>{

    private String firstName;
    private String lastName;
    private String role;
    private int totalSalary;
    private int EmployeeID;

    public Employee(String firstName, String lastName, String role, int totalSalary, int employeeID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.totalSalary = totalSalary;
        EmployeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(int totalSalary) {
        this.totalSalary = totalSalary;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    @Override
    public int compareTo(Employee emp) {
        return this.EmployeeID - emp.EmployeeID;
    }


      @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                ", totalSalary=" + totalSalary +
                ", EmployeeID=" + EmployeeID +
                '}';
    }
}
