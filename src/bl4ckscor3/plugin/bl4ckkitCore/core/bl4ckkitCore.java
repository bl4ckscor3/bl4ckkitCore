package bl4ckscor3.plugin.bl4ckkitCore.core;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import bl4ckscor3.plugin.bl4ckkitCore.comands.CMDList;
import bl4ckscor3.plugin.bl4ckkitCore.manager.MessageManager;
import bl4ckscor3.plugin.bl4ckkitCore.manager.PlayerManager;
import bl4ckscor3.plugin.bl4ckkitCore.manager.PluginManager;

public class bl4ckkitCore extends JavaPlugin
{
	private static MessageManager msgmgr;
	private static PluginManager plmgr;
	private static PlayerManager pmgr;
	private static ArrayList<Plugin> plugins = new ArrayList<Plugin>();
	private static bl4ckkitCore instance;
	
	@Override
	public void onLoad()
	{
		instance = this;
		msgmgr = MessageManager.getInstance();
		plmgr = PluginManager.getInstance();
		pmgr = PlayerManager.getInstance();
	}

	@Override
	public void onEnable()
	{
		msgmgr.sendEnabledMessage(this);
	}
	
	@Override
	public void onDisable()
	{
		msgmgr.sendDisabledMessage(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		Player p = null;
		
		if(sender instanceof Player)
			p = (Player)sender;
		else
		{
			msgmgr.sendDisallowMessage(this);
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("bl4ckkitcore"))
		{
			CMDList.exe(this, p);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Gets the MessageManager
	 * 
	 * @return - The MessageManager
	 */
	public static MessageManager getMessageManager()
	{
		return msgmgr;
	}
	
	/**
	 * Gets the PluginManager
	 * 
	 * @return - The PluginManager
	 */
	public static PluginManager getPluginManager()
	{
		return plmgr;
	}
	
	/**
	 * Gets the PlayerManager
	 * 
	 * @return - The PlayerManager
	 */
	public static PlayerManager getPlayerManager()
	{
		return pmgr;
	}
	
	/**
	 * Registers a plugin to bl4ckkitCore which uses bl4ckkitCore
	 */
	public static void registerPlugin(Plugin pl)
	{
		msgmgr.sendConsoleMessage(instance, ChatColor.RED + "Registered plugin " + pl.getDescription().getName());
		plugins.add(pl);
	}
	
	/**
	 * Unregisters a plugin to bl4ckkitCore which uses bl4ckkitCore
	 */
	public static void unregisterPlugin(Plugin pl)
	{
		msgmgr.sendConsoleMessage(instance, ChatColor.RED + "Unregistered plugin " + pl.getDescription().getName());
		plugins.remove(pl);
	}
	
	public static ArrayList<Plugin> getPlugins()
	{
		return plugins;
	}
}
