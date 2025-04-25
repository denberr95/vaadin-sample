package vaadin.sample.module.webapp.ui;

import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "", layout = HomeLayout.class)
@RouteAlias(value = "main")
@RouteAlias(value = "home")
@PageTitle(value = "Home Page")
public class HomeView extends Main {

    public HomeView() {
        this.setText("This is the Home Page !!");
    }
}
