package ua.aleksey;

import org.bukkit.plugin.java.JavaPlugin;
		
public class Main extends JavaPlugin {
	
	public void onEnable() {
		getCommand("realworld").setExecutor(new RealWorld(this));
	}
	
	public void onDisable() {
		
	}
}
