package com.another.product.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.jeasy.random.EasyRandom;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Randomizer {

    private static final EasyRandom RANDOM = new EasyRandom();

    public static <T> T get(Class<T> klazz) {
        return RANDOM.nextObject(klazz);
    }
}
