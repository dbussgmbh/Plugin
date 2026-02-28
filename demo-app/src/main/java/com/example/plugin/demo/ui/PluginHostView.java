package com.example.plugin.demo.ui;

import com.example.plugin.demo.runtime.PluginRegistry;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.*;

@Route(value = "p/:pluginId", layout = MainLayout.class)
@RouteAlias(value = "p/:pluginId/*", layout = MainLayout.class)
@PageTitle("Plugin")
public class PluginHostView extends Div implements BeforeEnterObserver {
    private final PluginRegistry registry;
    public PluginHostView(PluginRegistry registry) { this.registry = registry; }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        removeAll();
        String pluginId = event.getRouteParameters().get("pluginId").orElse("");
        String fullPath = event.getLocation().getPath();
        String prefix = "p/" + pluginId;
        String subPath = fullPath.length() > prefix.length() ? fullPath.substring(prefix.length()) : "";
        if (subPath.isEmpty()) subPath = "/";
        var queryParams = event.getLocation().getQueryParameters().getParameters();

        var opt = registry.find(pluginId);
        if (opt.isEmpty()) { add(new H2("Not found")); add(new Paragraph("No plugin: " + pluginId)); return; }
        Component view = opt.get().createView(subPath, queryParams);
        add(view);
    }
}
