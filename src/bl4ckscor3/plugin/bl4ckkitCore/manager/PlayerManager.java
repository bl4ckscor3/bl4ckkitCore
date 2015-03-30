package bl4ckscor3.plugin.bl4ckkitCore.manager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerManager
{
	private static PlayerManager instance = new PlayerManager();
	
	protected PlayerManager(){}
	
	/**
	 * Gets this manager
	 * 
	 * @return - This manager
	 */
	public static PlayerManager getInstance()
	{
		return instance;
	}
	
	/**
	 * Checks if a player is online.
	 * 
	 * @param name - The player to search for
	 * @return - Returns if the player is online or not
	 */
	public boolean isPlayerOnline(String name)
	{
		for(Player p : Bukkit.getOnlinePlayers())
		{
			if(p.getName().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}
}
