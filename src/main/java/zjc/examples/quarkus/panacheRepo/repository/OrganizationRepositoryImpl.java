package zjc.examples.quarkus.panacheRepo.repository;

import com.speedment.jpastreamer.application.JPAStreamer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import zjc.examples.quarkus.panacheRepo.entity.Organization;
import zjc.examples.quarkus.panacheRepo.entity.Organization$;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@ApplicationScoped
public class OrganizationRepositoryImpl implements PanacheRepository<Organization>, OrganizationRepository {
    @Inject
    JPAStreamer jpaStreamer;
    private Stream<Organization> filmStream() {
        return jpaStreamer.stream(Organization.class);
    }

    private Stream<Organization> organizationStream() { return jpaStreamer.stream(Organization.class); }
    @Override
    public Optional<Organization> findOrganizationById(Long id) {
        return findByIdOptional(id);
    }

    @Override
    public List<Organization> findAllOrganizations() {
        return findAll().list();
    }

    @Override
    @Transactional
    public void save(Organization organization) {
        persistAndFlush(organization);
    }

    @Override
    public Optional<Organization> findMemberByName(String name) {
        return find("name = ?1", name).stream().findFirst();
    }

    @Override
    @Transactional
    public boolean deleteMemberById(Long id) {
        return deleteById(id);
    }


//    @Transactional
//    public void updateDescription(String desc, short length) {
//        organizationStream()
//                .filter(Organization$.length.greaterThan(length))
//                .forEach(f -> {
//                    f.setName("XXXXXXX");
//                });
//    }

    public Organization findByTitle(String name) {
        return filmStream()
                .filter(Organization$.name.equal(name))
                .findFirst().orElse(null);
    }

//    /**
//     * Updates the description of all films that are longer than the provided length to desc.
//     *
//     * @param desc the new description
//     * @param length the minimum length of films that should be updated, exclusive
//     */
//    @Transactional
//    public void updateDescription(String desc, short length) {
//        filmStream()
//                .filter(Organization$.length.greaterThan(length))
//                .forEach(f -> {
//                    f.setDescription("YYYYYYYY");
//                });
//    }
}
