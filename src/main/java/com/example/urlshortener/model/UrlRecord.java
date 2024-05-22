package com.example.urlshortener.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UrlRecord {

    private String url;
    private String urlHash;
}
