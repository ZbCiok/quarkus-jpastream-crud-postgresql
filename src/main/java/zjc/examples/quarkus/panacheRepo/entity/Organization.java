package zjc.examples.quarkus.panacheRepo.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.enterprise.inject.Default;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
//@Getter
//@Setter
//@NoArgsConstructor
@ToString
public class Organization  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;

//    @OneToMany(fetch = FetchType.EAGER)
//    //@OneToMany(mappedBy = "organization", fetch = FetchType.EAGER)
//    private Set<Department> departments;


    @OneToMany(fetch = FetchType.EAGER)
    @JsonManagedReference
    public Set<Employee> employees;


    public Organization() {}

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}


