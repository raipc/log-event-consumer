package com.github.raipc.logconsumer;

public class NoopLogStrategy implements LogStrategy {
    private static final byte[] EMPTY_ARRAY = new byte[0];

    @Override
    public byte[] read() {
        return EMPTY_ARRAY;
    }

    @Override
    public void clear() {

    }
}
