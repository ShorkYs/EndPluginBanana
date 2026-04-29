package com.endpluginbanana.portaleventtoggle;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class PortalEventTogglePlugin extends JavaPlugin {

    private boolean blockEntityCreatePortalEvent = true;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PortalEventListener(this), this);
        getLogger().info("PortalEventToggle enabled. Blocking EntityCreatePortalEvent: " + blockEntityCreatePortalEvent);
    }

    public boolean shouldBlockEntityCreatePortalEvent() {
        return blockEntityCreatePortalEvent;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!command.getName().equalsIgnoreCase("toggleportalcreate")) {
            return false;
        }

        blockEntityCreatePortalEvent = !blockEntityCreatePortalEvent;
        String state = blockEntityCreatePortalEvent ? "ON" : "OFF";
        sender.sendMessage("EntityCreatePortalEvent blocking is now " + state + ".");
        return true;
    }
}
