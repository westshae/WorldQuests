package com.shaewest.worldquests.Extra;

import org.bukkit.OfflinePlayer;

public class Profile {
  private OfflinePlayer offlinePlayer;
  private int statistic;

  public Profile(OfflinePlayer offlinePlayer, int statistic){
    this.offlinePlayer = offlinePlayer;
    this.statistic = statistic;
  }

  public OfflinePlayer getOfflinePlayer(){
    return this.offlinePlayer;
  }

  public int getStatistic(){
    return this.statistic;
  }

  public void setStatistic(int statistic){
    this.statistic = statistic;
  }
}
