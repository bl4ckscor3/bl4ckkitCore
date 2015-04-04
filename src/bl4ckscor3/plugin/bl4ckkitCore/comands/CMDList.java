package bl4ckscor3.plugin.bl4ckkitCore.comands;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.bl4ckkitCore.core.bl4ckkitCore;

public class CMDList
{
	public static void exe(Plugin plugin, Player p)
	{
		String list = "";
		
		for(Plugin pl : bl4ckkitCore.getPlugins())
		{
			list += pl.getDescription().getName() + " | ";
		}
		
		bl4ckkitCore.getMessageManager().sendChatMessage(p, plugin, "Plugins registered to bl4ckkitCore: " + list.substring(0, list.lastIndexOf(" |")));
	}
}
