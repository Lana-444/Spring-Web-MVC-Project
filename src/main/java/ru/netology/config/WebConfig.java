package ru.netology.config;


import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.List;

@Configuration
@EnableWebMvc
public class WebConfig {

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();
        List<HttpMessageConverter<?>> messageConverterList = adapter.getMessageConverters();
        Gson gson = new Gson();
        messageConverterList.add(new GsonHttpMessageConverter(gson));
        adapter.setMessageConverters(messageConverterList);
        return adapter;
    }
}