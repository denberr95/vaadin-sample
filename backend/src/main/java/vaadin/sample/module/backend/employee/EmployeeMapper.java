package vaadin.sample.module.backend.employee;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vaadin.sample.module.backend.config.ICustomMapperConfig;

@Mapper(config = ICustomMapperConfig.class)
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDTO toDto(EmployeeEntity employee);

    EmployeeEntity toEntity(EmployeeDTO dto);

    List<EmployeeDTO> toDtoList(List<EmployeeEntity> employees);

    List<EmployeeEntity> toEntityList(List<EmployeeDTO> dtos);
}
