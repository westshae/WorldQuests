package com.shaewest.worldquests.Commands.WorldQuest;

import java.util.ArrayList;
import java.util.List;
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
    if (!command.getName().equalsIgnoreCase("worldquest"))
      return true;
    if (!sender.hasPermission("worldquest.list")) {
      Messages.sendErrorMessage((Player) sender, label);
      return true;
    }

    Player player = (Player) sender;

    if (args[0].toLowerCase().equals("list")) {
      handleList(player);
      return true;
    } else {
      String questName = args[0];
      handleQuest(player, questName);
    }

    return true;
  }

  private void handleList(Player player) {
    FileConfiguration config = Bukkit.getServer().getPluginManager().getPlugin("worldquests").getConfig();

    ConfigurationSection questSection = config.getConfigurationSection("");
    Set<String> questKeys = questSection.getKeys(false);

    player.sendMessage("" + ChatColor.GREEN + "==========WORLD=QUESTS==========");
    for (String questName : questKeys) {
      player.sendMessage("" + ChatColor.GREEN + "----------" + questName + "----------");
    }
    player.sendMessage("" + ChatColor.GREEN + "================================");
  }

  private void handleQuest(Player player, String questName) {
    FileConfiguration config = Bukkit.getServer().getPluginManager().getPlugin("worldquests").getConfig();
    ConfigurationSection questSection = config.getConfigurationSection("" + questName);

    String questDescription = questSection.getString("questDescription");
    String priceDescription = questSection.getString("priceDescription");
    boolean completed = questSection.getBoolean("completed");
    boolean active = questSection.getBoolean("active");

    String activeString = "";
    if(active){
      activeString = "" + ChatColor.DARK_GREEN + " ACTIVE";
    }else {
      activeString = "" + ChatColor.DARK_RED + " INACTIVE";
    }

    String completedString = "";
    if(completed){
      completedString = "" + ChatColor.DARK_GREEN + " COMPLETED";
    }else {
      completedString = "" + ChatColor.DARK_RED + " INCOMPLETE";
    }


    String groupFor = "";
    if (questSection.getBoolean("forWorld")) {
      groupFor = "World-Quest";
    } else if (questSection.getBoolean("forNations")) {
      groupFor = "Nation-Quest";
    } else if (questSection.getBoolean("forTowns")) {
      groupFor = "Town-Quest";
    } else if (questSection.getBoolean("forIndividuals")) {
      groupFor = "Individuals-Quest";
    }

    ArrayList<String> statStrings = new ArrayList<>();
    ConfigurationSection statsSection = questSection.getConfigurationSection("statistics");

    if (statsSection != null) {
      for (String statsKey : statsSection.getKeys(false)) {
        List<String> types = statsSection.getStringList(statsKey + ".types");
        String description = statsSection.getString(statsKey + ".description");
        int goal = statsSection.getInt(statsKey + ".goal");
        int progress = statsSection.getInt(statsKey + ".progress");

        String statHeader = ChatColor.GREEN +"Name:" +  statsKey;
        String statDescription = ChatColor.GREEN +"Type: " + description;
        String statBlocks = "" + ChatColor.GREEN + "Blocks: ";
        for(String type : types){
          statBlocks += type;
          statBlocks += " ";
        }
        String statProgress = ChatColor.GREEN +"Progress/Goal: " + progress + "/" + goal;
        statStrings.add("");
        statStrings.add(statHeader);
        statStrings.add(statDescription);
        statStrings.add(statBlocks);
        statStrings.add(statProgress);
      }
    }

    player.sendMessage("" + ChatColor.GREEN + "==========WORLD=QUESTS==========");
    player.sendMessage("" + ChatColor.GREEN + "Name: " + questName + activeString + completedString);
    player.sendMessage("" + ChatColor.GREEN + "Description: " + questDescription);
    player.sendMessage("" + ChatColor.GREEN + "Prize: " + priceDescription);
    player.sendMessage("" + ChatColor.GREEN + "Targets: " + groupFor);
    for(String statString : statStrings){
      player.sendMessage(statString);
    }
    player.sendMessage("" + ChatColor.GREEN + "================================");

  }
}
