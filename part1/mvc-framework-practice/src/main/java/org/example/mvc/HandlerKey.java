package org.example.mvc;

import org.example.mvc.controller.RequestMethod;

import java.util.Objects;

public class HandlerKey {
    private final RequestMethod method;
    private final String uriPath;

    public HandlerKey(RequestMethod method, String uriPath) {
        this.method = method;
        this.uriPath = uriPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HandlerKey that = (HandlerKey) o;
        return method == that.method && Objects.equals(uriPath, that.uriPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, uriPath);
    }
}
