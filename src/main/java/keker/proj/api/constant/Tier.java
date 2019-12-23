package keker.proj.api.constant;

import java.util.Arrays;

public enum Tier {
    FR("4"),
        FR_O("4.1"),
        FR_TW("4.2"),
        FR_TH("4.3"),
    FV("5"),
        FV_O("5.1"),
        FV_TW("5.2"),
        FV_TH("5.3"),
    SX("6"),
        SX_O("6.1"),
        SX_TW("6.2"),
        SX_TH("6.3"),
    SN("7"),
        SN_O("7.1"),
        SN_TW("7.2"),
        SN_TH("7.3"),
    ET("8"),
        ET_O("8.1"),
        ET_TW("8.2"),
        ET_TH("8.3");

    String value;

    Tier(String value) {
        this.value = value;
    }

    public static Tier byValue(String val){
        return Arrays
                .stream(Tier.values())
                .filter(tier -> tier.value.equalsIgnoreCase(val))
                .findFirst()
                .orElse(null);
    }

    public String value(){return this.value;}
}
