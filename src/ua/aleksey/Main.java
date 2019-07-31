package ua.aleksey;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import ua.aleksey.commands.RealWorld;
		
public class Main extends JavaPlugin {
	
	public Logger log = Logger.getLogger("RealWorldTeleporter");
	
	public void onEnable() {
		log.info("enabling...");
		
		File config = new File(getDataFolder() + File.separator + "config.yml");
		if(!config.exists()) {
			log.info("Creating new config file...");
			getConfig().options().copyDefaults(true);
			saveDefaultConfig();
		}
		
		int scaleConfig = getConfig().getInt("scale");
		switch(scaleConfig) {
		case 1: RealWorld.setScale("1000");
		log.info("scale set to 1000");
		break;
		case 2: RealWorld.setScale("2000");
		log.info("scale set to 2000");
		break;
		case 3: RealWorld.setScale("4000");
		log.info("scale set to 4000");
		break;
		default: RealWorld.setScale("1000");
		log.info("Error getting config varriable, setting to default... (1000)");
		}
		
		Bukkit.getPluginManager().registerEvents(new Handler(), this);
		getCommand("realworld").setExecutor(new RealWorld(this));
	}
	
	public void onDisable() {
		log.info("disabling...");
	}
}
