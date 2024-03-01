package practice.streams.custom.employee;

import java.util.Objects;

public class Employee {
    private int empId;
    private String empName;
    private int deptId;
    private String status = "active";
    private double salary;

    public Employee(int empId, String empName, int deptId, String status, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.deptId = deptId;
        this.status = status;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Employee{");
        sb.append("empId=").append(empId);
        sb.append(", empName='").append(empName).append('\'');
        sb.append(", deptId=").append(deptId);
        sb.append(", status='").append(status).append('\'');
        sb.append(", salary=").append(salary);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empId == employee.empId && deptId == employee.deptId && Double.compare(salary, employee.salary) == 0 && Objects.equals(empName, employee.empName) && Objects.equals(status, employee.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, empName, deptId, status, salary);
    }
}
