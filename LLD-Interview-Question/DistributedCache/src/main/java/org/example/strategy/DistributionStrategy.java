package org.example.strategy;

public interface DistributionStrategy {
    int selectNode(String key, int numNodes);
}
