package io.github.hoshinojyunn.miraiclient4j.aspect.annotation;

import cn.hutool.core.annotation.Alias;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 53564
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OnCommand {
    @Alias("value")
    String command() default "";

    @Alias("command")
    String value() default "";

    String[] alias() default {};

    boolean at() default true;
}
