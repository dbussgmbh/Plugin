package com.example.core.plugin;

import com.vaadin.flow.component.Component;
import java.util.List;
import java.util.Map;

/** API shim for standalone plugin development. Keep compatible with host. */
public interface PluginUi {
    String id();
    String menuLabel();
    Component createView(String subPath, Map<String, List<String>> queryParams);

    default String pageTitle() {
        return menuLabel();   // Fallback
    }
}
