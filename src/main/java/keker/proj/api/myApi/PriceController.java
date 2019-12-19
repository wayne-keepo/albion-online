package keker.proj.api.myApi;

import keker.proj.api.aodpApi.DataReceiver;
import keker.proj.api.data.Price;
import keker.proj.constants.AOResourcesTitle;
import keker.proj.services.ItemBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/prices")
public class PriceController {

    @Autowired
    private ItemBuilder itemNameBuilder;

    @RequestMapping(value = "/resources")
    public @ResponseBody
    List<Price> getPrices(@RequestParam(required = false, name = "locations", defaultValue = "Caerleon") List<String> locations) {
        return DataReceiver.getInstance().uploadPrices(
                itemNameBuilder.buildAllImprovedItems(),
                locations);
    }

    //T?_PLANKS
    @RequestMapping(value = "/planks")
    public @ResponseBody
    List<Price> getPlanks(@RequestParam(required = false, name = "locations", defaultValue = "Caerleon") List<String> locations) {
        return DataReceiver.getInstance().uploadPrices(
                itemNameBuilder.buildImprovedItems(AOResourcesTitle.PLANKS.name()),
                locations);
    }

    //T?_METALBAR
    @RequestMapping("/metalbars")
    public @ResponseBody
    List<Price> getMetalbars(@RequestParam(required = false, name = "locations", defaultValue = "Caerleon") List<String> locations) {
        return DataReceiver.getInstance().uploadPrices(
                itemNameBuilder.buildImprovedItems(AOResourcesTitle.METALBAR.name()),
                locations);
    }

    //T?_LEATHER
    @RequestMapping("/leathers")
    public @ResponseBody
    List<Price> getLeathers(@RequestParam(required = false, name = "locations", defaultValue = "Caerleon") List<String> locations) {
        return DataReceiver.getInstance().uploadPrices(
                itemNameBuilder.buildImprovedItems(AOResourcesTitle.LEATHER.name()),
                locations);
    }

    //T?_CLOTH
    @RequestMapping("/cloths")
    public @ResponseBody
    List<Price> getCloths(@RequestParam(required = false, name = "locations", defaultValue = "Caerleon") List<String> locations) {
        return DataReceiver.getInstance().uploadPrices(
                itemNameBuilder.buildImprovedItems(AOResourcesTitle.CLOTH.name()),
                locations);
    }


}
