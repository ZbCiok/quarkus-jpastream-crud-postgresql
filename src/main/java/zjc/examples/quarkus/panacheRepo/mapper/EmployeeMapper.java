package zjc.examples.quarkus.panacheRepo.mapper;


import org.mapstruct.Mapper;
import zjc.examples.quarkus.panacheRepo.dto.EmployeeDto;
import zjc.examples.quarkus.panacheRepo.entity.Employee;


@Mapper(componentModel = "cdi")
public interface EmployeeMapper {
    EmployeeDto toEmployeeDto(Employee employee);
    Employee toEmployeeEntity(EmployeeDto employeeDto);
}
