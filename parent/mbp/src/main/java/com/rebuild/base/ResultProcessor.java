package com.rebuild.base;

import com.rebuild.utils.HttpResult;

@FunctionalInterface
public interface ResultProcessor {
    HttpResult process();
}