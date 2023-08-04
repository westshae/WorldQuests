package com.shaewest.worldquests.Commands.WorldQuest;

import java.util.ArrayList;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.shaewest.worldquests.Util.Messages;

import net.md_5.bungee.api.ChatColor;

public class WorldQuest implements CommandExecutor {
  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (!command.getName().equalsIgnoreCase("worldquest")) return true;
    if (!sender.hasPermission("worldquest.list")) {
      Messages.sendErrorMessage((Player) sender, label);
      return true;
    }

    Player player = (Player) sender;

    if(args[0].toLowerCase().equals("list")){
      handleList(player);
      return true;
    } else {
      String questName = args[0].toLowerCase();
      handleQuest(player, questName);  
    }

    return true;
  }

  private void handleList(Player player){
    FileConfiguration config = Bukkit.getServer().getPluginManager().getPlugin("worldquests").getConfig();

    ConfigurationSection questSection = config.getConfigurationSection("");
    if (questSection == null) {
        player.sendMessage(ChatColor.RED + "No quests found in the configuration.");
        return;
    }

    Set<String> questKeys = questSection.getKeys(false);
    if (questKeys.isEmpty()) {
        player.sendMessage(ChatColor.RED + "No quests found in the configuration.");
        return;
    }

    player.sendMessage("" + ChatColor.GREEN + "==========WORLD=QUESTS==========");
    for (String questName : questKeys) {
        player.sendMessage("" + ChatColor.GREEN + "----------" + questName + "----------");
    }
    player.sendMessage("" + ChatColor.GREEN + "================================");  }

  private void handleQuest(Player player, String questName){
    
  }
}
