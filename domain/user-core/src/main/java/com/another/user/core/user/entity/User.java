package com.another.user.core.user.entity;

public interface User {

    Long getId();

    String getEmail();

    String getName();

    String getPhone();

    String getPassword();

    boolean isActive();
}
