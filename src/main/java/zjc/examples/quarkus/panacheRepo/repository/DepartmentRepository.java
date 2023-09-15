package zjc.examples.quarkus.panacheRepo.repository;

import zjc.examples.quarkus.panacheRepo.dto.DepartmentDto;
import zjc.examples.quarkus.panacheRepo.entity.Department;

import java.util.List;

public interface DepartmentRepository {

    public List<DepartmentDto> getAll();

    public DepartmentDto getById(final Long id);

    //public EmployeeDetailsDto getEmplyeeById(final Long id);

// -------------------------------------------------------------------


    //boolean deleteMemberById(Long id);

    void save(Department department);

    //void updateNameFrom(Long id);
}
