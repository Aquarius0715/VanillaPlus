package com.aquariusuprim.minecount.logic;

import com.aquariusuprim.minecount.model.MineCountMdl;
import com.aquariusuprim.minecount.model.ScoreBoardMdl;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import struct.Flag;

public interface MineCountGUILogic {
    Inventory createMenuInventory(MineCountMdl mdl, ScoreBoardMdl sbMdl);
    void createToggleButton(Flag flag, String prefix, Inventory inventory, int slot);
}
