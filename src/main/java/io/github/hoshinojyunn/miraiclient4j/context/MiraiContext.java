package io.github.hoshinojyunn.miraiclient4j.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.configurationprocessor.json.JSONException;

import java.lang.reflect.Method;
import java.util.*;

public class MiraiContext {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private String verifyKey;
    private String session;
    private Long qq;
    private Map<String, Method> processFunction;

    private Map<String, Method> processFunctionOther;
    private Map<Method, Object> processBean;

    public MiraiContext() {
    }

    public MiraiContext(String verifyKey, String session, Long qq) throws JSONException {
        this.verifyKey = verifyKey;
        this.session = session;
        this.qq = qq;
    }


    /**
     * 匹配命令对应的方法
     * @param cmd 命令名称
     * @return
     */
    public Optional<Method> findProcessFunction(String cmd) {
        /**
         * 先匹配完全匹配的命令
         */
        Method method = processFunction.get(cmd);
        if (method == null) {
            /**
             * 然后匹配前缀命令
             */
            for (String s : processFunctionOther.keySet()) {
                if (cmd.startsWith(s)) {
                    return Optional.ofNullable(processFunctionOther.get(s));
                }
            }
        }
        return Optional.ofNullable(method);
    }

    public Optional<Object> findBeanWithMethod(Method method) {
        return Optional.ofNullable(processBean.get(method));
    }

    public Long getQq() {
        return qq;
    }

    public void setQq(Long qq) {
        this.qq = qq;
    }

    public String getVerifyKey() {
        return verifyKey;
    }

    public void setVerifyKey(String verifyKey) {
        this.verifyKey = verifyKey;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public Map<String, Method> getProcessFunction() {
        return processFunction;
    }

    public void setProcessFunction(Map<String, Method> processFunction) {
        this.processFunction = processFunction;
    }

    public void setProcessFunctionOther(Map<String, Method> processFunctionOther) {
        this.processFunctionOther = processFunctionOther;
    }

    public Map<Method, Object> getProcessBean() {
        return processBean;
    }

    public void setProcessBean(Map<Method, Object> processBean) {
        this.processBean = processBean;
    }

}
