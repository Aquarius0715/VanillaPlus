package com.aquariusuprim.vanillaplus;

import com.aquariusuprim.minecount.MineCount;
import com.aquariusuprim.vanillaplus.model.VanillaPlusMdl;
import org.bukkit.plugin.java.JavaPlugin;
import struct.Status;

public final class VanillaPlus extends JavaPlugin {
    @Override
    public void onEnable() {
        mdl.setStatus(Status.INVALID);
        mineCount = new MineCount(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    /** VanillaPlusModel */
    private VanillaPlusMdl mdl;
    public VanillaPlusMdl getMdl() { return mdl; }
    public void setMdl(VanillaPlusMdl mdl) { this.mdl = mdl; }

    /** MineCountMain */
    private MineCount mineCount;
    public MineCount getMineCount() { return mineCount; }
    public void setMineCount(MineCount mineCount) { this.mineCount = mineCount; }
}
