package bl4ckscor3.plugin.bl4ckkitCore.helper;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

public class ItemStackBuilder
{
	private ItemStack stack;
	
	public ItemStackBuilder(Material m)
	{
		stack = new ItemStack(m);
	}
	
	public ItemStackBuilder(ItemStack s)
	{
		stack = s;
	}
	
	public ItemStackBuilder setName(String name)
	{
		ItemMeta meta = stack.getItemMeta();
		
		meta.setDisplayName(name);
		stack.setItemMeta(meta);
		return this;
	}
	
	public ItemStackBuilder setLore(String... lore)
	{
		List<String> finishedLore = new ArrayList<String>();
		ItemMeta meta = stack.getItemMeta();
		
		for(String s : lore)
		{
			finishedLore.add(s);
		}
		
		meta.setLore(finishedLore);
		stack.setItemMeta(meta);
		return this;
	}
	
	public ItemStackBuilder addEnchantment(Enchantment e, int level)
	{
		stack.addUnsafeEnchantment(e, level);
		return this;
	}
	
	public ItemStackBuilder setData(int data)
	{
		stack.setData(new MaterialData(stack.getType(), (byte)data));
		return this;
	}
	
	public ItemStackBuilder changeType(Material m)
	{
		stack.setType(m);
		return this;
	}
	
	public ItemStackBuilder setAmount(int amount)
	{
		stack.setAmount(amount);
		return this;
	}
	
	public ItemStackBuilder setDurability(int dur)
	{
		stack.setDurability((short)dur);
		return this;
	}
	
	public ItemStackBuilder removeEnchantment(Enchantment e)
	{
		stack.removeEnchantment(e);
		return this;
	}
	
	public ItemStackBuilder removeLore()
	{
		ItemMeta meta = stack.getItemMeta();
		
		meta.setLore(new ArrayList<String>());
		stack.setItemMeta(meta);
		return this;
	}
	
	public ItemStack get()
	{
		return stack;
	}
}
