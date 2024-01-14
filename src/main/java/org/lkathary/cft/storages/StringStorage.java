package org.lkathary.cft.storages;

import org.lkathary.cft.models.CommandLine;

public class StringStorage extends BaseStorage<String> {

    public StringStorage() {
        super();
        typeStorage = TypeFile.STRING_FILE;
    }

    @Override
    public void showStatistic(CommandLine commandLine) {
        if (commandLine.getShortStat()) {
            System.out.println("->\nShort statistic for strings: " + storage.size() + " records");
        }
        if (commandLine.getFullStat()) {
            System.out.println("->\nFull statistic for strings: " + storage.size() + " records");
            if (!storage.isEmpty()) {
                int min = storage.get(0).length();
                int max = min;
                for (String it : storage) {
                    min = Math.min(min, it.length());
                    max = Math.max(max, it.length());
                }
                System.out.println("Size of the shortest string: " + min);
                System.out.println("Size of the longest string: " + max);
            }
        }
    }
}
