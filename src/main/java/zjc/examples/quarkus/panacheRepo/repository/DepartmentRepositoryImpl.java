package zjc.examples.quarkus.panacheRepo.repository;

import com.speedment.jpastreamer.application.JPAStreamer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import zjc.examples.quarkus.panacheRepo.dto.DepartmentDto;
import zjc.examples.quarkus.panacheRepo.entity.Department;
import zjc.examples.quarkus.panacheRepo.entity.Department$;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.speedment.jpastreamer.streamconfiguration.StreamConfiguration.of;

@ApplicationScoped
public class DepartmentRepositoryImpl implements PanacheRepository<Department>, DepartmentRepository {
    @Inject
    JPAStreamer jpaStreamer;
    private Stream<Department> departmentStream() {
        return jpaStreamer.stream(Department.class);
    }


    public List<DepartmentDto> getAll() {
        return jpaStreamer.stream(Department.class)
                .sorted(Department$.name)
                .map(DepartmentDto::new)
                .collect(Collectors.toList());
    }

    public DepartmentDto getById(final Long id) {
        return jpaStreamer.stream(of(Department.class))
                .filter(Department$.id.equal(id))
                .map(DepartmentDto::new)
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
    public void save(Department dep) {
        persistAndFlush(dep);
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
