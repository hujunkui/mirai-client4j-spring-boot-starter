package io.github.hoshinojyunn.miraiclient4j.message.messageRequest.request;

import io.github.hoshinojyunn.miraiclient4j.message.MessageChain;
import io.github.hoshinojyunn.miraiclient4j.message.messageRequest.Message;
import io.github.hoshinojyunn.miraiclient4j.message.messageRequest.SessionKey;

/**
 * @Author HuJunkui
 * @Date 2023 09 14
 **/
public class GroupMessageQuote extends GroupMessage {

    // 群号
    private Long target;
    private MessageChain messageChain;

    private int quote;


    public GroupMessageQuote(Long target, MessageChain messageChain) {
        super(target, messageChain);
    }

    public GroupMessageQuote(Long target, MessageChain messageChain, int messageId) {
        super(target, messageChain);
        this.quote = messageId;
    }

    public int getQuote() {
        return quote;
    }

    public void setQuote(int quote) {
        this.quote = quote;
    }
}
