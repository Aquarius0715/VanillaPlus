package com.aquariusuprim.minecount.facade.impl;

import com.aquariusuprim.minecount.MineCount;
import com.aquariusuprim.minecount.facade.MineCountCommandFacade;
import com.aquariusuprim.minecount.logic.MineCountGUILogic;
import com.aquariusuprim.minecount.logic.impl.MineCountGUILogicImpl;
import com.aquariusuprim.minecount.model.MineCountMdl;
import com.aquariusuprim.vanillaplus.VanillaPlus;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import struct.Prefix;
import struct.Status;

public class MineCountCommandFacadeImpl implements CommandExecutor, MineCountCommandFacade {

    private final MineCountMdl mdl;

    public MineCountCommandFacadeImpl(VanillaPlus vanillaPlus) {
        this.vanillaPlus = vanillaPlus;
        this.mineCount = vanillaPlus.getMineCount();
        this.mineCountGUILogic = new MineCountGUILogicImpl();
        this.mdl = mineCount.getMdl();
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (label.equalsIgnoreCase("mc")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(Prefix.MINE_COUNT + "このコマンドはログイン中のプレーヤしか実行できません。");
                return false;
            }
            Player player = (Player) sender;
            if (vanillaPlus.getMdl().getStatus() == Status.INVALID) {
                player.sendMessage(Prefix.VANILLA_PLUS.getPrefix() + "拡張機能は現在無効化されています。");
                return false;
            }
            if (args.length == 0) {
                if (mineCount.getMdl().getStatus() == Status.INVALID) {
                    player.sendMessage(Prefix.MINE_COUNT.getPrefix() + "MineCount機能は現在無効化されています。");
                    return false;
                }
                player.openInventory(mineCountGUILogic.createMenuInventory(mdl, mdl.getPlayerFlag().get(player.getUniqueId())));
                player.playSound(player.getLocation(), Sound.BLOCK_CHEST_OPEN, 8.0F, 2.0F);
                return true;
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("help")) {
                    player.sendMessage("=======================" + Prefix.MINE_COUNT.getPrefix() + "=======================");
                    player.sendMessage(Prefix.MINE_COUNT.getPrefix() + "</mc> : スコアボードの表示設定を開きます");
                    player.sendMessage(Prefix.MINE_COUNT.getPrefix() + "</mc help> : この説明画面を開きます");
                    player.sendMessage(Prefix.MINE_COUNT.getPrefix() + "</mc on> : MineCount機能をオンにします");
                    player.sendMessage(Prefix.MINE_COUNT.getPrefix() + "</mc off> : MineCount機能をオフにします");
                    player.sendMessage(Prefix.MINE_COUNT.getPrefix() + "Created By Aquarius0715");
                    player.sendMessage(Prefix.MINE_COUNT.getPrefix() + "Version 1.0.0 Released on 2022/09/08");
                    player.sendMessage("=======================" + Prefix.MINE_COUNT.getPrefix() + "=======================");
                    return true;
                } else if (args[0].equalsIgnoreCase("on")) {
                    if (mineCount.getMdl().getStatus() == Status.VALID) {
                        player.sendMessage(Prefix.MINE_COUNT.getPrefix() + "MineCount機能は既に有効化されています。");
                    } else {
                        mineCount.getMdl().setStatus(Status.VALID);
                        player.sendMessage(Prefix.MINE_COUNT.getPrefix() + "MineCount機能を有効化しました。");
                    }
                    return true;
                } else if (args[0].equalsIgnoreCase("off")) {
                    if (mineCount.getMdl().getStatus() == Status.INVALID) {
                        player.sendMessage(Prefix.MINE_COUNT.getPrefix() + "MineCount機能は既に無効化されています。");
                    } else {
                        mineCount.getMdl().setStatus(Status.INVALID);
                        player.sendMessage(Prefix.MINE_COUNT.getPrefix() + "MineCount機能を無効化しました。");
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /** VanillaPlusMain */
    private final VanillaPlus vanillaPlus;

    /** MineCountMain */
    private final MineCount mineCount;

    /** MineCountGUILogic */
    private final MineCountGUILogic mineCountGUILogic;
}
