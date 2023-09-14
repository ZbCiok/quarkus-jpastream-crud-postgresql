package zjc.examples.quarkus.panacheRepo.repository;

import com.speedment.jpastreamer.application.JPAStreamer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import zjc.examples.quarkus.panacheRepo.dto.EmployeeDto;
import zjc.examples.quarkus.panacheRepo.dto.OrganizationDetailsDto;
import zjc.examples.quarkus.panacheRepo.dto.OrganizationDto;
import zjc.examples.quarkus.panacheRepo.entity.Employee;
import zjc.examples.quarkus.panacheRepo.entity.Employee$;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.speedment.jpastreamer.streamconfiguration.StreamConfiguration.of;

@ApplicationScoped
public class EmployeeRepositoryImpl implements PanacheRepository<Employee>, EmployeeRepository {
    @Inject
    JPAStreamer jpaStreamer;
    private Stream<Employee> employeeStream() {
        return jpaStreamer.stream(Employee.class);
    }




    public List<EmployeeDto> getAll() {
        return jpaStreamer.stream(Employee.class)
                .sorted(Employee$.name)
                .map(EmployeeDto::new)
                .collect(Collectors.toList());
    }

    public EmployeeDto getById(final Long id) {
        return jpaStreamer.stream(of(Employee.class))
                .filter(Employee$.id.equal(id))
                .map(EmployeeDto::new)
                .findFirst()
                .orElseThrow();
    }


//    public OrganizationDetailsDto getDetailsById(final Long id) {
//        return jpaStreamer.stream(of(Organization.class)
//                        //.joining(Organization$.departments)
//                        .joining(Organization$.employees))
//                .filter(Organization$.id.equal(id))
//                .map(OrganizationDetailsDto::new)
//                .findFirst()
//                .orElseThrow();
//    }

/*
    Map<Language, Set<Film>> languageFilmMap = jpaStreamer.stream(of(Language.class)
                  .joining(Language$.films))
                          .collect(toMap(
                                Function.identity(),
                                Language::getFilms)
            );
*/

 // --------------------------------------------------------


    @Override
    @Transactional
    public void save(Employee emp) {
        persistAndFlush(emp);
    }

//    @Override
//    @Transactional
//    public boolean deleteMemberById(Long id) {
//        return deleteById(id);
//    }
//
//
//    @Transactional
//    public void updateNameFrom(Long id) {
//        organizationStream()
//                .filter(Organization$.id.greaterThan(id))
//                .forEach(f -> {
//                    f.setName("XXXXXXX");
//                });
//    }
//
//    public Organization findByName(String name) {
//        return organizationStream()
//                .filter(Organization$.name.equal(name))
//                .findFirst().orElse(null);
//    }
}
