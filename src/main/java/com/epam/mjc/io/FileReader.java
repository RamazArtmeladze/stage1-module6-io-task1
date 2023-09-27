package com.epam.mjc.io;

import java.io.*;


public class FileReader {

    private Profile parseProfileData(String data) {
        String[] lines = data.split(System.lineSeparator());
        String name = lines[0].substring(lines[0].indexOf(":") + 2);
        int age = Integer.parseInt(lines[1].substring(lines[1].indexOf(":") + 2));
        String email = lines[2].substring(lines[2].indexOf(":") + 2);
        long phone = Long.parseLong(lines[3].substring(lines[3].indexOf(":") + 2));
        return new Profile(name, age, email, phone);
    }

    public Profile getDataFromFile(File file) {
        StringBuilder content = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(file);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return parseProfileData(content.toString());
    }
}
