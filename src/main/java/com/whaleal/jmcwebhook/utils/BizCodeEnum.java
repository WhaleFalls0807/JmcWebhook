package com.whaleal.jmcwebhook.utils;


/**
 * Description：
 * 错误码列表：
 * 9: 通用 。开头的code的msg不进行前端展示
 * 10 ：标识正常执行的代码 无msg
 * 11: 用户
 * 12: agent
 * <p>
 * <p>
 *
 * @author: lhp
 * @Date: 2021 /09/27
 */
public enum BizCodeEnum {


    /**
     * Unknown exception biz code enum.
     */
    UNKNOWN_EXCEPTION(901, "系统未知异常"),
    /**
     * Error system biz code enum.
     */
    ERROR_SYSTEM(902, "系统错误"),

    LIMIT_GATEWAY(903, "Gateway current limit, please try again later"),

    /**
     * Error exe command biz code enum.
     */
    ERROR_EXE_COMMAND(903, "更新命令状态失败"),

    SUCCESS_CODE(1000, "正常执行"),
    /**
     * Not exist account biz code enum.
     */
    NOT_EXIST_ACCOUNT(1101, "账号不存在"),
    /**
     * Error password biz code enum.
     */
    ERROR_PASSWORD(1102, "密码错误"),
    /**
     * Blank account biz code enum.
     */
    BLANK_ACCOUNT(1103, "账号不可为空"),
    /**
     * Exist phone biz code enum.
     */
    EXIST_PHONE(1104, "手机号已存在"),
    /**
     * Exist email biz code enum.
     */
    EXIST_EMAIL(1105, "邮箱已存在"),
    /**
     * Exist account biz code enum.
     */
    EXIST_ACCOUNT(1106, "账号已存在"),
    /**
     * Not exist token biz code enum.
     */
    NOT_EXIST_TOKEN(1107, "TOKEN不存在"),
    ERROR_UPDATE_MEMBER(1108, "更新信息失败"),
    /**
     * Not exist agent id biz code enum.
     */
    NOT_EXIST_AGENT_ID(1201, "agentId不存在"),
    /**
     * Error save agent log biz code enum.
     */
    ERROR_SAVE_AGENT_LOG(1202, "日志信息保存失败"),
    /**
     * Error down load file biz code enum.
     */
    ERROR_DOWN_LOAD_FILE(1203, "文件下载失败"),

    /**
     * Ops common exception biz code enum.
     */
    OPS_COMMON_EXCEPTION(1900, ""),

    /**
     * Not exist data biz code enum.
     */
    NOT_EXIST_DATA(1901, "数据不存在");


    private int code;

    private String msg;

    BizCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * Gets msg.
     *
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }
}
