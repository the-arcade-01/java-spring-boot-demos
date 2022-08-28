package com.arcade.batchservice2;

import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<String, String> {

    @Override
    public String process(String data) throws Exception {
        System.out.println("CustomProcessor : Processing data : " + data);

        data = data.toUpperCase();
        return data;
    }
}
