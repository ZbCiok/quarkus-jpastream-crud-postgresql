package zjc.examples.quarkus.panacheRepo.dto;

import zjc.examples.quarkus.panacheRepo.entity.Department;
import zjc.examples.quarkus.panacheRepo.entity.Employee;
import zjc.examples.quarkus.panacheRepo.entity.Organization;

import java.io.Serializable;
import java.util.Set;

public class DepartmentDto implements Serializable {

    public Long id;
    public String name;
    public Organization organization;
    public Set<Employee> employees;

    public DepartmentDto() {}

    public DepartmentDto(Department dep) {
        this.id = dep.getId();
        this.name = dep.getName();
        this.organization = dep.getOrganization();
        this.employees = dep.getEmployees();
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

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
