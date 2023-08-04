package com.shaewest.worldquests.Commands.WorldQuest;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.shaewest.worldquests.Util.Messages;

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

  }

  private void handleQuest(Player player, String questName){
    
  }
}
