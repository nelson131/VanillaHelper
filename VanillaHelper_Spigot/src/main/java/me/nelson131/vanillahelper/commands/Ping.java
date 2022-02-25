package me.nelson131.vanillahelper.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Ping implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            System.out.println("Command cant be activated by console");
            return false;
        }
        if (command.getName().equalsIgnoreCase("ping")) {
                Player player = (Player) sender;
                String prefix = ChatColor.YELLOW + "Your ping:" + ChatColor.RESET;
                sender.sendMessage(prefix + "" + ChatColor.WHITE + player.getPing() + "ms" );
                return true;
        }
        return true;
    }
}
