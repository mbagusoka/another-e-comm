package com.another.common.validator;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * This abstract taken from "Get Your Hands Dirty on Clean Architecture (Tom Hombergs)"
 * {@see <a href="https://reflectoring.io/book/">Tom Hombergs's Clean Architecture</a>}
 * <p>
 * Example:
 * <pre>
 * {@code
 *
 *     public class SomeRequest extends ValidationAware<SomeRequest> {
 *
 *       {@literal @}NotBlank
 *       private final String someString;
 *
 *       {@literal @}@NotEmpty
 *       private final List<String> someList;
 *
 * 		 public TestRequest(String someString, List<String> someList) {
 * 		   this.someString = someString;
 * 		   this.someList = someList;
 *       }
 *     }
 *
 *     // method which use SomeRequest as param
 *     public void execute(SomeRequest request) {
 *       request.validate(); // will throw {@link ConstraintViolationException} if failed.
 *       // do something
 *     }
 * }
 * </pre>
 */
@SuppressWarnings("unchecked")
public abstract class ValidationAware<T> {

    private final Validator validator;

    protected ValidationAware() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public void validate() {
        Set<ConstraintViolation<T>> violations = validator.validate((T) this);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
