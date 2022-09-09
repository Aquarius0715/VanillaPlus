package com.aquariusuprim.itembreaknotice.facade;

import org.bukkit.event.player.PlayerItemDamageEvent;

public interface ItemBreakNoticeFacade {
    void onInteractAnyTool(PlayerItemDamageEvent event);
}
