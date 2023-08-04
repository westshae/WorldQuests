package com.shaewest.worldquests;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.shaewest.worldquests.Commands.WorldQuest.WorldQuest;
import com.shaewest.worldquests.Tasks.StatisticTask;
public class App extends JavaPlugin {
    @Override
    public void onEnable() {
        loadConfig();

        //How to register commands
        this.getCommand("worldquest").setExecutor(new WorldQuest()); 

        //How to setup tasks
        FileConfiguration config = getConfig();

        int minutes = config.getInt("minutesPerCheck");

        new StatisticTask().runTaskTimer(this, 0, 20 * 60 * minutes);
    }

    public void loadConfig() {
        //Get potential config file
        File configFile = new File(getDataFolder(), "config.yml");

        if(!configFile.exists()){
            List<String> stoneDirtList = new ArrayList<>();
            stoneDirtList.add("GRASS");
            stoneDirtList.add("DIRT");
            List<String> stoneList = new ArrayList<>();
            stoneList.add("STONE");
            getConfig().addDefault("minutesPerCheck", 15);
            getConfig().addDefault("exampleQuest.questDescription", "Complete mining 10000 dirt blocks and stone blocks");
            getConfig().addDefault("exampleQuest.priceDescription", "$100000");
            getConfig().addDefault("exampleQuest.statistics.mine_dirt.types", stoneDirtList);
            getConfig().addDefault("exampleQuest.statistics.mine_dirt.enum", "MINE_BLOCK");
            getConfig().addDefault("exampleQuest.statistics.mine_dirt.goal", 10000);
            getConfig().addDefault("exampleQuest.statistics.mine_dirt.progress", 0);
            getConfig().addDefault("exampleQuest.statistics.mine_dirt.description", "Mine dirt and grass blocks");
            getConfig().addDefault("exampleQuest.statistics.mine_stone.types", stoneList);
            getConfig().addDefault("exampleQuest.statistics.mine_stone.enum", "MINE_BLOCK");
            getConfig().addDefault("exampleQuest.statistics.mine_stone.goal", 10000);
            getConfig().addDefault("exampleQuest.statistics.mine_stone.progress", 0);
            getConfig().addDefault("exampleQuest.statistics.mine_stone.description", "Mine stone");
            getConfig().addDefault("exampleQuest.forWorld", true);
            getConfig().addDefault("exampleQuest.forNations", false);
            getConfig().addDefault("exampleQuest.forTowns", false);
            getConfig().addDefault("exampleQuest.forIndividuals", false);
            getConfig().addDefault("exampleQuest.commandToRun", "/eco give {player} 100000");
            getConfig().addDefault("exampleQuest.singleRunCommand", false);
            getConfig().addDefault("exampleQuest.active", false);
            getConfig().addDefault("exampleQuest.completed", false);
        }

        //Load config
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}