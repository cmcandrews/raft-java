package io.mcandrews.raft.core;

import java.time.Duration;
import java.time.Instant;
import java.util.Objects;

public class Timer {

    private final Instant start;
    private final Duration interval;

    public Timer(Duration interval) {
        this.start = Instant.now();
        this.interval = Objects.requireNonNull(interval);
    }

    public boolean timedOut() {
        final var now = Instant.now();
        return now.isAfter(start.plus(interval));
    }
}
