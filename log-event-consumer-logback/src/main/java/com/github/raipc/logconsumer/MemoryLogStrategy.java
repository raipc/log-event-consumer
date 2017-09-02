package com.github.raipc.logconsumer;

import java.io.ByteArrayOutputStream;

public class MemoryLogStrategy implements LogStrategy {
    private final ByteArrayOutputStream byteArrayOutputStream;

    public MemoryLogStrategy(MemoryAppender appender) {
        this.byteArrayOutputStream = appender.getOutputStream();
    }

    @Override
    public byte[] read() {
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public void clear() {
        byteArrayOutputStream.reset();
    }
}
