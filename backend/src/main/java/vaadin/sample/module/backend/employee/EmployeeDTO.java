package vaadin.sample.module.backend.employee;

import java.math.BigDecimal;

public record EmployeeDTO(Long id, String name, Integer age, String department, BigDecimal salary) {
}
