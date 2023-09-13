package io.github.hoshinojyunn.miraiclient4j.bot.strategy;

import cn.hutool.json.JSONObject;
import io.github.hoshinojyunn.miraiclient4j.adapter.HttpApiClient;
import io.github.hoshinojyunn.miraiclient4j.utils.R;
import io.github.hoshinojyunn.miraiclient4j.message.MessageBuilder;
import io.github.hoshinojyunn.miraiclient4j.message.MessageChain;
import io.github.hoshinojyunn.miraiclient4j.message.messageRequest.request.GroupMessage;

public class GroupStrategy implements SendStrategy{
    private MessageChain chain;
    private HttpApiClient httpApiClient;
    private Long id;

    private int messageId;

    public GroupStrategy(MessageChain chain, HttpApiClient httpApiClient, Long id) {
        this.chain = chain;
        this.httpApiClient = httpApiClient;
        this.id = id;
    }
    public GroupStrategy(MessageChain chain, HttpApiClient httpApiClient, Long id, int messageId) {
        this.chain = chain;
        this.httpApiClient = httpApiClient;
        this.id = id;
        this.messageId = messageId;
    }

    @Override
    public R<JSONObject> doStrategy() {
        GroupMessage groupMessage = MessageBuilder.buildGroupMessage(id, chain, messageId);
        return httpApiClient.sendGroupMessage(groupMessage);
    }
}
