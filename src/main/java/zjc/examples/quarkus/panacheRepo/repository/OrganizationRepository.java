package zjc.examples.quarkus.panacheRepo.repository;

import zjc.examples.quarkus.panacheRepo.dto.OrganizationDetailsDto;
import zjc.examples.quarkus.panacheRepo.dto.OrganizationDto;
import zjc.examples.quarkus.panacheRepo.entity.Organization;

import java.util.List;
import java.util.Optional;

public interface OrganizationRepository {

    public List<OrganizationDto> getAll();

    public OrganizationDto getById(final Long id);

    public OrganizationDetailsDto getDetailsById(final Long id);

// -------------------------------------------------------------------


    boolean deleteMemberById(Long id);

    void save(Organization member);

    void updateNameFrom(Long id);
}
