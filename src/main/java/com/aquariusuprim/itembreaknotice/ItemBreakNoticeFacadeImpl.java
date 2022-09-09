package com.aquariusuprim.itembreaknotice;

import com.aquariusuprim.minecount.MineCount;
import com.aquariusuprim.itembreaknotice.facade.ItemBreakNoticeFacade;
import com.aquariusuprim.itembreaknotice.logic.ItemBreakNoticeLogic;
import com.aquariusuprim.itembreaknotice.logic.impl.ItemBreakNoticeLogicImpl;
import com.aquariusuprim.vanillaplus.VanillaPlus;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;
import struct.Flag;
import struct.Status;

public class ItemBreakNoticeFacadeImpl implements Listener, ItemBreakNoticeFacade {

    public ItemBreakNoticeFacadeImpl(VanillaPlus vanillaPlus) {
        this.vanillaPlus = vanillaPlus;
        this.mineCount = vanillaPlus.getMineCount();
        this.logic = new ItemBreakNoticeLogicImpl();
    }

    @Override
    @EventHandler
    public void onInteractAnyTool(PlayerItemDamageEvent event) {
        Player player = event.getPlayer();

        if (vanillaPlus.getMdl().getStatus() == Status.INVALID) return;
        if (mineCount.getMdl().getStatus() == Status.INVALID) return;
        if (mineCount.getMdl().getPlayerFlag().get(player.getUniqueId()).getNoticeFlag() == Flag.OFF) return;

        int maxDurability = event.getItem().getType().getMaxDurability();
        int currentDurability = event.getItem().getType().getMaxDurability() - event.getItem().getDurability() - 1;

        if (currentDurability > maxDurability * 0.2) return;

        TextComponent component = new TextComponent();

        if (currentDurability <= maxDurability * 0.2 && currentDurability >= maxDurability * 0.05) {
            component.setText("§7§l" +
                    "(ツール名: " + logic.getItemName(event.getItem()) +
                    " /最大耐久値: " + maxDurability +
                    " / §e§l現在の耐久値: " + currentDurability +
                    "§7§l)");
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, component);
        } else if (currentDurability <= maxDurability * 0.05) {
            component.setText("§7§l" +
                    "(ツール名: " + logic.getItemName(event.getItem()) +
                    " /最大耐久値: " + maxDurability +
                    " / §4§l現在の耐久値: " + currentDurability +
                    "§7§l)");
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, component);
            player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 8.0F, 0.0F);
        }
    }

    /** Vanilla Plus */
    private final VanillaPlus vanillaPlus;

    /** MineCount */
    private final MineCount mineCount;

    /** ItemBreakNoticeLogic */
    private final ItemBreakNoticeLogic logic;
}
