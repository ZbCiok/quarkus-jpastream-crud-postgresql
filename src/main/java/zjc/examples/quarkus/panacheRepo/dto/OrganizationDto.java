package zjc.examples.quarkus.panacheRepo.dto;

public class OrganizationDto {
    public Long id;
    public String name;
//     private Set<Department> departments;
//    private Set<Employee> employees;

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

}
