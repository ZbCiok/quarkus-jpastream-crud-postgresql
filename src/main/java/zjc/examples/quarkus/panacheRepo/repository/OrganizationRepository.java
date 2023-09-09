package zjc.examples.quarkus.panacheRepo.repository;

import zjc.examples.quarkus.panacheRepo.entity.Organization;

import java.util.List;
import java.util.Optional;

public interface OrganizationRepository {

    Optional<Organization> findOrganizationById(Long id);

    Optional<Organization> findMemberByName(String username);

    List<Organization> findAllOrganizations();

    boolean deleteMemberById(Long id);

    void save(Organization member);

    void updateNameFrom(Long id);
}
