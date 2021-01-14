package holdandcold.commons.types;

public enum LevelEnum {
    HOT(3),
    WARM(10),
    COLD(20),
    FREEZING(Integer.MAX_VALUE);

    private final int range;

    LevelEnum(int range) {
        this.range = range;
    }

    public static String getResult(int range) {
        for (LevelEnum levelEnum : values()) {
            if (Math.abs(range) <= levelEnum.range) {
                return levelEnum.name();
            }
        }
        throw new AssertionError("Unexpected range:" + range);
    }
}