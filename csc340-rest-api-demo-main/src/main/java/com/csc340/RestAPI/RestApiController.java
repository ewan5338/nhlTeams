package com.csc340.RestAPI;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author sentini
 */
@RestController
public class RestApiController {

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello, %s!", name);
    }

    /**
     * Get a random quote from quotable and make it available at this endpoint.
     *
     * @return
     */
    @GetMapping("/quote")
    public Object getQuote() {
        String url = "https://api.quotable.io/random";
        RestTemplate restTemplate = new RestTemplate();
        Object jSonQuote = restTemplate.getForObject(url, Object.class);

        //Print the whole response to console.
        String quote = restTemplate.getForObject(url, String.class);
        //Parse out the most important info from the response.
        JSONObject jo = new JSONObject(quote);
        System.out.println(jo.toString());
        String quoteAuthor = jo.getString("author");
        String quoteContent = jo.getString("content");
        System.out.println(quoteAuthor);
        System.out.println(quoteContent);

        return jSonQuote;
    }

    /**
     * Get a list of nhlFranchises from the nhl api and return the team name and city name for the franchises
     *
     * @return
     */
    @GetMapping("/nhlFranchises")
    public List<Object> getTeams() {
        String url = "https://statsapi.web.nhl.com/api/v1/franchises";
        RestTemplate restTemplate = new RestTemplate();
        Object[] nhlFranchises = restTemplate.getForObject(url, Object[].class);

        //Print the whole response to console
        JSONArray ja = new JSONArray(nhlFranchises);
        System.out.println(ja.toString());

        //Parse out relevant info from each entry in the response
        Iterator<Object> iter = ja.iterator();
        while (iter.hasNext()) {
            JSONObject jo = (JSONObject) iter.next();
            String name = jo.getString("name");
            String city = jo.getString("city");
            System.out.println(name + " : " + city);

        }

        return Arrays.asList(nhlFranchises);
    }

}
