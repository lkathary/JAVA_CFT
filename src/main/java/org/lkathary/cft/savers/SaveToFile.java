package org.lkathary.cft.savers;

import org.lkathary.cft.storages.BaseStorage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveToFile implements ISave {
    @Override
    public void save(String file, boolean append, BaseStorage<?> storage) {
        if (!storage.isEmpty()) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(file + storage.getTypeStorage().getTitle(), append))) {
                for (Object it : storage) {
                    bufferedWriter.write(it.toString() + '\n');
                }
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}
