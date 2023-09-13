package zjc.examples.quarkus.panacheRepo.dto;

import zjc.examples.quarkus.panacheRepo.entity.Organization;
import zjc.examples.quarkus.panacheRepo.entity.Department;
import zjc.examples.quarkus.panacheRepo.entity.Employee;

import java.util.Set;

public class OrganizationDto {
    public Long id;
    public String name;
    private Set<Department> departments;
    private Set<Employee> employees;


    public OrganizationDto(Organization org) {
        this.id = org.getId();
        this.name = org.getName();
        this.departments = org.getDepartments();
        this.employees = org.getEmployees();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
