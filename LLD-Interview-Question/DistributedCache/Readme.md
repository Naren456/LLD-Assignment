# Distributed Cache System

A flexible and extensible in-memory Distributed Cache implementation in Java. This project demonstrates low-level design (LLD) principles using pluggable strategies for data distribution and cache eviction.

## Features

- **Distributed Architecture**: Cache is spread across multiple configurable nodes.
- **Cache-Aside Pattern**: Automatically fetches from the database on cache misses and populates the cache.
- **Pluggable Distribution Strategy**: Decouples the logic for mapping keys to nodes.
- **Pluggable Eviction Policy**: Supports different algorithms to manage node capacity (e.g., LRU).

## Design Overview

### Components

1. **`DistributedCache`**: The entry point that orchestrates requests between the distribution strategy and cache nodes.
2. **`DistributionStrategy`**: Interface for key-to-node mapping.
   - `ModuloDistributionStrategy`: Default implementation using `hash(key) % numNodes`.
3. **`CacheNode`**: Represents an individual storage unit with its own capacity and eviction policy.
4. **`EvictionPolicy`**: Interface for cache eviction logic.
   - `LRUEvictionPolicy`: Uses a Doubly Linked List and HashMap for O(1) performance.
5. **`Database`**: A simple mock representing the persistent data store.


## Getting Started

### Prerequisites

- JDK 8 or higher.

### Compilation

From the project root (`LLD-Interview-Question/DistributedCache`):

```bash
javac -d out src/main/java/org/example/**/*.java src/main/java/org/example/*.java
```

### Running the Demo

```bash
java -cp out org.example.Main
```

## Extensibility

### Adding a new Distribution Strategy
Implement the `DistributionStrategy` interface and pass your new implementation to the `DistributedCache` constructor.
```java
public class ConsistentHashingStrategy implements DistributionStrategy {
    @Override
    public int selectNode(String key, int numNodes) {
        // Your logic here
    }
}
```

### Adding a new Eviction Policy
Implement the `EvictionPolicy` interface and provide it when initializing `CacheNode` instances.
```java
public class LFUEvictionPolicy implements EvictionPolicy {
    // Your logic here
}
```
