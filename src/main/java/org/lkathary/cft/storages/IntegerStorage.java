package org.lkathary.cft.storages;

import org.lkathary.cft.models.CommandLine;

public class IntegerStorage extends BaseStorage<Integer> {

    public IntegerStorage() {
        super();
        typeStorage = TypeFile.INTEGER_FILE;
    }

    @Override
    public void showStatistic(CommandLine commandLine) {
        if (commandLine.getShortStat()) {
            System.out.println("->\nShort statistic for integers: " + storage.size() + " records");
        }
        if (commandLine.getFullStat()) {
            System.out.println("->\nFull statistic for integers: " + storage.size() + " records");
            if (!storage.isEmpty()) {
                long sum = 0;
                int min = storage.get(0);
                int max = min;
                for (Integer it : storage) {
                    sum += it;
                    min = Math.min(min, it);
                    max = Math.max(max, it);
                }
                System.out.println("Sum: " + sum + " Min: " + min + " Max: " + max
                        + " Average: " + (double) sum / storage.size());
            }
        }
    }
}
