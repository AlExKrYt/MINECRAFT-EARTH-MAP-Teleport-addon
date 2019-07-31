package ua.aleksey;

import org.bukkit.plugin.java.JavaPlugin;

import ua.aleksey.commands.RealWorld;
		
public class Main extends JavaPlugin {
	
	public void onEnable() {
		getCommand("realworld").setExecutor(new RealWorld(this));
	}
	
	public void onDisable() {
		
	}
}
