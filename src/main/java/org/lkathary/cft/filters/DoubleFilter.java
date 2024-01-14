package org.lkathary.cft.filters;

import java.util.Optional;

public class DoubleFilter implements BaseFilter {
    @Override
    public Optional<Double> parse(String line) {
        try {
            return Optional.of(Double.parseDouble(line));
        } catch (Exception ignored) {
//            System.out.println("Error occurred:- " + ignored);
            return Optional.empty();
        }
    }
}
