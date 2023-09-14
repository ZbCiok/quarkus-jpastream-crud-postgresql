package zjc.examples.quarkus.panacheRepo.mapper;

import org.mapstruct.Mapper;
import zjc.examples.quarkus.panacheRepo.dto.OrganizationDto;
import zjc.examples.quarkus.panacheRepo.entity.Organization;

@Mapper(componentModel = "cdi")
public interface OrganizationMapper {
    OrganizationDto toOrganizationDto(Organization organization);
    Organization toOrganizationEntity(OrganizationDto organizationDto);
}
