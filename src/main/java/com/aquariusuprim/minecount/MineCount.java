package com.aquariusuprim.minecount;

import com.aquariusuprim.minecount.facade.impl.MineCountCommandFacadeImpl;
import com.aquariusuprim.minecount.facade.impl.MineCountGUIFacadeImpl;
import com.aquariusuprim.minecount.model.MineCountMdl;
import com.aquariusuprim.vanillaplus.VanillaPlus;
import me.staartvin.statz.Statz;
import me.staartvin.statz.api.API;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class MineCount extends JavaPlugin {
    private MineCountMdl mdl;
    public MineCountMdl getMdl() { return mdl; }
    public void setMdl(MineCountMdl mdl) { this.mdl = mdl; }

    public MineCount(VanillaPlus vanillaPlus) {
        Plugin statzPlugin = Bukkit.getServer().getPluginManager().getPlugin("statz");
        Objects.requireNonNull(getCommand("mc")).setExecutor(new MineCountCommandFacadeImpl(vanillaPlus));
        getServer().getPluginManager().registerEvents(new MineCountGUIFacadeImpl(mdl), vanillaPlus);
        if (statzPlugin != null && statzPlugin.isEnabled()) {
            mdl.setStatzAPI(new API((Statz) statzPlugin));
        }
    }
}
