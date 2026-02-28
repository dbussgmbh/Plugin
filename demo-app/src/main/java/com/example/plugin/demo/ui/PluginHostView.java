package com.example.plugin.demo.ui;

import com.example.plugin.demo.runtime.PluginRegistry;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.*;

@Route(value = ":pluginId", layout = MainLayout.class)
@RouteAlias(value = ":pluginId/*", layout = MainLayout.class)
public class PluginHostView extends Div implements BeforeEnterObserver {
    private final PluginRegistry registry;
    public PluginHostView(PluginRegistry registry) { this.registry = registry; }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        removeAll();
        String pluginId = event.getRouteParameters().get("pluginId").orElse("");
        String fullPath = event.getLocation().getPath();
        String prefix = pluginId;
        String subPath = fullPath.length() > prefix.length() ? fullPath.substring(prefix.length()) : "";
        if (subPath.isEmpty()) subPath = "/";
        var queryParams = event.getLocation().getQueryParameters().getParameters();

        var plugin  = registry.find(pluginId);
        if (plugin .isEmpty()) { add(new H2("Not found")); add(new Paragraph("No plugin: " + pluginId)); return; }
        event.getUI().getPage().setTitle(plugin.get().pageTitle());
        Component view = plugin .get().createView(subPath, queryParams);
        add(view);
    }
}
