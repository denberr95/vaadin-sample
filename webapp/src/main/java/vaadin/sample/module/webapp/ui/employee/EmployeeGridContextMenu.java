package vaadin.sample.module.webapp.ui.employee;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.contextmenu.GridContextMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeGridContextMenu extends GridContextMenu<EmployeeDTO> {

    private final Logger logger = LoggerFactory.getLogger(EmployeeGridContextMenu.class);

    public EmployeeGridContextMenu(Grid<EmployeeDTO> target, EmployeeService employeeService) {
        super(target);

        this.addItem("Delete", e -> e.getItem().ifPresent(item -> {
            this.logger.info("Deleting employee: '{}'", item.toString());
            employeeService.delete(item.getId());
        }));
    }
}
