package keker.proj.api.aodpApi;


import keker.proj.api.data.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class DataReceiver {
    private static final String PRICES_AOD_URL = "https://www.albion-online-data.com/api/v2/stats/prices/";
    private static DataReceiver instance;

    @Autowired
    private RestTemplate restTemplate;

    private DataReceiver(){}

    public static DataReceiver getInstance(){
        if (instance==null){
            instance = new DataReceiver();
            return instance;
        } else return instance;

    }

    public List<Price> uploadPrices(List<String> itemList, Map<String, Object> uriVariables){
        String url = generateUrl(itemList);
        System.out.println(url);
        ResponseEntity<Price[]> response = restTemplate.getForEntity(url, Price[].class, uriVariables);
        List<Price> prices = Arrays.asList(response.getBody());
        System.out.println(prices);
        return prices;
    }

    private String generateUrl(List<String> itemList) {
        StringBuilder builder = new StringBuilder(PRICES_AOD_URL);
        for (String item: itemList)
            builder.append(item).append(",");

        return builder.toString().substring(0,builder.lastIndexOf(","));
    }

}
