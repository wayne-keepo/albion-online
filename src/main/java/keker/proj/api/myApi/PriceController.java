package keker.proj.api.myApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import keker.proj.api.aodpApi.DataReceiver;
import keker.proj.api.data.Price;
import keker.proj.api.data.PriceGroup;
import keker.proj.constants.AOResourcesTitle;
import keker.proj.services.ItemBuilder;
import keker.proj.services.PriceService;
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
public class PriceController {

    private ObjectMapper om_test = new ObjectMapper().registerModule(new JavaTimeModule());
    private final File tf = new File("A:\\Programming\\Repositories\\albion-online\\src\\test\\java\\json\\resources_list.json");

    @Autowired
    private PriceService priceService;

    @RequestMapping(value = "/resources_test")
    public @ResponseBody
    List<PriceGroup> getPrices_test(@RequestParam(required = false, name = "locations", defaultValue = "Caerleon") List<String> locations) throws IOException {
        Price[] res = om_test.readValue(tf, Price[].class);
        return priceService.groupPriceByTier(Arrays.asList(res));
    }

    @RequestMapping(value = "/resources")
    public @ResponseBody
    List<PriceGroup> getPrices(@RequestParam(required = false, name = "locations", defaultValue = "Caerleon") List<String> locations) {
        List<Price> prices = priceService.getPrices(locations);
        return  priceService.groupPriceByTier(prices);
    }

    //T?_PLANKS
    @RequestMapping(value = "/planks")
    public @ResponseBody
    List<PriceGroup> getPlanks(@RequestParam(required = false, name = "locations", defaultValue = "Caerleon") List<String> locations) {
        List<Price> prices = priceService.getPrice(
                AOResourcesTitle.PLANKS.name(),
                locations);
        return priceService.groupPriceByTier(prices);

    }

    //T?_METALBAR
    @RequestMapping("/metalbars")
    public @ResponseBody
    List<PriceGroup> getMetalbars(@RequestParam(required = false, name = "locations", defaultValue = "Caerleon") List<String> locations) {
        List<Price> prices = priceService.getPrice(
                AOResourcesTitle.METALBAR.name(),
                locations);
        return priceService.groupPriceByTier(prices);
    }

    //T?_LEATHER
    @RequestMapping("/leathers")
    public @ResponseBody
    List<PriceGroup> getLeathers(@RequestParam(required = false, name = "locations", defaultValue = "Caerleon") List<String> locations) {
        List<Price> prices = priceService.getPrice(
                AOResourcesTitle.LEATHER.name(),
                locations);
        return priceService.groupPriceByTier(prices);
    }

    //T?_CLOTH
    @RequestMapping("/cloths")
    public @ResponseBody
    List<PriceGroup> getCloths(@RequestParam(required = false, name = "locations", defaultValue = "Caerleon") List<String> locations) {
        List<Price> prices = priceService.getPrice(
                AOResourcesTitle.CLOTH.name(),
                locations);
        return priceService.groupPriceByTier(prices);
    }


}
