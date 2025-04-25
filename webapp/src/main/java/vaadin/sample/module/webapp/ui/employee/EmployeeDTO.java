package vaadin.sample.module.webapp.ui.employee;

import java.math.BigDecimal;
import java.util.Objects;
import jakarta.annotation.Nonnull;

public class EmployeeDTO {

    @Nonnull
    private Long id;

    @Nonnull
    private String name;

    @Nonnull
    private Integer age;

    @Nonnull
    private String department;

    @Nonnull
    private BigDecimal salary;

    public static final String ID = "ID";
    public static final String NAME = "Name";
    public static final String AGE = "Age";
    public static final String DEPARTMENT = "Department";
    public static final String SALARY = "Salary";

    public EmployeeDTO() {}

    public EmployeeDTO(Long id, String name, Integer age, String department, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeDTO [id=" + this.id + ", name=" + this.name + ", age=" + this.age
                + ", department=" + this.department + ", salary=" + this.salary + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.age, this.department, this.salary);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        EmployeeDTO other = (EmployeeDTO) obj;
        return Objects.equals(this.id, other.id) && Objects.equals(this.name, other.name)
                && Objects.equals(this.age, other.age)
                && Objects.equals(this.department, other.department)
                && Objects.equals(this.salary, other.salary);
    }
}
