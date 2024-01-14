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


//        lines.add("Lorem ipsum dolor sit amet");
//        lines.add("45");
//        lines.add("Пример");
//        lines.add("3.1415");
//        lines.add("consectetur adipiscing");
//        lines.add("-0.001");
//        lines.add("тестовое задание");
//        lines.add("100500");
//
//        lines.add("Нормальная форма числа с плавающей запятой");
//        lines.add("1.528535047E-25");
//        lines.add("Long");
//        lines.add("1234567890123456789");


//        read();
//        System.out.println(lines);

        BaseFilter integerFilter = new IntegerFilter();
        BaseFilter bigIntegerFilter = new BigIntegerFilter();
        BaseFilter floatFilter = new FloatFilter();
        BaseFilter stringFilter = new StringFilter();
        BaseFilter biFilter = new BigIntegerFilter();

        BaseStorage<Integer> integerStorage = new IntegerStorage();
        BaseStorage<BigInteger> bigIntegerStorage = new BigIntegerStorage();
        BaseStorage<Float> floatStorage = new FloatStorage();
        BaseStorage<String> stringStorage = new StringStorage();

        System.out.println("=============");
        Optional<?> res = biFilter.parse("246666666666666666666661497785657657.65");
        System.out.println(res.isPresent() ? res.get() : "Not BI!");


//        for (String line : lines) {
//            if ((res = integerFilter.parse(line)).isPresent()) {
//                integerStorage.add((Integer) res.get());
//            } else if ((res = floatFilter.parse(line)).isPresent()) {
//                floatStorage.add((Float) res.get());
//            } else if ((res = stringFilter.parse(line)).isPresent()) {
//                stringStorage.add((String) res.get());
//            }
//        }
        for (String line : lines) {
            if ((res = bigIntegerFilter.parse(line)).isPresent()) {
                bigIntegerStorage.add((BigInteger) res.get());
            } else if ((res = floatFilter.parse(line)).isPresent()) {
                floatStorage.add((Float) res.get());
            } else if ((res = stringFilter.parse(line)).isPresent()) {
                stringStorage.add((String) res.get());
            }
        }
//        superStorage.add(integerStorage);
        superStorage.add(bigIntegerStorage);
        superStorage.add(floatStorage);
        superStorage.add(stringStorage);

        show();
    }

    public void show() {
        superStorage.forEach(p-> System.out.println(p.getStorage()));
    }
//    public void show() {
//        superStorage.forEach(System.out::println);
//    }

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
