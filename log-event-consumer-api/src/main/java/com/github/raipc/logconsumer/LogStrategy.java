package com.github.raipc.logconsumer;

public interface LogStrategy {
    byte[] read();

    void clear();
}