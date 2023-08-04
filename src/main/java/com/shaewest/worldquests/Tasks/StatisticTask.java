package com.shaewest.worldquests.Tasks;

import org.bukkit.scheduler.BukkitRunnable;

public class StatisticTask extends BukkitRunnable {

  @Override
  public void run() {
    // removeChunks();
    // handleEffects();
  }

  // private void removeChunks() {
  //   FileConfiguration config = Bukkit.getServer().getPluginManager().getPlugin("wareffects").getConfig();

  //   ConfigurationSection chunksSection = config.getConfigurationSection("gas.chunks");

  //   if (chunksSection != null) {
  //     for (String chunkKey : chunksSection.getKeys(false)) {
  //       Integer lives = config.getInt("gas.chunks." + chunkKey + ".lives");

  //       if (lives == 0) {
  //         config.set("gas.chunks." + chunkKey, null);
  //       } else {
  //         lives -= 1;
  //         config.set("gas.chunks." + chunkKey + ".lives", lives);
  //       }
  //     }
  //   }

  //   Plugin wareffectsPlugin = Bukkit.getServer().getPluginManager().getPlugin("wareffects");
  //   if (wareffectsPlugin != null) {
  //     wareffectsPlugin.saveConfig();
  //   }
  // }

  // private void handleEffects() {
  //   FileConfiguration config = Bukkit.getServer().getPluginManager().getPlugin("wareffects").getConfig();

  //   ConfigurationSection chunksSection = config.getConfigurationSection("gas.chunks");

  //   List<String> coordinatesList = new ArrayList<>();

  //   if (chunksSection != null) {
  //     for (String chunkKey : chunksSection.getKeys(false)) {
  //       String[] coordinates = chunkKey.split(":");
  //       if (coordinates.length == 2) {
  //         String coordinateString = coordinates[0] + ":" + coordinates[1];
  //         coordinatesList.add(coordinateString);
  //       }
  //     }
  //   }
  //   ArrayList<Entity> entities = new ArrayList<>();

  //   for (String coordinate : coordinatesList) {

  //     String[] split = coordinate.split(":");
  //     int x = Integer.parseInt(split[0]);
  //     int y = Integer.parseInt(split[1]);

  //     Chunk chunk = Bukkit.getServer().getWorld("world").getChunkAt(x, y);

  //     if (!chunk.isLoaded())
  //       continue;

  //     entities.addAll(Arrays.asList(chunk.getEntities()));

  //     chunkParticles(chunk);

  //   }

  //   ArrayList<Player> players = new ArrayList<>();
  //   for (Entity entity : entities) {
  //     if (entity instanceof Player) {
  //       players.add((Player) entity);
  //     }
  //   }

  //   for (Player player : players) {
  //     CustomEffects.handleGas(player);
  //   }

  // }

}
