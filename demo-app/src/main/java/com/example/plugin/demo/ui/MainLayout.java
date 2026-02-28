package com.example.plugin.demo.ui;

import com.example.core.plugin.PluginUi;
import com.example.plugin.demo.runtime.PluginRegistry;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class MainLayout extends AppLayout {
    public MainLayout(PluginRegistry registry) {
        setPrimarySection(Section.DRAWER);

        var title = new H1("Plugin Template - Standalone Runner");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)").set("margin", "0");

        var header = new HorizontalLayout(new DrawerToggle(), title);
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.setWidthFull();
        header.getStyle().set("padding", "var(--lumo-space-m)");
        addToNavbar(header);

        var nav = new SideNav();
        nav.addItem(new SideNavItem("Home", HomeView.class));
        for (PluginUi p : registry.all()) nav.addItem(new SideNavItem(p.menuLabel(), "p/" + p.id()));
        addToDrawer(nav);
    }
}
