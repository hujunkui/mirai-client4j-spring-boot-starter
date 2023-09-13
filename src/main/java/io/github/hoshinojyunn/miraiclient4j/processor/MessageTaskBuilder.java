package io.github.hoshinojyunn.miraiclient4j.processor;


import io.github.hoshinojyunn.miraiclient4j.context.ApplicationContextHolder;
import io.github.hoshinojyunn.miraiclient4j.context.MiraiContext;
import io.github.hoshinojyunn.miraiclient4j.message.MessageEvent;
import org.springframework.util.Assert;

import java.lang.reflect.Method;

public class MessageTaskBuilder {
    private static MiraiContext context;
    static {
        context = ApplicationContextHolder.getBean(MiraiContext.class).orElse(null);
    }

    public static MessageTask build(MessageEvent event, String cmd){
        if (cmd.endsWith("*")) {
            cmd = cmd.substring(0, cmd.length() - 1);
        }
        Method processFunction = context.findProcessFunction(cmd).orElse(null);
        Assert.notNull(processFunction, "can't find process function of the command");
        Object target = context.findBeanWithMethod(processFunction).orElse(null);
        Assert.notNull(target, "can't find the bean of the method,maybe it isn't inject to spring context");
        Object[]args = new Object[]{event};
        return new MessageTask(processFunction, target,args);
    }

}
