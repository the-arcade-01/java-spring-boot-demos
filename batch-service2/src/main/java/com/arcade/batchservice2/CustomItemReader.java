package com.arcade.batchservice2;

import org.springframework.batch.item.ItemReader;

public class CustomItemReader implements ItemReader<String> {
    private String[] store = { "Zero", "One", "Two", "Three", "Four", "Five" };

    private int index = 0;

    @Override
    public String read() throws Exception {
        if (index >= store.length) {
            return null;
        }
        String resultString = index + " " + store[index];
        index++;

        System.out.println("CustomItemReader : Data    :  " + resultString);

        return resultString;
    }
}
