package com.sopt.week4.config.resolver;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // 어노테이션 생성될 수 있는 위치 지정
@Retention(RetentionPolicy.RUNTIME) // 어노테이션 유효 기간
public @interface UserId {
}
