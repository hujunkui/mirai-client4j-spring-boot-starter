package io.github.hoshinojyunn.miraiclient4j.applicationListener;

import cn.hutool.json.JSONObject;
import io.github.hoshinojyunn.miraiclient4j.adapter.HttpApiClient;
import io.github.hoshinojyunn.miraiclient4j.context.MiraiContext;
import io.github.hoshinojyunn.miraiclient4j.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

public class ApplicationShutdownListener implements ApplicationListener<ContextClosedEvent> {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private HttpApiClient httpApiClient;
    private MiraiContext context;

    public ApplicationShutdownListener(HttpApiClient httpApiClient, MiraiContext context) {
        this.httpApiClient = httpApiClient;
        this.context = context;
    }

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        LOGGER.info("mirai client closed,application will be destroyed soon");
        R<JSONObject> resp = null;
        try {
            resp = httpApiClient.releaseSession(context.getQq());
        } catch (RuntimeException exception) {
            LOGGER.error("session release failed,something went wrong!");
            return;
        }

        if (resp.getData().getInt("code") == 0) LOGGER.info("session release completed");
        else LOGGER.error("something went wrong when contextClosedEvent tried to release session!");
    }
}
