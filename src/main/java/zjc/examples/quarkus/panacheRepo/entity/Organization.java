package zjc.examples.quarkus.panacheRepo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;

    @OneToMany(fetch = FetchType.EAGER)
    //@OneToMany(mappedBy = "organization", fetch = FetchType.EAGER)
    private Set<Department> departments;

    @OneToMany(fetch = FetchType.EAGER)
    //@OneToMany(mappedBy = "organization", fetch = FetchType.EAGER)
    private Set<Employee> employees;
}


