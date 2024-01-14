package org.lkathary.cft.filters;

import java.util.Optional;

public class IntegerFilter implements BaseFilter{
    @Override
    public Optional<Integer> parse(String line) {
        try {
            return Optional.of(Integer.parseInt(line));
        } catch (Exception ignored) {
            return Optional.empty();
        }
    }
}
