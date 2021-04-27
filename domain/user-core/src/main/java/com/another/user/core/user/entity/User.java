package com.another.user.core.user.entity;

public interface User {

    Long getId();

    String email();

    String name();

    String phone();

    String password();

    boolean isActive();
}
