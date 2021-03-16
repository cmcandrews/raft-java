package io.mcandrews.raft.core;

import io.mcandrews.raft.core.fsm.NodeUpdateVisitor;
import io.mcandrews.raft.core.persistence.PersistedNodeState;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class Node {
    private final UUID id;
    private final Set<UUID> peers;
    private final PersistedNodeState persistedNodeState;
    private final long commitIndex;
    private final long indexLastApplied;
    private final NodeUpdateVisitor nodeUpdateVisitor;
    private final Timer electionTimer;

    public Node(UUID id, Set<UUID> peers, PersistedNodeState persistedNodeState, long commitIndex,
                long indexLastApplied, NodeUpdateVisitor nodeUpdateVisitor, Timer electionTimer) {

        this.id = Objects.requireNonNull(id);
        this.peers = Set.copyOf(peers);
        this.persistedNodeState = Objects.requireNonNull(persistedNodeState);
        this.commitIndex = commitIndex;
        this.indexLastApplied = indexLastApplied;
        this.nodeUpdateVisitor = Objects.requireNonNull(nodeUpdateVisitor);
        this.electionTimer = Objects.requireNonNull(electionTimer);
    }

    public void update() {
        nodeUpdateVisitor.visit(this);
    }
}
