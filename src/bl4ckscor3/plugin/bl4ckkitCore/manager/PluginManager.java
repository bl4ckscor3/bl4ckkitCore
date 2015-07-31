package bl4ckscor3.plugin.bl4ckkitCore.manager;

import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.bl4ckkitCore.exception.PluginNotInstalledException;

public class PluginManager
{
	private static PluginManager instance = new PluginManager();

	protected PluginManager(){}
	
	/**
	 * Gets this manager
	 * 
	 * @return - This manager
	 */
	public static PluginManager getInstance()
	{
		return instance;
	}

	/**
	 * Searches and returns a plugin
	 * 
	 * @param pl - The plugin which the method is called from
	 * @param name - The name of the plugin to search
	 * @return - The found plugin
	 * @throws PluginNotInstalledException - When the plugin has not been found
	 */
	public Plugin getPlugin(Plugin pl, String name) throws PluginNotInstalledException
	{
		Plugin plugin = pl.getServer().getPluginManager().getPlugin(name);

		if(plugin == null)
			throw new PluginNotInstalledException(name);
		return plugin;
	}
	
	/**
	 * Registers all given events
	 * @param pl The plugin the events get registered from
	 * @param listener The events to register
	 */
	public void registerEvents(Plugin pl, Listener... listener)
	{
		for(Listener l : listener)
		{
			pl.getServer().getPluginManager().registerEvents(l, pl);
		}
	}
}
