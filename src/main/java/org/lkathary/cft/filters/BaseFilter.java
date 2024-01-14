package org.lkathary.cft.filters;

import java.util.Optional;

public interface BaseFilter {
    Optional<?> parse(String line);
}
