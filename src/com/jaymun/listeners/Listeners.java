package com.jaymun.listeners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class Listeners implements Listener{
	
	private final List<Material> r_blocks;
	
	public Listeners() {
		
		List<Material> matList = new ArrayList<>();
		for (Material m : Material.values()) {
			if ((m.isBlock() || m.isEdible()) && !m.isAir()) {
				matList.add(m);
			}
		}
		Collections.shuffle(matList);
		r_blocks = matList;
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		Block block = event.getBlock();
		Material m = block.getType();
		int materialId = m.getId();
		System.out.println("MaterialID: "+materialId);
		World world = player.getWorld();
		if (materialId <= r_blocks.size()) {
			if (event.isDropItems()) {
				event.setDropItems(false);
				world.dropItem(block.getLocation(), new ItemStack(r_blocks.get(materialId), getRandom(1, 64)));
			}
		}
		
	}
	
	public int getRandom(int lowest, int highest) {
        Random random = new Random();
        return random.nextInt((highest - lowest) + 1) + lowest;  //99
	 }

}
