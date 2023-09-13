package io.github.hoshinojyunn.miraiclient4j.bot;

import io.github.hoshinojyunn.miraiclient4j.message.MessageChain;
import io.github.hoshinojyunn.miraiclient4j.message.baseType.BaseType;
import io.github.hoshinojyunn.miraiclient4j.message.MessageEvent;

public interface Action {

    void send(MessageEvent event, BaseType[] message, Boolean atSender);

    void send(MessageEvent event, MessageChain chain, Boolean atSender);

    void send(MessageEvent event, BaseType[] message);

    void send(MessageEvent event, MessageChain chain);

    void sendQuoteMessage(MessageEvent event, BaseType[] message);

    void sendQuoteMessage(MessageEvent event, MessageChain chain);
}
