package zjc.examples.quarkus.panacheRepo.repository;

import com.speedment.jpastreamer.application.JPAStreamer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import zjc.examples.quarkus.panacheRepo.dto.OrganizationDetailsDto;
import zjc.examples.quarkus.panacheRepo.dto.OrganizationDto;
import zjc.examples.quarkus.panacheRepo.entity.Organization;
import zjc.examples.quarkus.panacheRepo.entity.Organization$;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.speedment.jpastreamer.streamconfiguration.StreamConfiguration.of;

@ApplicationScoped
public class OrganizationRepositoryImpl implements PanacheRepository<Organization>, OrganizationRepository {
    @Inject
    JPAStreamer jpaStreamer;
    private Stream<Organization> organizationStream() {
        return jpaStreamer.stream(Organization.class);
    }


    public List<OrganizationDto> getAll() {
        return jpaStreamer.stream(Organization.class)
                .sorted(Organization$.name)
                .map(OrganizationDto::new)
                .collect(Collectors.toList());
    }

    public OrganizationDto getById(final Long id) {
        return jpaStreamer.stream(of(Organization.class))
                .filter(Organization$.id.equal(id))
                .map(OrganizationDto::new)
                .findFirst()
                .orElseThrow();
    }

    public OrganizationDetailsDto getDetailsById(final Long id) {
        return jpaStreamer.stream(of(Organization.class)
                        .joining(Organization$.departments))
                .filter(Organization$.id.equal(id))
                .map(OrganizationDetailsDto::new)
                .findFirst()
                .orElseThrow();
    }


 // --------------------------------------------------------


    @Override
    @Transactional
    public void save(Organization organization) {
        persistAndFlush(organization);
    }

    @Override
    @Transactional
    public boolean deleteMemberById(Long id) {
        return deleteById(id);
    }


    @Transactional
    public void updateNameFrom(Long id) {
        organizationStream()
                .filter(Organization$.id.greaterThan(id))
                .forEach(f -> {
                    f.setName("XXXXXXX");
                });
    }

    public Organization findByName(String name) {
        return organizationStream()
                .filter(Organization$.name.equal(name))
                .findFirst().orElse(null);
    }
}
