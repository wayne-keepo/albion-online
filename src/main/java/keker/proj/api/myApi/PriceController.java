package keker.proj.api.myApi;

import keker.proj.api.aodpApi.DataReceiver;
import keker.proj.api.data.Price;
import keker.proj.constants.AOResourcesTitle;
import keker.proj.services.ItemBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/prices")
public class PriceController {

    @Autowired
    private ItemBuilder itemNameBuilder;

    @RequestMapping("/resources")
    public List<Price> getPrices() {

        return null;
    }

    //T?_PLANKS
    @RequestMapping(value = "/planks", method = RequestMethod.POST)
    public @ResponseBody
    List<Price> getPlanks(@RequestBody(required = false) Map<String, Object> locations) {
        List<String> planks = itemNameBuilder.buildNormalItems(AOResourcesTitle.PLANKS.name());
        if (locations.isEmpty())
            locations.put("locations", "Caerleon");
        List<Price> prices = DataReceiver.getInstance().uploadPrices(planks, locations);
        recalcMinPrice(prices);
        return prices;
    }

    //T?_METALBAR
    @RequestMapping("/metalbars")
    public @ResponseBody
    List<Price> getMetalbars(@RequestBody(required = false) Map<String, Object> locations) {
        List<String> metalbars = itemNameBuilder.buildNormalItems(AOResourcesTitle.METALBAR.name());
        if (locations.isEmpty())
            locations.put("locations", "Caerleon");
        List<Price> prices = DataReceiver.getInstance().uploadPrices(metalbars, locations);
        recalcMinPrice(prices);
        return prices;
    }

    //T?_LEATHER
    @RequestMapping("/leathers")
    public @ResponseBody
    List<Price> getLeathers(@RequestBody(required = false) Map<String, Object> locations) {
        List<String> leathers = itemNameBuilder.buildNormalItems(AOResourcesTitle.LEATHER.name());
        if (locations.isEmpty())
            locations.put("locations", "Caerleon");
        List<Price> prices = DataReceiver.getInstance().uploadPrices(leathers, locations);
        recalcMinPrice(prices);
        return prices;
    }

    //T?_CLOTH
    @RequestMapping("/cloths")
    public List<Price> getCloths(@RequestBody(required = false) Map<String, Object> locations) {
        List<String> cloths = itemNameBuilder.buildNormalItems(AOResourcesTitle.CLOTH.name());
        if (locations.isEmpty())
            locations.put("locations", "Caerleon");
        List<Price> prices = DataReceiver.getInstance().uploadPrices(cloths, locations);
        recalcMinPrice(prices);
        return prices;
    }

    private void recalcMinPrice(List<Price> prices) {
        prices.forEach(Price::priceAdjustment);
    }

}
