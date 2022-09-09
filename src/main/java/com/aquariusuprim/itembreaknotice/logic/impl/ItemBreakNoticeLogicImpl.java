package com.aquariusuprim.itembreaknotice.logic.impl;

import com.aquariusuprim.itembreaknotice.logic.ItemBreakNoticeLogic;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class ItemBreakNoticeLogicImpl implements ItemBreakNoticeLogic {
    @Override
    public String getItemName(ItemStack itemStack) {
        if (Objects.requireNonNull(itemStack.getItemMeta()).hasDisplayName()) {
            return itemStack.getItemMeta().getDisplayName();
        } else {
            return itemStack.getItemMeta().getLocalizedName();
        }
    }
}
