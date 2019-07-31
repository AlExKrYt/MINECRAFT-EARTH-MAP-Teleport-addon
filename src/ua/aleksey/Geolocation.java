package ua.aleksey;
import java.io.IOException;
import java.net.InetAddress;

import eu.theindra.geoip.api.GeoIP;

public class Geolocation {
	
	private GeoIP geo;
	
	public Double getLatitude(InetAddress IP) throws IOException {
		geo = new GeoIP(IP);
		return geo.latitude;
	}
	
	public Double getLongitude(InetAddress IP) throws IOException{
		geo = new GeoIP(IP);
		return geo.longitude;
	}
	
	public int getDeg(double DD) {
		
		double coord = DD;
		int sec = (int)Math.round(coord * 3600);
		int deg = sec / 3600;
		sec = Math.abs(sec % 3600);
		sec %= 60;
		return deg;
	}
	
	public int getMin(double DD) {
		
		double coord = DD;
		int sec = (int)Math.round(coord * 3600);
		sec = Math.abs(sec % 3600);
		int min = sec / 60;
		sec %= 60;
		
		return min;
	}
	
	public int getSec(double DD) {
		
		double coord = DD;
		int sec = (int)Math.round(coord * 3600);
		sec = Math.abs(sec % 3600);
		sec %= 60;
		
		return sec;
	}

}
