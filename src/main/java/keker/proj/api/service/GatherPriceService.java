package keker.proj.api.service;

import keker.proj.api.reciever.DataReceiver;
import keker.proj.api.model.GatherPrice;
import keker.proj.api.model.GatherPriceGroup;
import keker.proj.api.constant.GatherResources;
import keker.proj.api.constant.Tier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GatherPriceService {

    @Autowired
    private GatherItemBuilder itemNameBuilder;

    public List<GatherPrice> getPrice(String itemTitle, List<String> locations) {
        List<GatherPrice> prices = DataReceiver.getInstance().uploadPrices(
                itemNameBuilder.buildImprovedItems(itemTitle),
                locations);
        prices.forEach(GatherPrice::appointTier);
        prices.forEach(GatherPrice::appointType);
        return prices;
    }

    public List<GatherPriceGroup> groupPriceByTier(List<GatherPrice> prices){
        List<GatherPriceGroup> groups = new LinkedList<>();
        Arrays.asList(Tier.values()).forEach(
                tier -> {
                    GatherPriceGroup group = new GatherPriceGroup();
                    List<GatherPrice> gp = prices.stream().filter(p->p.getTier().equals(tier)).collect(Collectors.toList());
                    group.setTier(tier.value());
                    gp.forEach(p->{
                        if (p.getType().equals(GatherResources.PLANKS))
                            group.setPlanks(p.getSell_price_min());
                        if (p.getType().equals(GatherResources.METALBAR))
                            group.setMetalbar(p.getSell_price_min());
                        if (p.getType().equals(GatherResources.LEATHER))
                            group.setLeather(p.getSell_price_min());
                        if (p.getType().equals(GatherResources.CLOTH))
                            group.setCloth(p.getSell_price_min());

                        group.setDate(p.getSell_price_min_date().toString());
                    });
                    groups.add(group);
                }
        );

        return groups;
    }

    public List<GatherPrice> getPrices(List<String> locations) {
        List<GatherPrice> prices = DataReceiver.getInstance().uploadPrices(
                itemNameBuilder.buildAllImprovedItems(),
                locations);
        prices.forEach(GatherPrice::appointTier);
        prices.forEach(GatherPrice::appointType);

        return prices;
    }
}
