package org.lkathary.cft;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import org.lkathary.cft.models.CommandLine;
import org.lkathary.cft.models.Solution;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(args));

        CommandLine commandLine = new CommandLine();

//        JCommander.newBuilder()
//                .addObject(commandLine)
//                .build()
//                .parse(args);

        JCommander jc = new JCommander();
        jc.addObject(commandLine);
        try {
            jc.parse(args);
        } catch (ParameterException ex) {
            System.err.println(ex.getMessage());
            jc.usage();
            System.exit(1);
        }

        System.out.println("path: " + commandLine.getPath());
        System.out.println("prefix: " + commandLine.getPrefix());
        System.out.println("append: " + commandLine.getAppend());
        System.out.println("short stat: " + commandLine.getShortStat());
        System.out.println("full stat: " + commandLine.getFullStat());
        System.out.println("files: " + commandLine.getFiles());

        Solution solution = new Solution(commandLine);
        solution.read();
        solution.filter();
        solution.statistic();
        solution.save();
    }
}