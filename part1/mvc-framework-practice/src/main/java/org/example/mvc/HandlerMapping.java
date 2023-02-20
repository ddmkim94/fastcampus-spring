package org.example.mvc;

public interface HandlerMapping {
    Object findController(HandlerKey handlerKey);
}
