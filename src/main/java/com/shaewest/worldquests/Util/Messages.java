package com.shaewest.worldquests.Util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Messages {
  public static void sendErrorMessage(Player player, String message){
    player.sendMessage("" + ChatColor.RED + message);
  }
}
