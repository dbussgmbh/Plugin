package com.example.plugin.demo.ui;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainLayout.class)
@PageTitle("Home")
public class HomeView extends Div {
    public HomeView() {
        add(new H2("Home"));
        add(new Paragraph("1) Edit plugin/application.properties: plugin.id + plugin.menu.name"));
        add(new Paragraph("2) Edit MyPluginView.java: your UI"));
        add(new Paragraph("3) Optional: plugin/pom.xml artifactId"));
        add(new Paragraph("Open /p/<plugin.id>"));
    }
}
