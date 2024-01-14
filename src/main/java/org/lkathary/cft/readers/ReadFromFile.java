package org.lkathary.cft.readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ReadFromFile implements IRead {
    @Override
    public void read(String fileName, List<String> stringList) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
