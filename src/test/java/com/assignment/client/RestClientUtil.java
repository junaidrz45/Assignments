package com.assignment.client;

import java.net.URI;

import com.assignment.entity.Items;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.assignment.entity.WareHouse;

public class RestClientUtil {
    public void getWareHousebyIDDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/wareHouse/getbyId/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<WareHouse> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, WareHouse.class, 1);
        WareHouse wareHouse = responseEntity.getBody();
        System.out.println("Id:"+wareHouse.getWarehouseid()+", Name:"+wareHouse.getName()
                 +", CountryName:"+wareHouse.getCountry().getName());
    }
	public void getAllProductsDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/product/getall";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Items[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Items[].class);
        Items[] itmes = responseEntity.getBody();
        for(Items item : itmes) {
              System.out.println("Id:"+item.getItemid()+", Name:"+item.getName()
                      +", WareHouseName: "+item.getWareHouse().getName());
        }
    }
    public void addWareHouseDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/wareHouse/add";
	    WareHouse objwaherehouse = new WareHouse();
        objwaherehouse.setName("TestWareHouse");
	    HttpEntity<WareHouse> requestEntity = new HttpEntity<WareHouse>(objwaherehouse, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }

    public static void main(String args[]) {
    	RestClientUtil util = new RestClientUtil();
        util.getWareHousebyIDDemo();
        util.getAllProductsDemo();
        util.addWareHouseDemo();
    }    
}
