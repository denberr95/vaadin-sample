package vaadin.sample.module.webapp.ui.employee;

import java.util.List;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import vaadin.sample.module.webapp.ui.layout.HomeLayout;
import vaadin.sample.module.webapp.util.CSSClassName;


@Route(value = "employees", layout = HomeLayout.class)
@PageTitle(value = "Employees")
public class EmployeeView extends VerticalLayout {

    private final EmployeeService employeeService;
    private Grid<EmployeeDTO> grid = new Grid<>(EmployeeDTO.class, false);
    private HorizontalLayout buttonLayout = new HorizontalLayout();
    private Button loadDataButton = new Button("Load Data");

    public EmployeeView(EmployeeService employeeService) {
        this.employeeService = employeeService;

        this.addClassName(CSSClassName.EMPLOYEES_VIEW_CLASS_NAME);

        this.configureGrid();
        this.add(this.grid);

        this.configureLoadDataButton();
        this.add(this.loadDataButton);
    }

    private void configureGrid() {
        this.grid.addClassName(CSSClassName.EMPLOYEES_GRID_CLASS_NAME);
        this.grid.addColumn(EmployeeDTO::getId).setHeader(EmployeeDTO.ID);
        this.grid.addColumn(EmployeeDTO::getName).setHeader(EmployeeDTO.NAME);
        this.grid.addColumn(EmployeeDTO::getAge).setHeader(EmployeeDTO.AGE);
        this.grid.addColumn(EmployeeDTO::getDepartment).setHeader(EmployeeDTO.DEPARTMENT);
        this.grid.addColumn(EmployeeDTO::getSalary).setHeader(EmployeeDTO.SALARY);
        this.grid.setAllRowsVisible(true);
        this.grid.getColumns().forEach(c -> {
            c.setAutoWidth(true);
            c.setTextAlign(ColumnTextAlign.CENTER);
        });
        EmployeeGridContextMenu contextMenu =
                new EmployeeGridContextMenu(this.grid, this.employeeService);
        this.grid.addThemeVariants(GridVariant.LUMO_COMPACT, GridVariant.LUMO_COLUMN_BORDERS,
                GridVariant.LUMO_ROW_STRIPES);
        this.updateGridData();
    }

    private void configureLoadDataButton() {
        this.buttonLayout.setClassName(CSSClassName.EMPLOYEES_BUTTON_LAYOUT_CLASS_NAME);

        this.loadDataButton.setDisableOnClick(true);
        this.loadDataButton.addClickListener(clickEvent -> {
            this.updateGridData();
            this.loadDataButton.setEnabled(true);
        });
        this.buttonLayout.add(this.loadDataButton);
    }

    private void updateGridData() {
        List<EmployeeDTO> data = this.employeeService.findAll();
        if (data != null && !data.isEmpty()) {
            this.grid.setItems(data);
        } else {
            this.grid.setEmptyStateText("No data retrieved...");
        }
    }
}
