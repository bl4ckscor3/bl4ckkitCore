package bl4ckscor3.plugin.bl4ckkitCore.manager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class MessageManager
{
	private static MessageManager instance = new MessageManager();
	
	protected MessageManager(){}
	
	/**
	 * Gets this manager
	 * 
	 * @return - This manager
	 */
	public static MessageManager getInstance()
	{
		return instance;
	}
	
	/**
	 * Sends a message with the plugin name prefixed to a player
	 * 
	 * @param p - The Player to send the message to
	 * @param pl - The Plugin to send the message from
	 * @param msg - The message to send
	 */
	public void sendChatMessage(CommandSender sender, Plugin pl, String msg)
	{
		sender.sendMessage("[" + ChatColor.BLUE + pl.getDescription().getName() + ChatColor.RESET + "] " + msg);
	}
	
	/**
	 * Sends a message with the plugin name prefixed to the console
	 * 
	 * @param pl - The Plugin to send the message from
	 * @param msg - The message to send
	 */
	public void sendConsoleMessage(Plugin pl, String msg)
	{
		Bukkit.getConsoleSender().sendMessage("[" + ChatColor.BLUE + pl.getDescription().getName() + ChatColor.RESET + "] " + msg);
	}
	
	/**
	 * Tells the console that the plugin has been successfully enabled.
	 * 
	 * @param pl - The plugin which has been enabled.
	 */
	public void sendEnabledMessage(Plugin pl)
	{
		sendConsoleMessage(pl, "v" + pl.getDescription().getVersion() + " successfully enabled!");
	}
	
	/**
	 * Tells the console that the plugin has been successfully disabled.
	 * 
	 * @param pl - The plugin which has been disabled.
	 */
	public void sendDisabledMessage(Plugin pl)
	{
		sendConsoleMessage(pl, "v" + pl.getDescription().getVersion() + " successfully disabled!");
	}
	
	/**
	 * Tells the console that the plugin can't be used from the console.
	 * 
	 * @param pl - The plugin which is involved.
	 */
	public void sendDisallowMessage(Plugin pl)
	{
		sendConsoleMessage(pl, "The console cannot use this plugin. Please join the server and execute the command on there.");
	}
}
