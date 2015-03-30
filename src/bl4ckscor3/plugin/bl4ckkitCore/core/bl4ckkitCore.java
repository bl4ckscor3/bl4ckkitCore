package bl4ckscor3.plugin.bl4ckkitCore.core;

import org.bukkit.plugin.java.JavaPlugin;

import bl4ckscor3.plugin.bl4ckkitCore.manager.MessageManager;
import bl4ckscor3.plugin.bl4ckkitCore.manager.PlayerManager;
import bl4ckscor3.plugin.bl4ckkitCore.manager.PluginManager;

public class bl4ckkitCore extends JavaPlugin
{
	private static MessageManager msgmgr;
	private static PluginManager plmgr;
	private static PlayerManager pmgr;
	
	@Override
	public void onEnable()
	{
		msgmgr = MessageManager.getInstance();
		plmgr = PluginManager.getInstance();
		pmgr = PlayerManager.getInstance();
		msgmgr.sendEnabledMessage(this);
	}
	
	@Override
	public void onDisable()
	{
		msgmgr.sendDisabledMessage(this);
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
}
