package zjc.examples.quarkus.panacheRepo.dto;

import zjc.examples.quarkus.panacheRepo.entity.Department;
import zjc.examples.quarkus.panacheRepo.entity.Organization;

import java.util.Set;

public class OrganizationDetailsDto {
    public Long id;
    public String name;
    //public Set<Department> department;

    public OrganizationDetailsDto(Organization org) {
        this.id = org.getId();
        this.name = org.getName();
        //this.department = org.getDepartments();
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

//    public Set<Department> getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(Set<Department> department) {
//        this.department = department;
//    }
}
