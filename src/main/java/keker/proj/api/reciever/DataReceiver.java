package keker.proj.api.reciever;


import keker.proj.api.model.GatherPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class DataReceiver {
    private static final String PRICES_AOD_URL = "https://www.albion-online-data.com/api/v2/stats/prices/";
    private static DataReceiver instance;

    @Autowired
    private RestTemplate restTemplate = new RestTemplate();

    private DataReceiver(){}

    public static DataReceiver getInstance(){
        if (instance==null){
            instance = new DataReceiver();
            return instance;
        } else return instance;

    }

    public List<GatherPrice> uploadPrices(List<String> itemList, List<String> locations){
        String url = generateUrl(itemList, locations);
        GatherPrice[] response = restTemplate.getForObject(url, GatherPrice[].class);
        List<GatherPrice> prices = Arrays.asList(response);
        System.out.println(prices);
        return prices;
    }

    public String generateUrl(List<String> itemList, List<String> locations) {
        StringBuilder builder = new StringBuilder(PRICES_AOD_URL);
        for (String item: itemList)
            builder.append(item);
        builder.append("?locations=");
        locations.forEach(builder::append);
        return builder.toString();
    }

}
