package org.lkathary.cft.storages;

import org.lkathary.cft.models.CommandLine;

public class DoubleStorage extends BaseStorage<Double> {

    public DoubleStorage() {
        super();
        typeStorage = TypeFile.FLOAT_FILE;
    }

    @Override
    public void showStatistic(CommandLine commandLine) {
        if (commandLine.getShortStat()) {
            System.out.println("->\nShort statistic for floats: " + storage.size() + " records");
        }
        if (commandLine.getFullStat()) {
            System.out.println("->\nFull statistic for floats: " + storage.size() + " records");
            if (!storage.isEmpty()) {
                double sum = 0.0;
                double min = storage.get(0);
                double max = min;
                for (Double it : storage) {
                    sum += it;
                    min = Math.min(min, it);
                    max = Math.max(max, it);
                }
                System.out.println("Sum: " + sum + " Min: " + min + " Max: " + max
                        + " Average: " + sum / storage.size());
            }
        }
    }
}
