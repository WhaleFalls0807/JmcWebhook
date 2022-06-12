package com.whaleal.jmcwebhook.bean;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author lyz
 * @desc
 * @date 2022-05-11 18:50
 */
@Data
@ToString
public class WebhookEntity {
    private String channel;

    private String message_uuid;

    private String to;

    private String from;

    private Date timestamp;

    private String text;

    private Sms sms;

    private Usage usage;

}
