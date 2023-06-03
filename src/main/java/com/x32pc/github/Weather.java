package com.x32pc.github;

import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class Weather implements Listener {

    private final Main mainMain;

    public Weather(Main main) {
        this.mainMain = main;
    }

    public void setWeather(boolean a, boolean b, boolean c, int time) {
        for (World world : Bukkit.getWorlds()) {
            world.setThundering(a);
            world.setTime(time);
            world.setStorm(b);
            world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, c);
        }
    }

    @EventHandler
    public void changeWeather(WeatherChangeEvent e) {
        if(!mainMain.changeWeather) {
            e.setCancelled(true);
        }
    }
}
