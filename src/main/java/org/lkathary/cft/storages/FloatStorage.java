package org.lkathary.cft.storages;

import org.lkathary.cft.models.CommandLine;

public class FloatStorage extends BaseStorage<Float> {
    public FloatStorage() {
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
                float sum = 0.0f;
                float min = storage.get(0);
                float max = min;
                for (Float it : storage) {
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
