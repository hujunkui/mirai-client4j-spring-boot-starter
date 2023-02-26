package org.hoshino.miraiclient4j.commandListener;

import org.hoshino.miraiclient4j.aspect.annotation.CommandListener;
import org.hoshino.miraiclient4j.aspect.annotation.OnCommand;
import org.hoshino.miraiclient4j.bot.Bot;
import org.hoshino.miraiclient4j.message.MessageChain;
import org.hoshino.miraiclient4j.message.baseType.Plain;
import org.hoshino.miraiclient4j.message.MessageEvent;
import org.hoshino.miraiclient4j.utils.MessageUtil;

import javax.annotation.Resource;

@CommandListener
public class EchoListener {
    private Bot bot;

    public EchoListener(Bot bot) {
        this.bot = bot;
    }

    @OnCommand(command = "/echo")
    public void echo(MessageEvent message) throws Exception {
        String body = MessageUtil.parseBody(message);
        MessageChain messageChain = new MessageChain().append(new Plain(body));
        bot.send(message, messageChain);
    }
}
