package vaadin.sample.module.backend.employee;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    List<EmployeeDTO> findAll() {
        return this.employeeMapper.toDtoList(this.employeeRepository.findAll());
    }

    EmployeeDTO findById(Long id) {
        return this.employeeMapper.toDto(this.employeeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Employee not found with id: " + id)));
    }

    EmployeeDTO save(EmployeeDTO employeeDTO) {
        EmployeeEntity saved =
                this.employeeRepository.save(this.employeeMapper.toEntity(employeeDTO));
        return this.employeeMapper.toDto(saved);
    }

    void delete(Long id) {
        this.employeeRepository.deleteById(id);
    }
}
