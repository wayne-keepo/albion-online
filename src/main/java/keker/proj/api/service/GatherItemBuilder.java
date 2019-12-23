package keker.proj.api.service;

import keker.proj.api.constant.GatherResources;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GatherItemBuilder {
    private static final String TIER = "T";
    private static final String LEVEL = "_LEVEL";
    private static final String META_LVL = "@";

    public List<String> buildNormalItems(String itemName) {
        StringBuilder builder = new StringBuilder();
        List<String> normalItems = new ArrayList<>(6);
        for (int i = 4; i <= 8; i++) {
            builder.append(TIER).append(i).append("_").append(itemName).append(",");
            normalItems.add(builder.toString());
            builder.setLength(0);
        }
        return normalItems;
    }

    public List<String> buildImprovedItems(String itemName) {

        StringBuilder builder = new StringBuilder();
        List<String> improvedItems = new ArrayList<>(6);
        for (int i = 4; i <= 8; i++) {
            builder.append(TIER).append(i).append("_").append(itemName).append(",");
            for (int k = 1; k <= 3; k++) {
                builder.append(TIER).append(i).append("_").append(itemName).append(LEVEL).append(k).append(META_LVL).append(k).append(',');
            }
            improvedItems.add(builder.toString());
            builder.setLength(0);
        }
        return improvedItems;
    }

    public List<String> buildAllImprovedItems() {
        List<String> items = new ArrayList<>(GatherResources.values().length * 5 + 1);
        for (GatherResources title: GatherResources.values()){
            items.addAll(buildImprovedItems(title.name()));
        }
        return items;
    }
}
