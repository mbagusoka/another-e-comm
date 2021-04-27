package com.another.user.core.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;

import javax.validation.Validation;
import javax.validation.Validator;
import java.util.function.Predicate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Randomizer {

    private static final EasyRandom RANDOM = getGenerator();

    private static EasyRandom getGenerator() {
        EasyRandomParameters parameters = new EasyRandomParameters()
            .randomize(Validator.class, () -> Validation.buildDefaultValidatorFactory().getValidator())
            .randomize(FieldPredicates.named("email"), () -> "dum@m.y");

        return new EasyRandom(parameters);
    }

    public static <T> T get(Class<T> klazz) {
        return RANDOM.nextObject(klazz);
    }
}
