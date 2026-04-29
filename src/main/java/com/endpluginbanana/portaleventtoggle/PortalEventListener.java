package com.endpluginbanana.portaleventtoggle;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCreatePortalEvent;

public final class PortalEventListener implements Listener {

    private final PortalEventTogglePlugin plugin;

    public PortalEventListener(PortalEventTogglePlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onEntityCreatePortal(EntityCreatePortalEvent event) {
        if (plugin.shouldBlockEntityCreatePortalEvent()) {
            event.setCancelled(true);
        }
    }
}
