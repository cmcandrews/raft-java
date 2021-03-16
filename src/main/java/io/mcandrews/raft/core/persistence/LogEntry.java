package io.mcandrews.raft.core.persistence;

import java.util.Objects;

public class LogEntry {
    private final String command;
    private final int termWhenReceivedByLeader;

    public LogEntry(String command, int termWhenReceivedByLeader) {
        this.command = Objects.requireNonNull(command);
        this.termWhenReceivedByLeader = termWhenReceivedByLeader;
    }

    public String getCommand() {
        return command;
    }

    public int getTermWhenReceivedByLeader() {
        return termWhenReceivedByLeader;
    }
}
