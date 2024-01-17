package org.lkathary.cft.models;

import org.lkathary.cft.filters.*;
import org.lkathary.cft.readers.IRead;
import org.lkathary.cft.readers.ReadFromFile;
import org.lkathary.cft.savers.ISave;
import org.lkathary.cft.savers.SaveToFile;
import org.lkathary.cft.storages.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Solution {
    private final CommandLine commandLine;
    private final List<String> lines = new ArrayList<>();
    private final List<BaseStorage<?>> superStorage = new ArrayList<>();

    public Solution(CommandLine commandLine) {
        this.commandLine = commandLine;
    }

    public void filter() {

        BaseFilter bigIntegerFilter = new BigIntegerFilter();
        BaseFilter doubleFilter = new DoubleFilter();
        BaseFilter stringFilter = new StringFilter();

        BaseStorage<BigInteger> bigIntegerStorage = new BigIntegerStorage();
        BaseStorage<Double> doubleStorage = new DoubleStorage();
        BaseStorage<String> stringStorage = new StringStorage();

        for (String line : lines) {
            Optional<?> res;
            if ((res = bigIntegerFilter.parse(line)).isPresent()) {
                bigIntegerStorage.add((BigInteger) res.get());
            } else if ((res = doubleFilter.parse(line)).isPresent()) {
                doubleStorage.add((Double) res.get());
            } else if ((res = stringFilter.parse(line)).isPresent()) {
                stringStorage.add((String) res.get());
            }
        }

        superStorage.add(bigIntegerStorage);
        superStorage.add(doubleStorage);
        superStorage.add(stringStorage);

//        show();
    }

    public void show() {
        superStorage.forEach(p-> System.out.println(p.getStorage()));
    }

    public void statistic() {
        superStorage.forEach(p-> p.showStatistic(commandLine));
    }

    public void read() {
        IRead reader = new ReadFromFile();
        for(String file : commandLine.getFiles()) {
            reader.read(file, lines);
        }
    }

    public void save() {
        String path = commandLine.getPath() != null ? commandLine.getPath() + '/' : "";
        String prefix = commandLine.getPrefix() != null ? commandLine.getPrefix() : "";
        boolean append = commandLine.getAppend();

        ISave saver = new SaveToFile();
        superStorage.forEach(p-> saver.save(path + prefix, append, p));
    }
}
