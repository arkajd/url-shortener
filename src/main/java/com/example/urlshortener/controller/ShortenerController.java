package com.example.urlshortener.controller;


import com.example.urlshortener.dto.CreateShortUrlRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShortenerController {

    // create shortened URL
    @PostMapping("/url")
    public void createShortenedUrl(@RequestBody CreateShortUrlRequestDto createShortUrlRequestDto){

    }

    // get shortened URL
    @GetMapping("/{urlHash}")
    public void getShortenedUrl(){

    }

    // get all shortened URL generated per user
    @GetMapping("")
    public void getAllShortenedUrlPerUser(){

    }
}
