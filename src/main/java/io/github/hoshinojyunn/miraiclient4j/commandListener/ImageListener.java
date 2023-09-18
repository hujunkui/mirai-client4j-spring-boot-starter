package io.github.hoshinojyunn.miraiclient4j.commandListener;

import io.github.hoshinojyunn.miraiclient4j.aspect.annotation.CommandListener;
import io.github.hoshinojyunn.miraiclient4j.aspect.annotation.OnCommand;
import io.github.hoshinojyunn.miraiclient4j.bot.Bot;
import io.github.hoshinojyunn.miraiclient4j.message.MessageChain;
import io.github.hoshinojyunn.miraiclient4j.message.MessageEvent;
import io.github.hoshinojyunn.miraiclient4j.message.baseType.Image;
import io.github.hoshinojyunn.miraiclient4j.message.baseType.Plain;

import javax.annotation.Resource;

@CommandListener
public class ImageListener {
    @Resource
    private Bot bot;

    @OnCommand(command = ".image*")
    public void sendImage(MessageEvent event) {
        MessageChain messageChain = new MessageChain();
        messageChain.appendLast(new Plain("你要的图片")).appendLast(new Image("https://tse1-mm.cn.bing.net/th/id/OIP-C.YKoZzgmubNBxQ8j-mmoTKAHaEK?pid=ImgDet&rs=1"));
        bot.send(event, messageChain, false);
    }
}
