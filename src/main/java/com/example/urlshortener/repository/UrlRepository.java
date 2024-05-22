package com.example.urlshortener.repository;

import com.example.urlshortener.model.UrlRecord;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class UrlRepository {

    private Map<String, UrlRecord> urlDb;
    private Set<String> hashedUrls;

    public UrlRepository(){
        urlDb = new ConcurrentHashMap<>();
        hashedUrls = new HashSet<>();
    }

    public void addUrlRecord(UrlRecord urlRecord){

    }

    public void getRealUrl(){

    }




}
