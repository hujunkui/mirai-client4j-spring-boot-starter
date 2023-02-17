package org.hoshino.miraiclient4j.processor;

import org.hoshino.miraiclient4j.message.MessageEvent;

@FunctionalInterface
public interface Processor {
    void process(MessageEvent message, String cmd) throws Exception;
}
