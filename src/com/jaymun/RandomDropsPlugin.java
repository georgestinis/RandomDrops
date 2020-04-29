package com.jaymun;

import org.bukkit.plugin.java.JavaPlugin;

import com.jaymun.listeners.Listeners;

public class RandomDropsPlugin extends JavaPlugin{
	private static RandomDropsPlugin instance;
	
	public static RandomDropsPlugin getInstance() {
		return instance;
	}
	@Override
	public void onEnable() {
		instance = this;
		getServer().getPluginManager().registerEvents(new Listeners(), this);
	}
	
	@Override
	public void onDisable() {
		instance = null;
	}
}
