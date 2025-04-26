package vaadin.sample.module.backend.employee;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SourceType;
import org.hibernate.generator.EventType;
import vaadin.sample.module.backend.util.Constants;

@Entity
@DynamicInsert
@DynamicUpdate
@EntityListeners(value = EmployeeEntityListener.class)
@Table(name = EmployeeEntity.TABLE_NAME, schema = Constants.DB_SCHEMA_APP)
public class EmployeeEntity {

    protected static final String TABLE_NAME = "employees";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @CurrentTimestamp(source = SourceType.DB, event = EventType.INSERT)
    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @CurrentTimestamp(source = SourceType.VM, event = EventType.UPDATE)
    @Column(nullable = true)
    private OffsetDateTime updatedAt;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false, length = 50)
    private String department;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal salary;

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

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
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

    public static String getTableName() {
        return TABLE_NAME;
    }

    public OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "EmployeeEntity [id=" + this.id + ", createdAt=" + this.createdAt + ", updatedAt="
                + this.updatedAt + ", name=" + this.name + ", age=" + this.age + ", department="
                + this.department + ", salary=" + this.salary + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.createdAt, this.updatedAt, this.name, this.age, this.department, this.salary);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        EmployeeEntity other = (EmployeeEntity) obj;
        return Objects.equals(this.id, other.id) && Objects.equals(this.createdAt, other.createdAt)
                && Objects.equals(this.updatedAt, other.updatedAt) && Objects.equals(this.name, other.name)
                && this.age == other.age && Objects.equals(this.department, other.department)
                && Objects.equals(this.salary, other.salary);
    }
}
