package zjc.examples.quarkus.panacheRepo.service;

import io.quarkus.hibernate.orm.panache.runtime.JpaOperations;
import jakarta.inject.Inject;
import zjc.examples.quarkus.panacheRepo.dto.OrganizationDetailsDto;
import zjc.examples.quarkus.panacheRepo.dto.OrganizationDto;
import zjc.examples.quarkus.panacheRepo.entity.Organization;
import zjc.examples.quarkus.panacheRepo.mapper.OrganizationMapper;
import zjc.examples.quarkus.panacheRepo.repository.OrganizationRepository;
import zjc.examples.quarkus.panacheRepo.repository.OrganizationRepositoryImpl;
import org.jboss.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class OrganizationService {

    private static final Logger LOG = Logger.getLogger(OrganizationService.class);
    private final OrganizationRepository organizationRepository;

    @Inject
    OrganizationMapper organizationMapper;
    public OrganizationService(OrganizationRepositoryImpl organizationRepository) {
        this.organizationRepository = organizationRepository;
    }



    public List<OrganizationDto> getAll()  {
        return organizationRepository.getAll();
    }

    public OrganizationDto getById(final Long id) {
        return organizationRepository.getById(id);
    }

    public OrganizationDetailsDto getDetailsById(final Long id) {
        return organizationRepository.getDetailsById(id);
    }

    // ----------------------------------------------------------------------


    public OrganizationDto create(OrganizationDto organizationDto) {
        Organization organization = organizationMapper.toOrganizationEntity(organizationDto);
        organizationRepository.save(organization);
        return organizationMapper.toOrganizationDto(organization);
    }

//    @Transactional
//    public Organization update(Long id, Organization organization) {
//        Optional<Organization> organizationById = organizationRepository.getById(id);
//        Organization savedOrganization;
//        if (organizationById.isPresent()) {
//           savedOrganization =  organizationById.get();
//           savedOrganization.setName(organization.getName());
//        } else {
//            throw new RuntimeException("Organization not found");
//        }
//        organizationRepository.save(savedOrganization);
//        return organization;
//    }

    public void delete(Long id) {
        organizationRepository.deleteMemberById(id);
    }

    public void updateNameFrom(Long id) {
        organizationRepository.updateNameFrom(id);
    }

}
