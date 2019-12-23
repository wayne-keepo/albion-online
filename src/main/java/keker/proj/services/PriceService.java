package keker.proj.services;

import keker.proj.api.aodpApi.DataReceiver;
import keker.proj.api.data.Price;
import keker.proj.api.data.PriceGroup;
import keker.proj.constants.AOResourcesTitle;
import keker.proj.constants.Tier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriceService {

    @Autowired
    private ItemBuilder itemNameBuilder;

    public List<Price> getPrice(String itemTitle, List<String> locations) {
        List<Price> prices = DataReceiver.getInstance().uploadPrices(
                itemNameBuilder.buildImprovedItems(itemTitle),
                locations);
        prices.forEach(Price::appointTier);
        prices.forEach(Price::appointType);
        return prices;
    }

    public List<PriceGroup> groupPriceByTier(List<Price> prices){
        List<PriceGroup> groups = new LinkedList<>();
        Arrays.asList(Tier.values()).forEach(
                tier -> {
                    PriceGroup group = new PriceGroup();
                    List<Price> gp = prices.stream().filter(p->p.getTier().equals(tier)).collect(Collectors.toList());
                    group.setTier(tier.value());
                    gp.forEach(p->{
                        if (p.getType().equals(AOResourcesTitle.PLANKS))
                            group.setPlanks(p.getSell_price_min());
                        if (p.getType().equals(AOResourcesTitle.METALBAR))
                            group.setMetalbar(p.getSell_price_min());
                        if (p.getType().equals(AOResourcesTitle.LEATHER))
                            group.setLeather(p.getSell_price_min());
                        if (p.getType().equals(AOResourcesTitle.CLOTH))
                            group.setCloth(p.getSell_price_min());

                        group.setDate(p.getSell_price_min_date().toString());
                    });
                    groups.add(group);
                }
        );

        return groups;
    }

    public List<Price> getPrices(List<String> locations) {
        List<Price> prices = DataReceiver.getInstance().uploadPrices(
                itemNameBuilder.buildAllImprovedItems(),
                locations);
        prices.forEach(Price::appointTier);
        prices.forEach(Price::appointType);

        return prices;
    }
}
