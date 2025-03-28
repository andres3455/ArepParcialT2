



package com.example.parcial.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class ProxyController {

    private final List<String> backendUrls;
    private final AtomicInteger Index = new AtomicInteger(0);

    public ProxyController(@Value("${URLS:}") String VarUrlsBack) {
        if (VarUrlsBack.isEmpty()) {
            throw new IllegalStateException("Recuerde configurar las variables de entorno en application.properties");
        }
        this.backendUrls = List.of(VarUrlsBack.split(","));
    }


    private String getNextUrl() {
        int index = Index.getAndUpdate(i -> (i + 1) % backendUrls.size());
        return backendUrls.get(index);
    }

    @GetMapping("/proxy/lucasseq")
    public Object Request(@RequestParam int value) {
        RestTemplate restTemplate = new RestTemplate();
        String UrlLucas = getNextUrl();
        String url = UrlLucas + "/lucasseq?value=" + value;
        return restTemplate.getForObject(url, Object.class);
    }

}



