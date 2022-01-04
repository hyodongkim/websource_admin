package com.teachingcash.common;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

import java.text.MessageFormat;
import java.util.Locale;

public class Prop implements MessageSourceAware {

    private static MessageSource msg;

    public void setMessageSource (MessageSource msg) {
        Prop.msg = msg;
    }

    /**
     * 시스템 속성을 얻기위한 함수
     * 호출 내용은 기존 메시지와 동일하나 기능적으로 구분하기 위해서 추가한 메소드 이다.
     */
    public static String prop(String key) {
        return Prop.msg(key);
    }

    public static String prop(String key, Locale locale) {
        return Prop.msg(key, locale);
    }

    public static String propFormat(String key, Object...objects) {
        return MessageFormat.format(Prop.msg(key),objects);
    }

    public static String propFormat(String key, Locale locale, Object...objects) {
        return MessageFormat.format(Prop.msg(key, locale),objects);
    }

    /**
     * 메지시를 리턴한다.
     */
    public static String msg(String key){
        return msg.getMessage(key, null, Locale.getDefault());
    }

    public static String msg(String key, Locale locale){
        return msg.getMessage(key, null, locale);
    }
}
