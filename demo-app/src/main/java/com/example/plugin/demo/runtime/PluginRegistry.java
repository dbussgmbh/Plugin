package com.example.plugin.demo.runtime;

import com.example.core.plugin.PluginUi;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PluginRegistry {
    private final Map<String, PluginUi> plugins = new ConcurrentHashMap<>();

    public void put(PluginUi plugin) { plugins.put(plugin.id(), plugin); }
    public Optional<PluginUi> find(String id) { return Optional.ofNullable(plugins.get(id)); }

    public Collection<PluginUi> all() {
        return plugins.values().stream()
                .sorted(Comparator.comparing(PluginUi::menuLabel, String.CASE_INSENSITIVE_ORDER))
                .toList();
    }
}
