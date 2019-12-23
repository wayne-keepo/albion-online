package keker.proj.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import keker.proj.api.model.GatherPrice;
import keker.proj.api.model.GatherPriceGroup;
import keker.proj.api.constant.GatherResources;
import keker.proj.api.service.GatherPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/prices")
public class GatherPriceController {

    private ObjectMapper om_test = new ObjectMapper().registerModule(new JavaTimeModule());
    private final File tf = new File("A:\\Programming\\Repositories\\albion-online\\src\\test\\java\\json\\resources_list.json");

    @Autowired
    private GatherPriceService gatherPriceService;

    @RequestMapping(value = "/resources_test")
    public @ResponseBody
    List<GatherPriceGroup> getPrices_test(@RequestParam(required = false, name = "locations", defaultValue = "Caerleon") List<String> locations) throws IOException {
        GatherPrice[] res = om_test.readValue(tf, GatherPrice[].class);
        return gatherPriceService.groupPriceByTier(Arrays.asList(res));
    }

    @RequestMapping(value = "/resources")
    public @ResponseBody
    List<GatherPriceGroup> getPrices(@RequestParam(required = false, name = "locations", defaultValue = "Caerleon") List<String> locations) {
        List<GatherPrice> prices = gatherPriceService.getPrices(locations);
        return  gatherPriceService.groupPriceByTier(prices);
    }

    //T?_PLANKS
    @RequestMapping(value = "/planks")
    public @ResponseBody
    List<GatherPriceGroup> getPlanks(@RequestParam(required = false, name = "locations", defaultValue = "Caerleon") List<String> locations) {
        List<GatherPrice> prices = gatherPriceService.getPrice(
                GatherResources.PLANKS.name(),
                locations);
        return gatherPriceService.groupPriceByTier(prices);

    }

    //T?_METALBAR
    @RequestMapping("/metalbars")
    public @ResponseBody
    List<GatherPriceGroup> getMetalbars(@RequestParam(required = false, name = "locations", defaultValue = "Caerleon") List<String> locations) {
        List<GatherPrice> prices = gatherPriceService.getPrice(
                GatherResources.METALBAR.name(),
                locations);
        return gatherPriceService.groupPriceByTier(prices);
    }

    //T?_LEATHER
    @RequestMapping("/leathers")
    public @ResponseBody
    List<GatherPriceGroup> getLeathers(@RequestParam(required = false, name = "locations", defaultValue = "Caerleon") List<String> locations) {
        List<GatherPrice> prices = gatherPriceService.getPrice(
                GatherResources.LEATHER.name(),
                locations);
        return gatherPriceService.groupPriceByTier(prices);
    }

    //T?_CLOTH
    @RequestMapping("/cloths")
    public @ResponseBody
    List<GatherPriceGroup> getCloths(@RequestParam(required = false, name = "locations", defaultValue = "Caerleon") List<String> locations) {
        List<GatherPrice> prices = gatherPriceService.getPrice(
                GatherResources.CLOTH.name(),
                locations);
        return gatherPriceService.groupPriceByTier(prices);
    }


}
