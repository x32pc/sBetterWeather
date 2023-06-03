package com.x32pc.github;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.Plugin;

public class Main extends JavaPlugin {

    public Weather weather;
    FileConfiguration config = getConfig();
    int time = config.getInt("time.time");;
    boolean thundering = config.getBoolean("weather.thundering");;
    boolean storm = config.getBoolean("weather.storm");;
    boolean do_light_cycle = config.getBoolean("do_daylight_cycle.enabled");;
    boolean changeWeather = config.getBoolean("weather.change");;
    public static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        weather = new Weather(this);
        saveDefaultConfig();
        weather.setWeather(thundering, storm, do_light_cycle, time);
        getServer().getPluginManager().registerEvents(new Weather(this), this);
    }
}
