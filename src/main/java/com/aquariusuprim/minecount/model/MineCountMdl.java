package com.aquariusuprim.minecount.model;

import me.staartvin.statz.api.API;
import struct.Status;

import java.util.Map;
import java.util.UUID;

public class MineCountMdl {
    private API statzAPI;
    public API getStatzAPI() { return statzAPI; }
    public void setStatzAPI(API statzAPI) { this.statzAPI = statzAPI; }

    private Status status;
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    private Map<UUID, ScoreBoardMdl> playerFlag;
    public Map<UUID, ScoreBoardMdl> getPlayerFlag() { return playerFlag; }
    public void setPlayerFlag(Map<UUID, ScoreBoardMdl> playerFlag) { this.playerFlag = playerFlag; }
}
