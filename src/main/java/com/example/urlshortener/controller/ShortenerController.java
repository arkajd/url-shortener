package com.example.urlshortener.controller;


import com.example.urlshortener.dto.CreateShortUrlRequestDto;
import com.example.urlshortener.service.ShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShortenerController {

    @Autowired
    private ShortenerService shortenerService;

    @PostMapping("/url")
    public void createShortenedUrl(@RequestBody CreateShortUrlRequestDto createShortUrlRequestDto){
        shortenerService.createShortenedUrl(createShortUrlRequestDto);
    }

    @GetMapping("/{hashedUrl}")
    public void getShortenedUrl(@PathVariable String hashedUrl){
        shortenerService.getActualUrl(hashedUrl);
    }

}
