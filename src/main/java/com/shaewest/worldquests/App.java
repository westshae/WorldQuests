package com.shaewest.worldquests;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.plugin.java.JavaPlugin;

import com.shaewest.worldquests.Commands.WorldQuest.WorldQuest;
import com.shaewest.worldquests.Tasks.StatisticTask;
public class App extends JavaPlugin {
    @Override
    public void onEnable() {
        loadConfig();//Loads .yml

        //How to register commands
        this.getCommand("commandNameInYml").setExecutor(new WorldQuest()); 

        //How to register eventListeners
        //this.getServer().getPluginManager().registerEvents(new ObjectWith@EventHandlers(), this);

        //How to setup tasks
        new StatisticTask().runTaskTimer(this, 0, 18000);
    }

    public void loadConfig() {
        //Get potential config file
        File configFile = new File(getDataFolder(), "config.yml");

        if(!configFile.exists()){
            ArrayList<String> stoneDirtList = new ArrayList<>();
            stoneDirtList.add("GRASS");
            stoneDirtList.add("DIRT");
            ArrayList<String> stoneList = new ArrayList<>();
            stoneDirtList.add("STONE");
            getConfig().addDefault("exampleQuest.questDescription", "Complete mining 10000 dirt blocks and stone blocks");
            getConfig().addDefault("exampleQuest.priceDescription", "$100000");
            getConfig().addDefault("exampleQuest.statistics.mine_dirt.types", stoneDirtList);
            getConfig().addDefault("exampleQuest.statistics.mine_dirt.enum", "MINE_BLOCK");
            getConfig().addDefault("exampleQuest.statistics.mine_dirt.goal", 10000);
            getConfig().addDefault("exampleQuest.statistics.mine_dirt.types", stoneList);
            getConfig().addDefault("exampleQuest.statistics.mine_dirt.enum", "MINE_BLOCK");
            getConfig().addDefault("exampleQuest.statistics.mine_dirt.goal", 10000);
            getConfig().addDefault("exampleQuest.forWorld", true);
            getConfig().addDefault("exampleQuest.forNations", false);
            getConfig().addDefault("exampleQuest.forTowns", false);
            getConfig().addDefault("exampleQuest.forIndividuals", false);
            getConfig().addDefault("exampleQuest.commandToRun", "/eco give {player} 100000");
            getConfig().addDefault("exampleQuest.active", "false");

        }

        //Load config
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}