package io.github.hoshinojyunn.miraiclient4j.message;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import io.github.hoshinojyunn.miraiclient4j.message.baseType.BaseType;
import io.github.hoshinojyunn.miraiclient4j.message.baseType.Plain;

import java.util.*;

public class MessageChain extends LinkedList<JSONObject> {

    public MessageChain appendLast(BaseType baseType) {
        JSONObject object = JSONUtil.parseObj(baseType);
        this.addLast(object);
        return this;
    }

    public MessageChain appendLast(String text) {
        JSONObject object = JSONUtil.parseObj(new Plain(text));
        this.addLast(object);
        return this;
    }

    public MessageChain appendLast(StringBuilder text) {
        this.appendLast(text.toString());
        return this;
    }

    public MessageChain appendFirst(BaseType baseType) {
        JSONObject object = JSONUtil.parseObj(baseType);
        this.addFirst(object);
        return this;
    }

    public MessageChain appendFirst(String text) {
        JSONObject object = JSONUtil.parseObj(new Plain(text));
        this.addFirst(object);
        return this;
    }

    public MessageChain appendFirst(StringBuilder text) {
        this.appendFirst(text.toString());
        return this;
    }


}
