package vaadin.sample.module.webapp.ui.employee;

import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class EmployeeService {

    private final RestClient restClient;
    private static final String EMPLOYEES_API = "/employees";
    private static final String EMPLOYEE_API = "/employees/{id}";

    public EmployeeService(RestClient restClient) {
        this.restClient = restClient;
    }

    void delete(Long id) {
        this.restClient.delete().uri(EMPLOYEE_API, id).retrieve() .toBodilessEntity();
    }

    EmployeeDTO save(EmployeeDTO employeeDTO) {
        return this.restClient.post().uri(EMPLOYEES_API).body(employeeDTO).retrieve()
                .toEntity(EmployeeDTO.class).getBody();
    }

    EmployeeDTO findById(Long id) {
        return this.restClient.get().uri(EMPLOYEES_API).retrieve().toEntity(EmployeeDTO.class)
                .getBody();
    }

    List<EmployeeDTO> findAll() {
        ParameterizedTypeReference<List<EmployeeDTO>> responseType =
                new ParameterizedTypeReference<List<EmployeeDTO>>() {};
        return this.restClient.get().uri(EMPLOYEES_API).retrieve().toEntity(responseType).getBody();
    }
}
