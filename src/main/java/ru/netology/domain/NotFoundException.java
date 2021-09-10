package ru.netology.domain;

import java.util.Objects;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String s) {
        super(s);
    }
}
