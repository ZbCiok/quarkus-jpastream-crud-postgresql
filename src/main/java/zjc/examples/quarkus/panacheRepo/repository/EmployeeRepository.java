package zjc.examples.quarkus.panacheRepo.repository;

import zjc.examples.quarkus.panacheRepo.dto.EmployeeDto;
import zjc.examples.quarkus.panacheRepo.entity.Employee;
import java.util.List;

public interface EmployeeRepository {

    public List<EmployeeDto> getAll();

    public EmployeeDto getById(final Long id);

    //public EmployeeDetailsDto getEmplyeeById(final Long id);

// -------------------------------------------------------------------


    //boolean deleteMemberById(Long id);

    void save(Employee emp);

    //void updateNameFrom(Long id);
}
