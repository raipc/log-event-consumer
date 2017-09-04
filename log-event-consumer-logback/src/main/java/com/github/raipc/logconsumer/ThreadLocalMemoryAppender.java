package com.github.raipc.logconsumer;

import java.io.ByteArrayOutputStream;

public class ThreadLocalMemoryAppender extends AbstractMemoryAppender {
    private final InheritableThreadLocal<ByteArrayOutputStream> outputStream = new InheritableThreadLocal<ByteArrayOutputStream>() {
        @Override
        protected ByteArrayOutputStream initialValue() {
            return new ByteArrayOutputStream();
        }
    };

    @Override
    ByteArrayOutputStream getOutputStream() {
        return outputStream.get();
    }
}
