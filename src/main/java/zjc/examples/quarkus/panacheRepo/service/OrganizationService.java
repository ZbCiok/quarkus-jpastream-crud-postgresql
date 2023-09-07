package zjc.examples.quarkus.panacheRepo.service;

import zjc.examples.quarkus.panacheRepo.entity.Organization;
import zjc.examples.quarkus.panacheRepo.repository.OrganizationRepository;
import zjc.examples.quarkus.panacheRepo.repository.OrganizationRepositoryImpl;
import zjc.examples.quarkus.panacheRepo.resource.OrganizationResource;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.Optional;

@ApplicationScoped
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepositoryImpl organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    private static final Logger LOG = Logger.getLogger(OrganizationResource.class);

    public Organization get(Long id) {
        return organizationRepository.findOrganizationById(id).orElseThrow(() -> new RuntimeException("Organization not found"));
    }

    public Organization create(Organization organization) {
        LOG.info("Create organization ...");
        organizationRepository.save(organization);
        LOG.info("new organization.id = " + organization.getId());
        return organization;
    }

    @Transactional
    public Organization update(Long id, Organization organization) {
        Optional<Organization> organizationById = organizationRepository.findOrganizationById(id);
        Organization savedOrganization;
        if (organizationById.isPresent()) {
           savedOrganization =  organizationById.get();
           savedOrganization.setName(organization.getName());
        } else {
            throw new RuntimeException("Organization not found");
        }
        organizationRepository.save(savedOrganization);
        return organization;
    }

    public void delete(Long id) {
        organizationRepository.deleteMemberById(id);
    }

    public Organization getByName(String name) {
        return organizationRepository.findMemberByName(name).orElseThrow(() -> new RuntimeException("Organization not found"));
    }

    public Iterable<Organization> getAll() {
        return organizationRepository.findAllOrganizations();
    }
}
