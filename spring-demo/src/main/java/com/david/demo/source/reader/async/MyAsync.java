package com.david.demo.source.reader.async;

import java.lang.annotation.*;

/**
 * @author fanzunying
 * @date 2021/6/28 19:46
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAsync {
}
