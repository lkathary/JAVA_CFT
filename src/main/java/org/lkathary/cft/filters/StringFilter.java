package org.lkathary.cft.filters;

import java.util.Optional;

public class StringFilter implements BaseFilter {
    @Override
    public Optional<String> parse(String line) {
        return Optional.of(line);
    }
}
