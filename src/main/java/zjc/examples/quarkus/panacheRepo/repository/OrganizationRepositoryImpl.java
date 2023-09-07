package zjc.examples.quarkus.panacheRepo.repository;

import zjc.examples.quarkus.panacheRepo.entity.Organization;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class OrganizationRepositoryImpl implements PanacheRepository<Organization>, OrganizationRepository {

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
}
