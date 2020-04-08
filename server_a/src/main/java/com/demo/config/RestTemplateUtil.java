package com.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author x_holic@outlook.com
 * @date 2020/4/9
 */
@Component
public class RestTemplateUtil {

    private static RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        RestTemplateUtil.restTemplate = restTemplate;
    }

}
