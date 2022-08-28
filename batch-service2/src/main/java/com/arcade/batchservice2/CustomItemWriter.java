package com.arcade.batchservice2;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class CustomItemWriter implements ItemWriter<String> {

    @Override
    public void write(List<? extends String> list) throws Exception {
        for (String data : list) {
            System.out.println("CustomWriter : Writing data : " + data);
        }
        System.out.println("CustomWriter Completed");
    }
}
