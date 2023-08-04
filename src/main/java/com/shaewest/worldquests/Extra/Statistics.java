package com.shaewest.worldquests.Extra;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;

public class Statistics {
  public static Profile getPlayerStatisticProfile(OfflinePlayer player, String statisticEnum, String statisticTypeEnum){
    Material material = Material.getMaterial(statisticTypeEnum);
    EntityType entity = EntityType.valueOf(statisticTypeEnum);
    Statistic stat = Statistic.valueOf(statisticEnum);

    if(!material.equals(null)){
      return new Profile(player, player.getStatistic(stat, material));
    } else if(!entity.equals(null)){
      return new Profile(player, player.getStatistic(stat, entity));
    } else if(!stat.equals(null)){
      return new Profile(player, player.getStatistic(stat));
    } else{
      return null;
    }
  }

  public static int getPlayerStatisticInt(OfflinePlayer player, String statisticEnum, String statisticTypeEnum) throws Exception{
    Material material = Material.getMaterial(statisticTypeEnum);
    EntityType entity = EntityType.valueOf(statisticTypeEnum);
    Statistic stat = Statistic.valueOf(statisticEnum);

    if(!material.equals(null)){
      return player.getStatistic(stat, material);
    } else if(!entity.equals(null)){
      return player.getStatistic(stat, entity);
    } else if(!stat.equals(null)){
      return player.getStatistic(stat);
    } else{
      return -1;
    }
  }


  public static Profile getMultiplePlayerStatistics(OfflinePlayer player, ArrayList<String> statisticEnum, ArrayList<String> statisticTypeEnum){
    if(statisticTypeEnum.size() != statisticEnum.size()) return null;
    int stat = 0;
    for(int i = 0; i < statisticEnum.size(); i++){
      try {
        int currentStat = getPlayerStatisticInt(player, statisticEnum.get(i), statisticTypeEnum.get(i));
        if(currentStat == -1) continue;
        stat += currentStat;
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return new Profile(player, stat);
  }
}
