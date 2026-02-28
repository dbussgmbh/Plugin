package com.example.plugins.myplugin;

import com.example.core.plugin.PluginUi;
import com.vaadin.flow.component.Component;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/** Entry point. Usually you don't edit this class. */
public class MyPlugin implements PluginUi {
    private final String id;
    private final String menu;
    private final String pageTitle;

    public MyPlugin() {
        Properties p = load("plugin/application.properties");
        this.id = p.getProperty("plugin.id", "myplugin").trim();
        this.menu = p.getProperty("plugin.menu.name", "My Plugin").trim();
        this.pageTitle = p.getProperty("plugin.page.title", "No Title").trim();
    }

    @Override public String id() { return id; }
    @Override public String menuLabel() { return menu; }
    @Override public String pageTitle() { return pageTitle; }

    @Override
    public Component createView(String subPath, Map<String, List<String>> queryParams) {
        return new MyPluginView(id, menu, subPath, queryParams);
    }

    private static Properties load(String resource) {
        Properties p = new Properties();
        try (InputStream in = MyPlugin.class.getClassLoader().getResourceAsStream(resource)) {
            if (in != null) p.load(in);
        } catch (Exception ignored) {}
        return p;
    }
}
