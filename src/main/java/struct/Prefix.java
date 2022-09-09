package struct;

public enum Prefix {
    VANILLA_PLUS("[VanillaPlus]"),
    MINE_COUNT("[MineCount]");

    private String prefix;

    Prefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() { return prefix; }
    public void setPrefix(String prefix) { this.prefix = prefix; }
}
