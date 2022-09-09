package com.aquariusuprim.minecount.facade.impl;

import com.aquariusuprim.minecount.facade.MineCountGUIFacade;
import com.aquariusuprim.minecount.logic.MineCountGUILogic;
import com.aquariusuprim.minecount.logic.impl.MineCountGUILogicImpl;
import com.aquariusuprim.minecount.model.MineCountMdl;
import com.aquariusuprim.minecount.model.ScoreBoardMdl;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import struct.Prefix;

import java.util.Objects;
import java.util.UUID;

public class MineCountGUIFacadeImpl implements MineCountGUIFacade, Listener {
    MineCountMdl mdl;
    MineCountGUILogic logic;
    public MineCountGUIFacadeImpl(MineCountMdl mdl) {
        this.mdl = mdl;
        this.logic = new MineCountGUILogicImpl();
    }

    @EventHandler
    public void onClickMenuInventory(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        UUID uuid = player.getUniqueId();
        ScoreBoardMdl playerMap = mdl.getPlayerFlag().get(uuid);
        if (!event.getView().getTitle().equals(Prefix.MINE_COUNT.getPrefix())) return;
        if (event.getInventory() == player.getInventory()) return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        event.setCancelled(true);
        switch (event.getSlot()) {
            case 0:
                playerMap.setScoreboardFlag(playerMap.getScoreboardFlag().toggle());
                player.setScoreboard(Objects.requireNonNull(Bukkit.getScoreboardManager()).getNewScoreboard());
                break;
            case 1:
                playerMap.setLocationFlag(playerMap.getLocationFlag().toggle());
                break;
            case 2:
                playerMap.setRankFlag(playerMap.getRankFlag().toggle());
                break;
            case 3:
                playerMap.setNextRankFlag(playerMap.getRankFlag().toggle());
                break;
            case 4:
                playerMap.setMineCountFlag(playerMap.getMineCountFlag().toggle());
                break;
            case 5:
                playerMap.setNoticeDisplayFlag(playerMap.getNoticeDisplayFlag().toggle());
                break;
            case 6:
                playerMap.setNoticeFlag(playerMap.getNoticeFlag().toggle());
                break;
            case 7:
                playerMap.setSpaceFlag(playerMap.getSpaceFlag().toggle());
                break;
        }
        player.openInventory(logic.createMenuInventory(mdl, playerMap));
        player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 8.0F, -1.0F);
    }
}
