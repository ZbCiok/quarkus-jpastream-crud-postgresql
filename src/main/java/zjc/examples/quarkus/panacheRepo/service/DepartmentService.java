package zjc.examples.quarkus.panacheRepo.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;
import zjc.examples.quarkus.panacheRepo.dto.DepartmentDto;
import zjc.examples.quarkus.panacheRepo.entity.Department;
import zjc.examples.quarkus.panacheRepo.mapper.DepartmentMapper;
import zjc.examples.quarkus.panacheRepo.repository.DepartmentRepository;
import zjc.examples.quarkus.panacheRepo.repository.DepartmentRepositoryImpl;

import java.util.List;

@ApplicationScoped
public class DepartmentService {

    private static final Logger LOG = Logger.getLogger(DepartmentService.class);
    private final DepartmentRepository departmentRepository;

    @Inject
    DepartmentMapper departmentMapper;
    public DepartmentService(DepartmentRepositoryImpl departmentRepository) {
        this.departmentRepository = departmentRepository;
    }



    public List<DepartmentDto> getAll()  {
        return departmentRepository.getAll();
    }

    public DepartmentDto getById(final Long id) {
        return departmentRepository.getById(id);
    }

//    public OrganizationDetailsDto getDetailsById(final Long id) {
//        return organizationRepository.getDetailsById(id);
//    }

    // ----------------------------------------------------------------------


    public DepartmentDto create(DepartmentDto departmentDto) {
        Department department = departmentMapper.toDepartmentEntity(departmentDto);
        departmentRepository.save(department);
        return departmentMapper.toDepartmentDto(department);
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

//    public void delete(Long id) {
//        organizationRepository.deleteMemberById(id);
//    }

//    public void updateNameFrom(Long id) {
//        organizationRepository.updateNameFrom(id);
//    }

}
