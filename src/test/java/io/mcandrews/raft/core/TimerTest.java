package io.mcandrews.raft.core;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class TimerTest {
    @Test
    void shouldBeTimedOut() throws InterruptedException {
        // Given
        final var duration = Duration.of(500, ChronoUnit.MILLIS);
        final var timer = new Timer(duration);
        final var countdownLatch = new CountDownLatch(1);

        // When
        countdownLatch.await(1000, TimeUnit.MILLISECONDS);
        final var result = timer.timedOut();

        // Then
        assertThat(result, is(equalTo(true)));
    }

    @Test
    void shouldNotBeTimedOut() throws InterruptedException {
        // Given
        final var duration = Duration.of(500, ChronoUnit.MILLIS);
        final var timer = new Timer(duration);
        final var countdownLatch = new CountDownLatch(1);

        // When
        countdownLatch.await(250, TimeUnit.MILLISECONDS);
        final var result = timer.timedOut();

        // Then
        assertThat(result, is(equalTo(false)));
    }
}