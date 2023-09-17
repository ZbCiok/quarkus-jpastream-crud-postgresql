package zjc.examples.quarkus.panacheRepo.dto;

import zjc.examples.quarkus.panacheRepo.entity.Department;
import zjc.examples.quarkus.panacheRepo.entity.Employee;


import java.io.Serializable;

public class EmployeeDto  implements Serializable {

    public Long id;
    public String name;
    public String position;
    public int salary;
    public int age;

    public Department department;


    public EmployeeDto() { }
    public EmployeeDto(Employee emp) {
        this.id = emp.getId();
        this.name = emp.getName();
        this.position = emp.getPosition();
        this.salary = emp.getSalary();
        this.age = emp.getAge();
        this.department = emp.getDepartment();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
