package io.mcandrews.raft.core.fsm;

import io.mcandrews.raft.core.Node;

public interface NodeUpdateVisitor {
    void visit(Node node);
}
