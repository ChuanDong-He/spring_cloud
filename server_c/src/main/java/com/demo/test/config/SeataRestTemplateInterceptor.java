package com.demo.test.config;

import io.seata.core.context.RootContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author x_holic@outlook.com
 * @date 2020/4/9
 */
@Component
public class SeataRestTemplateInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        HttpRequestWrapper requestWrapper = new HttpRequestWrapper(httpRequest);
        String xid = RootContext.getXID();
        if(!StringUtils.isEmpty(xid)) {
            //构建请求头
            requestWrapper.getHeaders().add("TX_XID", xid);
        }

        return clientHttpRequestExecution.execute(requestWrapper, bytes);
    }
}
