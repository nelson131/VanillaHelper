package me.nelson131.vanillahelper;

import me.nelson131.vanillahelper.commands.AdminCMDs;
import me.nelson131.vanillahelper.commands.Ping;
import me.nelson131.vanillahelper.commands.Status;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class VanillaHelper extends JavaPlugin {
    Logger log = getLogger();


    @Override
    public void onEnable() {
        log.info("Enabled VanillaHelper");
        getCommand("ping").setExecutor(new Ping());
        getCommand("plstatus").setExecutor(new Status());
        getCommand("admin").setExecutor(new AdminCMDs());
    }

    @Override
    public void onDisable() {
        log.info("Disabled VanillaHelper");

    }
}
