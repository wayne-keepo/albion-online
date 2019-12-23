package keker.proj.api.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import keker.proj.constants.AOResourcesTitle;
import keker.proj.constants.Tier;
import lombok.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Price {
    private String item_id;
    private Tier tier = null;
    private AOResourcesTitle type = null;
    private String city;
    private Integer quality;
    private Integer sell_price_min;
    private Integer sell_price_max;
    @JsonIgnoreProperties
    private LocalDateTime sell_price_min_date;
    @JsonIgnoreProperties
    private LocalDateTime sell_price_max_date;
    @JsonIgnoreProperties
    private Integer buy_price_min;
    @JsonIgnoreProperties
    private LocalDateTime buy_price_min_date;
    @JsonIgnoreProperties
    private Integer buy_price_max;
    @JsonIgnoreProperties
    private LocalDateTime buy_price_max_date;

    public void priceAdjustment() {
        this.sell_price_min += 5;
    }

    public void appointType() {
        this.type = AOResourcesTitle.valueOf(item_id.split("_")[1]);
    }

    public void appointTier() {
        String result = "";
        String r1 = "\\d";
        String r2 = "@\\d";

        Pattern p1 = Pattern.compile(r1, Pattern.MULTILINE);
        Pattern p2 = Pattern.compile(r2, Pattern.MULTILINE);
        Matcher m1 = p1.matcher(this.item_id);
        Matcher m2 = p2.matcher(this.item_id);

        if (m1.find() && m2.find())
            result += m1.group() + "." + m2.group().substring(1);

        else result += m1.group();
        this.tier = Tier.byValue(result);
    }
}
