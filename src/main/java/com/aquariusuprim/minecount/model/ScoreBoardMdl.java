package com.aquariusuprim.minecount.model;

import struct.Flag;

public class ScoreBoardMdl {
    private Flag scoreboardFlag;
    public Flag getScoreboardFlag() { return scoreboardFlag; }
    public void setScoreboardFlag(Flag scoreboardFlag) { this.scoreboardFlag = scoreboardFlag; }

    private Flag locationFlag;
    public Flag getLocationFlag() { return locationFlag; }
    public void setLocationFlag(Flag locationFlag) { this.locationFlag = locationFlag; }

    private Flag rankFlag;
    public Flag getRankFlag() { return rankFlag; }
    public void setRankFlag(Flag rankFlag) { this.rankFlag = rankFlag; }

    private Flag nextRankFlag;
    public Flag getNextRankFlag() { return nextRankFlag; }
    public void setNextRankFlag(Flag nextRankFlag) { this.nextRankFlag = nextRankFlag; }

    private Flag mineCountFlag;
    public Flag getMineCountFlag() { return mineCountFlag; }
    public void setMineCountFlag(Flag mineCountFlag) { this.mineCountFlag = mineCountFlag; }

    private Flag noticeDisplayFlag;
    public Flag getNoticeDisplayFlag() { return noticeDisplayFlag; }
    public void setNoticeDisplayFlag(Flag noticeDisplayFlag) { this.noticeDisplayFlag = noticeDisplayFlag; }

    private Flag noticeFlag;
    public Flag getNoticeFlag() { return noticeFlag; }
    public void setNoticeFlag(Flag noticeFlag) { this.noticeFlag = noticeFlag; }

    private Flag spaceFlag;
    public Flag getSpaceFlag() { return spaceFlag; }
    public void setSpaceFlag(Flag spaceFlag) { this.spaceFlag = spaceFlag; }
}
