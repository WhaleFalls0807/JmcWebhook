package com.whaleal.jmcwebhook.bean;

import lombok.Data;
import lombok.ToString;

/**
 * @author lyz
 * @desc
 * @date 2022-05-12 10:24
 */
@Data
@ToString
public class MmsEntity {

    private String msisdn;

    private String to;

    private String network_code;

    private String messageId;

    private String status;

    private String scts;

    private String err_code;

    private String api_key;

    private String message_timestamp;

}
