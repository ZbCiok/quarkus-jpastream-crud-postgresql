package zjc.examples.quarkus.panacheRepo.mapper;


import org.mapstruct.Mapper;
import zjc.examples.quarkus.panacheRepo.dto.DepartmentDto;
import zjc.examples.quarkus.panacheRepo.entity.Department;

@Mapper(componentModel = "cdi")
public interface DepartmentMapper {
    DepartmentDto toDepartmentDto(Department department);
    Department toDepartmentEntity(DepartmentDto departmentDto);
}
