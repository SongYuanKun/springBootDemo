package com.songyuankun.test;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class B {
    private final A a;

    public B(A a) {
        this.a = a;
    }
}
