package com.example.urlshortener.repository;

import com.example.urlshortener.model.UrlRecord;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UrlRepository {

    private Map<String, UrlRecord> urlDb;
    private Set<String> hashedUrls;

    public UrlRepository(){
        urlDb = new ConcurrentHashMap<>();
        hashedUrls = new HashSet<>();
    }

    public void addUrlRecord(UrlRecord urlRecord){
        urlDb.put(urlRecord.getUrl(), urlRecord);
        hashedUrls.add(urlRecord.getUrlHash());
    }

    public String getActualUrl(String hashedUrl){

        for(String url : urlDb.keySet()){
            UrlRecord urlRecord = urlDb.get(url);
            if(urlRecord.getUrlHash().equals(hashedUrl)){
                return urlRecord.getUrl();
            }
        }
        return null;
    }

}
