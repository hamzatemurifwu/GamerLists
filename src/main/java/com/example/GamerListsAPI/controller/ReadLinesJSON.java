package com.example.GamerListsAPI.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadLinesJSON {
    public String readLineByLineJson(String filePath) {
        String resp = null;
        StringBuilder contentBuilder = new StringBuilder();
        if (Files.exists(Paths.get(filePath))) {
            try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
                stream.forEach(contentBuilder::append);
            } catch (IOException e) {
                e.printStackTrace();
            }
            resp = contentBuilder.toString();
        }
        return resp;
    }
}