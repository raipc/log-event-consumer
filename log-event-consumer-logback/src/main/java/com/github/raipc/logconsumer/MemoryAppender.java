package com.github.raipc.logconsumer;

import lombok.AccessLevel;
import lombok.Getter;

import java.io.ByteArrayOutputStream;

public class MemoryAppender extends AbstractMemoryAppender {
    @Getter(AccessLevel.PACKAGE)
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
}