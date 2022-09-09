package com.aquariusuprim.minecount.logic.impl;

import com.aquariusuprim.minecount.logic.MineCountGUILogic;
import com.aquariusuprim.minecount.model.MineCountMdl;
import com.aquariusuprim.minecount.model.ScoreBoardMdl;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import struct.Flag;
import struct.Prefix;

import java.util.List;

public class MineCountGUILogicImpl implements MineCountGUILogic {

    @Override
    public Inventory createMenuInventory(MineCountMdl mdl, ScoreBoardMdl sbMdl) {
        Inventory inventory = Bukkit.createInventory(null, 9, Prefix.MINE_COUNT.getPrefix());
        createToggleButton(sbMdl.getScoreboardFlag(), "§lスコアボード: ", inventory, 0);
        createToggleButton(sbMdl.getLocationFlag(), "§l座標: ", inventory, 1);
        createToggleButton(sbMdl.getRankFlag(), "§lランク: ", inventory, 2);
        createToggleButton(sbMdl.getNextRankFlag(), "§l次ランク: ", inventory, 3);
        createToggleButton(sbMdl.getMineCountFlag(), "§l総採掘量: ", inventory, 4);
        createToggleButton(sbMdl.getNoticeDisplayFlag(), "§l破壊警告表示: ", inventory, 5);
        createToggleButton(sbMdl.getNoticeFlag(), "§l破壊警告", inventory, 6);
        createToggleButton(sbMdl.getSpaceFlag(), "§l空白", inventory, 7);
        return inventory;
    }

    @Override
    public void createToggleButton(Flag flag, String prefix, Inventory inventory, int slot) {
        ItemStack itemStack;
        if (flag == Flag.ON) {
            itemStack = new ItemStack(Material.EMERALD_BLOCK);
        } else {
            itemStack = new ItemStack(Material.REDSTONE_BLOCK);
        }
        ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.setDisplayName(prefix + flag.getSuffix());
        itemMeta.setLore(List.of("§8ここをクリックして切り替え"));
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(slot, itemStack);
    }
}