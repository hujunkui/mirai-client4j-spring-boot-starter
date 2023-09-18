package io.github.hoshinojyunn.miraiclient4j.utils;

import io.github.hoshinojyunn.miraiclient4j.message.MessageChain;
import io.github.hoshinojyunn.miraiclient4j.message.baseType.BaseType;
import io.github.hoshinojyunn.miraiclient4j.message.baseType.Plain;

import java.util.List;

public class MessageUtil {

    public static MessageChain buildMessage(BaseType message) {
        return new MessageChain().appendLast(message);
    }

    public static MessageChain buildMessage(String message) {
        return new MessageChain().appendLast(new Plain(message));
    }

    public static MessageChain buildMessage(StringBuilder message) {
        return buildMessage(message.toString());
    }

    public static MessageChain buildMessage(List<BaseType> messageList) {
        MessageChain messageChain = new MessageChain();
        for (BaseType baseType : messageList) {
            messageChain.appendLast(baseType);
        }
        return messageChain;
    }
}
