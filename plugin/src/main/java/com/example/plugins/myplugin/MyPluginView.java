package com.example.plugins.myplugin;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;

import java.util.List;
import java.util.Map;

/** ✅ Implement your UI here. */
public class MyPluginView extends Div {
    public MyPluginView(String id, String menu, String subPath, Map<String, List<String>> queryParams) {
        setWidthFull();
        getStyle().set("padding", "var(--lumo-space-m)");
        add(new H2(menu));
        add(new Paragraph("Plugin-ID: " + id));
        add(new Paragraph("subPath: " + subPath));
        add(new Paragraph("queryParams: " + queryParams));
        add(new Paragraph("Replace this view with your UI (Grid, CKEditor, ...)."));
    }
}
