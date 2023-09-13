package io.github.hoshinojyunn.miraiclient4j.message.messageRequest.request;

import io.github.hoshinojyunn.miraiclient4j.message.MessageChain;
import io.github.hoshinojyunn.miraiclient4j.message.messageRequest.Message;
import io.github.hoshinojyunn.miraiclient4j.message.messageRequest.SessionKey;

public class GroupMessage extends SessionKey implements Message {
    // 群号
    private Long target;
    private MessageChain messageChain;

    private int quote;



    public GroupMessage(Long target, MessageChain messageChain) {
        this.target = target;
        this.messageChain = messageChain;
    }
    public GroupMessage(Long target, MessageChain messageChain, int messageId) {
        this.target = target;
        this.messageChain = messageChain;
        this.quote = messageId;
    }

    public Long getTarget() {
        return target;
    }

    public void setTarget(Long target) {
        this.target = target;
    }

    public MessageChain getMessageChain() {
        return messageChain;
    }

    public void setMessageChain(MessageChain messageChain) {
        this.messageChain = messageChain;
    }

    public int getQuote() {
        return quote;
    }

    public void setQuote(int quote) {
        this.quote = quote;
    }
}
