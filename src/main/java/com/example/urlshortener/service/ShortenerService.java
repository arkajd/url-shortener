package com.example.urlshortener.service;

import com.example.urlshortener.dto.CreateShortUrlRequestDto;
import com.example.urlshortener.model.UrlRecord;
import com.example.urlshortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class ShortenerService {

    @Autowired
    private UrlRepository repository;

    public void createShortenedUrl(CreateShortUrlRequestDto createShortUrlRequestDto){
        String url = createShortUrlRequestDto.getUrl();
        String hashedUrlOrAlias = createShortUrlRequestDto.getAlias();

        if(hashedUrlOrAlias==null || hashedUrlOrAlias.isEmpty()){
            try {
                hashedUrlOrAlias = generateHashedUrl(url);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }

        UrlRecord urlRecord = new UrlRecord(url, hashedUrlOrAlias);
        repository.addUrlRecord(urlRecord);
    }

    public void getActualUrl(String hashedUrl){
        repository.getActualUrl(hashedUrl);
    }

    private static String generateHashedUrl(String url) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(url.getBytes());
        return bytesToHex(hashBytes);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();

        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
