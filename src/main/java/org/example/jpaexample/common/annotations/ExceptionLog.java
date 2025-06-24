package org.example.jpaexample.common.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.logging.LogLevel;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExceptionLog {

    LogLevel logLevel() default LogLevel.ERROR;

}
