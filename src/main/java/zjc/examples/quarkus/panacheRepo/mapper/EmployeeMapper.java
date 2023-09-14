package zjc.examples.quarkus.panacheRepo.mapper;


import org.mapstruct.Mapper;
import zjc.examples.quarkus.panacheRepo.dto.EmployeeDto;
import zjc.examples.quarkus.panacheRepo.dto.OrganizationDto;
import zjc.examples.quarkus.panacheRepo.entity.Employee;
import zjc.examples.quarkus.panacheRepo.entity.Organization;

@Mapper(componentModel = "cdi")
public interface EmployeeMapper {
    EmployeeDto toEmployeeDto(Employee employee);
    Employee toEmployeeEntity(EmployeeDto employeeDto);
}
