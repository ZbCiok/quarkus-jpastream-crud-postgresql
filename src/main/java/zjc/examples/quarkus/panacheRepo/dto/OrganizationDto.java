package zjc.examples.quarkus.panacheRepo.dto;


import zjc.examples.quarkus.panacheRepo.entity.Organization;
import zjc.examples.quarkus.panacheRepo.entity.Department;
import zjc.examples.quarkus.panacheRepo.entity.Employee;

import java.io.Serializable;
import java.util.Set;


public class OrganizationDto  implements Serializable {
    public Long id;
    public String name;
    private Set<Department> departments;


    public OrganizationDto() { }

    public OrganizationDto(Organization org) {
        this.id = org.getId();
        this.name = org.getName();
        this.departments = org.getDepartments();
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
}
