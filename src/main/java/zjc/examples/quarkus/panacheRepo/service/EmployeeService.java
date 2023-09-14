package zjc.examples.quarkus.panacheRepo.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;
import zjc.examples.quarkus.panacheRepo.dto.EmployeeDto;
import zjc.examples.quarkus.panacheRepo.dto.OrganizationDetailsDto;
import zjc.examples.quarkus.panacheRepo.dto.OrganizationDto;
import zjc.examples.quarkus.panacheRepo.entity.Employee;
import zjc.examples.quarkus.panacheRepo.entity.Organization;
import zjc.examples.quarkus.panacheRepo.mapper.EmployeeMapper;
import zjc.examples.quarkus.panacheRepo.mapper.OrganizationMapper;
import zjc.examples.quarkus.panacheRepo.repository.EmployeeRepository;
import zjc.examples.quarkus.panacheRepo.repository.EmployeeRepositoryImpl;
import zjc.examples.quarkus.panacheRepo.repository.OrganizationRepository;
import zjc.examples.quarkus.panacheRepo.repository.OrganizationRepositoryImpl;
import zjc.examples.quarkus.panacheRepo.resource.OrganizationResource;

import java.util.List;

@ApplicationScoped
public class EmployeeService {

    private static final Logger LOG = Logger.getLogger(EmployeeService.class);
    private final EmployeeRepository employeeRepository;

    @Inject
    EmployeeMapper employeeMapper;
    public EmployeeService(EmployeeRepositoryImpl employeeRepository) {
        this.employeeRepository = employeeRepository;
    }



    public List<EmployeeDto> getAll()  {
        return employeeRepository.getAll();
    }

    public EmployeeDto getById(final Long id) {
        return employeeRepository.getById(id);
    }

//    public OrganizationDetailsDto getDetailsById(final Long id) {
//        return organizationRepository.getDetailsById(id);
//    }

    // ----------------------------------------------------------------------


    public EmployeeDto create(EmployeeDto employeeDto) {
        Employee employee = employeeMapper.toEmployeeEntity(employeeDto);
        employeeRepository.save(employee);
        return employeeMapper.toEmployeeDto(employee);
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
