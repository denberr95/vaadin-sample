package vaadin.sample.module.webapp.ui.layout;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.Layout;
import com.vaadin.flow.theme.lumo.LumoUtility;

@Layout
public class HomeLayout extends AppLayout {

    public HomeLayout() {
        DrawerToggle toggle = new DrawerToggle();
        H1 title = this.getNavBarTitle();
        SideNav nav = this.getSideNav();
        Scroller scroller = new Scroller(nav);
        scroller.setClassName(LumoUtility.Padding.SMALL);

        this.addToDrawer(scroller);
        this.addToNavbar(toggle, title);
        this.setPrimarySection(Section.DRAWER);
    }

    private H1 getNavBarTitle() {
        H1 title = new H1("Vaadin Sample");
        return title;
    }

    private SideNav getSideNav() {
        SideNav sideNav = new SideNav();
        sideNav.setLabel("Menù");
        sideNav.addItem(new SideNavItem("Home", "/home", VaadinIcon.HOME.create()));
        sideNav.addItem(new SideNavItem("Employees", "/employees", VaadinIcon.USER_HEART.create()));
        return sideNav;
    }
}
