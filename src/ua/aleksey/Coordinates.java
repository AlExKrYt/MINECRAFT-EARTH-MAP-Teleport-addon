package ua.aleksey;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coordinates {
	
	private String response;
	private int x;
	private int z;
	private Pattern pattern;
	private Matcher matcher;
	
	public void http_get(String URL) throws IOException {
        URL coords = new URL(URL);
        URLConnection yc = coords.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                yc.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
         //   System.out.println(inputLine);
        response += (inputLine);
        in.close();
	}
	

	public int getX() {
		pattern = Pattern.compile("(?<=X:)-?[0-9]\\w*");
        matcher = pattern.matcher(response);
        while(matcher.find())
           x = (Integer.parseInt(matcher.group()));
        
        return x;
    }   
	
	public int getZ() {
        
		pattern = Pattern.compile("(?<=Z:)-?[0-9]\\w*");
        matcher = pattern.matcher(response);
        while(matcher.find())
           z = (Integer.parseInt(matcher.group()));
        
        return z;
    }   

}
