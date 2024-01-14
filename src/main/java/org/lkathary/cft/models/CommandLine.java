package org.lkathary.cft.models;

import com.beust.jcommander.Parameter;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CommandLine {
    @Parameter(description = "файлы")
    private List<String> files = new ArrayList<>();

    @Parameter(names = "-o", description = "Path for results")
    private String path;

    @Parameter(names = "-p", description = "Output filenames prefix")
    private String prefix;

    @Parameter(names = "-a", description = "Append mode for output files")
    private Boolean append = false;

    @Parameter(names = "-s", description = "Get short statistics")
    private Boolean shortStat = false;

    @Parameter(names = "-f", description = "Get full statistics")
    private Boolean fullStat = false;

}
