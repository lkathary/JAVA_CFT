package org.lkathary.cft.filters;

import java.math.BigInteger;
import java.util.Optional;

public class BigIntegerFilter implements BaseFilter {
    @Override
    public Optional<BigInteger> parse(String line) {
        try {
            return Optional.of(new BigInteger(line));
        } catch (Exception ignored) {
            return Optional.empty();
        }
    }
}
