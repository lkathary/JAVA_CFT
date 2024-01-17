package org.lkathary.cft;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import org.lkathary.cft.models.CommandLine;
import org.lkathary.cft.models.Solution;

public class Main {
    public static void main(String[] args) {

        CommandLine commandLine = new CommandLine();
        JCommander jc = JCommander.newBuilder().addObject(commandLine).build();
        try {
            jc.parse(args);
            if(args.length == 0) {
                jc.usage();
                return;
            }
        } catch (ParameterException ex) {
            System.err.println(ex.getMessage());
            jc.usage();
            System.exit(1);
        }

        Solution solution = new Solution(commandLine);
        solution.read();
        solution.filter();
        solution.statistic();
        solution.save();
    }
}
