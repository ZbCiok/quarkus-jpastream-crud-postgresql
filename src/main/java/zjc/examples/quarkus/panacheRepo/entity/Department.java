package zjc.examples.quarkus.panacheRepo.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    //@OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private Set<Employee> employees;
    @ManyToOne(fetch = FetchType.LAZY)
    private Organization organization;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
