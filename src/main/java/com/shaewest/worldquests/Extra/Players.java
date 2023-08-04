package com.shaewest.worldquests.Extra;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

public class Players {
  public static List<OfflinePlayer> getWorldPlayers(){
    return getAllOfflinePlayers();
  }

  public static ArrayList<OfflinePlayer> getNationPlayers(String nationName){
    return null;
  }

  public static ArrayList<OfflinePlayer> getTownPlayers(String townName){
    return null;
  }

  public static List<OfflinePlayer> getAllOfflinePlayers() {
    List<OfflinePlayer> players = new ArrayList<>();

    File worldFolder = new File(Bukkit.getWorlds().get(0).getWorldFolder(), "playerdata");

    if (worldFolder.exists() && worldFolder.isDirectory()) {
        File[] playerDataFiles = worldFolder.listFiles();

        if (playerDataFiles != null) {
            for (File playerDataFile : playerDataFiles) {
                String fileName = playerDataFile.getName();
                UUID uuid;
                try {
                    uuid = UUID.fromString(fileName.replace(".dat", ""));
                    players.add(Bukkit.getOfflinePlayer(uuid));
                } catch (IllegalArgumentException ignored) {
                }
            }
        }
    }
    return players;
}
}
