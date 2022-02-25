package me.nelson131.vanillahelper.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminCMDs implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String pref = ChatColor.RED + "[VanillaHelper]" + " ";
        String noOp = pref + ChatColor.WHITE + "You have not permissions to use this command!";
        if(!(sender instanceof Player)){
            System.out.println("Command cant be activated by console!");
            return false;
        }
        if(command.getName().equalsIgnoreCase("admin") && sender.isOp()) {
            switch (args[0]){
                case "help":
                    if(sender.isOp()) {
                        sender.sendMessage(ChatColor.RED + "|---------------------------------------|");
                        sender.sendMessage(ChatColor.WHITE + "VanillaHelper admins commands:");
                        sender.sendMessage(ChatColor.WHITE + "/admin restart - to restart server");
                        sender.sendMessage(ChatColor.WHITE + "/admin clearchat - to clear chat");
                        sender.sendMessage(ChatColor.RED + "|---------------------------------------|");
                        return true;
                    }
                case "clearchat":
                    if(sender.isOp()) {
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            for(int i = 0; i < 100; i++){
                                player.sendMessage("");
                                Bukkit.broadcastMessage(" ");
                            }
                            Bukkit.broadcastMessage(pref + ChatColor.WHITE + "Chat was cleared");
                            return true;
                        }
                    }
                case "restart":
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        Bukkit.broadcastMessage(pref + ChatColor.WHITE + "[RESTART IN NEXT 10 SEC!]");
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Bukkit.spigot().restart();
                        return true;
                    }


                }
            }
        else
        {
            sender.sendMessage(noOp);
            return false;
        }
        return true;



    }
}
