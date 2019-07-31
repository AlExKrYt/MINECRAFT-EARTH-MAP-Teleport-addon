package ua.aleksey;

import java.net.InetAddress;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jline.utils.Log;


public class RealWorld implements CommandExecutor {

	private Main plugin;

	public RealWorld(Main plugin) {
		this.setPlugin(plugin);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		try {
			Player p = (Player) sender;
			Geolocation location = new Geolocation();
			Coordinates coordinates = new Coordinates();
			Location loc = p.getLocation();
			
			InetAddress ip = p.getAddress().getAddress();
			
			//Check if the ip is not null
			if(ip == null){
				Log.info("У игрока " + p.getName() + " нет IP, отмена!");
			   return false;
			}
			 
			//Check if the ip is not local   
			if(ip.isAnyLocalAddress() || ip.isLoopbackAddress()){
				Log.info("У игрока " + p.getName() + " локальный IP, отмена!");
			   return false;
			}
			
			
			coordinates.http_get("http://earth.motfe.net/coords.php?scale=1000&longitude_hou="
					+ location.getDeg(location.getLongitude(ip)) + "&longitude_min="
							+ location.getMin(location.getLongitude(ip)) + "&longitude_sec="
									+ location.getSec(location.getLongitude(ip)) + "&longitude_pol=N&latitude_hou="
											+ location.getDeg(location.getLatitude(ip)) + "&latitude_min="
													+ location.getMin(location.getLatitude(ip)) + "&latitude_sec="
															+ location.getSec(location.getLatitude(ip)) + "&latitude_pol=E");
			
			Log.info(ip);
			loc = loc.set(coordinates.getX(), loc.getY(), coordinates.getZ());
			p.teleport(loc);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return true;
	}

	public Main getPlugin() {
		return plugin;
	}

	public void setPlugin(Main plugin) {
		this.plugin = plugin;
	}

}
