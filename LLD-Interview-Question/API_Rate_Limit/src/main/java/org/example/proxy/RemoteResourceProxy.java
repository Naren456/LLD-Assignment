package org.example.proxy;

import org.example.resource.Resource;
import org.example.strategy.RateLimitingStrategy;

public class RemoteResourceProxy implements Resource {
    private final RateLimitingStrategy rateLimitingStrategy;
    private final Resource remoteResource;

    public RemoteResourceProxy(RateLimitingStrategy rateLimitingStrategy, Resource remoteResource) {
        this.rateLimitingStrategy = rateLimitingStrategy;
        this.remoteResource = remoteResource;
    }

    @Override
    public void getResponse() {
        if (rateLimitingStrategy.limit()) {
            remoteResource.getResponse();
        }
    }
}