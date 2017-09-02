package com.github.raipc.logconsumer;

import ch.qos.logback.core.FileAppender;

public class FileLogStrategy implements LogStrategy {
    public FileLogStrategy(FileAppender appender) {
        throw new UnsupportedOperationException();
    }

    @Override
    public byte[] read() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }
}
