package vaadin.sample.module.backend.employee;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record EmployeeDTO(Long id, OffsetDateTime createdAt, OffsetDateTime updatedAt, String name,
        Integer age, String department, BigDecimal salary) {
}
