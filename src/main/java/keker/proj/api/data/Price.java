package keker.proj.api.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Price {
    private String item_id;
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
}
