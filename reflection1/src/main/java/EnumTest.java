public enum  EnumTest {
    SPRING("春天", "春暖花开"),
    SUMMER("夏天", "七月流火"),
    AUTUMN("秋天", "万里悲秋常作客"),
    WINTER("冬天", "凛冬");

    private final String seasonName;
    private final String seasonDesc;

    EnumTest(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
}

class Testen{
    public static void main(String[] args) {
        System.out.println(EnumTest.AUTUMN.getSeasonName());
        System.out.println(EnumTest.AUTUMN.getSeasonDesc());
    }
}