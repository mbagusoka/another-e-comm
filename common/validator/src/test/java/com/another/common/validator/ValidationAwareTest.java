package com.another.common.validator;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidationAwareTest {

    @Test
    void givenNotValidRequest_whenValidate_shouldThrowConstraintViolationException() {
        TestRequest testRequest = new TestRequest("dummy", Collections.emptyList());
        Exception e = assertThrows(ConstraintViolationException.class, testRequest::validate);
        assertEquals("someList: must not be empty", e.getMessage());
    }

    static class TestRequest extends ValidationAware<TestRequest> {

        @NotBlank
        private final String someString;

        @NotEmpty
        private final List<String> someList;

        public TestRequest(String someString, List<String> someList) {
            this.someString = someString;
            this.someList = someList;
        }

    }

}
