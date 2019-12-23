package keker.proj.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GatherPriceGroup {
    private String tier;
    private Integer planks;
    private Integer metalbar;
    private Integer leather;
    private Integer cloth;
    private String date;
}
