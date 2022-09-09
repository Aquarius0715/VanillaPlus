package struct;

public enum Flag {
    ON("§a§l表示"),
    OFF("§c§l非表示");

    Flag(String prefix) {
        this.suffix = prefix;
    }
    private final String suffix;
    public String getSuffix() { return suffix; }
    public Flag toggle() {
        if (this == ON) {
            return OFF;
        } else {
            return ON;
        }
    }
}
