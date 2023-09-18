package io.github.hoshinojyunn.miraiclient4j.bot.strategy;

/**
 * @author 53564
 */
public interface MessageValidateStrategy {

    /**
     * 判断是否是命令
     * @return true or false
     */
    boolean isCommand();
}
