package io.github.hoshinojyunn.miraiclient4j.bot.strategy;

/**
 * @Author HuJunkui
 * @Date 2023 09 14
 **/
public class MessageValidateStrategyDefault implements MessageValidateStrategy{
    @Override
    public boolean isCommand() {
        return false;
    }
}
