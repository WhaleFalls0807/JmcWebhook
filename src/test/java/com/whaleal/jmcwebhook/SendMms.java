package com.whaleal.jmcwebhook;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author lyz
 * @desc
 * @date 2022-05-12 9:59
 */
public class SendMms {

    public JSONObject sendVonage() throws IOException {

        String key = "b1c0dc26";
        String secret = "Aa1a705104428b34677a13ee";
        String from = "锦木";
        String to = "15617339317";
        String msg = "test";
        String type = "text";

        String url = "https://rest.nexmo.com/sms/json";
        Connection connection = Jsoup.connect(url)
                .ignoreContentType(true);
        connection.header("Content-Type", "application/x-www-form-urlencoded");
        connection.data("api_key", key);
        connection.data("api_secret", secret);
        connection.data("from", from);
        connection.data("to", to);
        connection.data("text", msg);
        connection.data("type", type);
        connection.data("client-ref",  "jinmu-pDJ4hfqkC");
        Document doc = connection.post();
        String bodyStr = doc.body().ownText();
        return JSON.parseObject(bodyStr);
    }

    public JSONObject sendVonage1() throws IOException {

        String key = "b1c0dc26";
        String secret = "Aa1a705104428b34677a13ee";
        String from = "锦木";
        String to = "8615617339317";
        String msg = "test";
        String type = "text";

        String url = "https://rest.nexmo.com/sms/json";
        Connection connection = Jsoup.connect(url)
                .ignoreContentType(true);
        connection.data("api_key", key);
        connection.data("api_secret", secret);
        connection.data("from", from);
        connection.data("to", to);
        connection.data("text", msg);
        Document doc = connection.post();
        String bodyStr = doc.body().ownText();
        return JSON.parseObject(bodyStr);
    }


    public static void main(String[] args) {
        SendMms sendMms = new SendMms();
        JSONObject jsonObject;
        try {
            jsonObject = sendMms.sendVonage1();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(jsonObject);
    }
}
