package org.lkathary.cft.filters;

import java.util.Optional;

public class LongFilter implements BaseFilter{
    @Override
    public Optional<Long> parse(String line) {
        try {
            return Optional.of(Long.parseLong(line));
        } catch (Exception ignored) {
            return Optional.empty();
        }
    }
}
