package com.shaewest.worldquests.Extra;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Statistics {
  public static int getPlayerStatistic(Player player, String statisticEnum, String statisticTypeEnum) throws Exception{
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

  public static int getMultiplePlayerStatistics(Player player, ArrayList<String> statisticEnum, ArrayList<String> statisticTypeEnum){
    if(statisticTypeEnum.size() != statisticEnum.size()) return -1;
    int total = 0;
    for(int i = 0; i < statisticEnum.size(); i++){
      int stat;
      try {
        stat = getPlayerStatistic(player, statisticEnum.get(i), statisticTypeEnum.get(i));
        if(stat == -1) continue;
        total += stat;
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return total;
  }
}
