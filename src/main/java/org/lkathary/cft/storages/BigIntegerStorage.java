package org.lkathary.cft.storages;

import org.lkathary.cft.models.CommandLine;

import java.math.BigInteger;

public class BigIntegerStorage extends BaseStorage<BigInteger> {

    public BigIntegerStorage() {
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
                BigInteger sum = BigInteger.ZERO;
                BigInteger min = storage.get(0);
                BigInteger max = min;
                for (BigInteger it : storage) {
                    sum = sum.add(it);
                    min = min.min(it);
                    max = max.max(it);
                }
                System.out.println("Sum: " + sum + " Min: " + min + " Max: " + max
                        + " Average: " + sum.doubleValue() / storage.size());
            }
        }
    }
}
