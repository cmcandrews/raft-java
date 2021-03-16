package io.mcandrews.raft.core.persistence;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersistedNodeState {

    void setCurrentTerm(int currentTerm);
    int getCurrentTerm();

    void setVotedFor(UUID votedFor);
    Optional<UUID> getVotedFor();

    void addLogEntry(LogEntry logEntry);
    List<LogEntry> getLogEntries();
}
