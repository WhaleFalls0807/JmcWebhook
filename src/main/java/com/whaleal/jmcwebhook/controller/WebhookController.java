package com.whaleal.jmcwebhook.controller;

import com.whaleal.jmcwebhook.bean.MmsEntity;
import com.whaleal.jmcwebhook.bean.WebhookEntity;
import com.whaleal.jmcwebhook.utils.JwtHelper;
import com.whaleal.jmcwebhook.utils.R;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.Document;
import java.util.Map;

/**
 * @author lyz
 * @desc
 * @date 2022-05-11 18:35
 */
@RestController
@RequestMapping
public class WebhookController {

    @PostMapping()
    public R test(@RequestBody MmsEntity webhookEntity,
                  HttpServletRequest httpServletRequest){

        if(ObjectUtils.isEmpty(webhookEntity)){
            return R.error().put("data","请求参数为空");
        }

        String authorization = httpServletRequest.getHeader("authorization");
        if(!ObjectUtils.isEmpty(authorization)){
            String token = authorization.split(" ")[1];

            if(!ObjectUtils.isEmpty(token) && token.length() > 0){
                if(!JwtHelper.authToken(token)){
                    return R.error().put("status",401);
                }
            }
        }

        webhookEntity.setErr_code(httpServletRequest.getParameter("err-code"));
        webhookEntity.setNetwork_code(httpServletRequest.getParameter("network_code"));
        webhookEntity.setApi_key(httpServletRequest.getParameter("api-key"));
        webhookEntity.setMessage_timestamp(httpServletRequest.getParameter("message_timestamp"));


        System.out.println("-------------------------------------------");
        System.out.println("完整的参数如下：");
        System.out.println(webhookEntity);
        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        for (Map.Entry<String,String[]>  m  : parameterMap.entrySet()){

            String[] value = m.getValue();
            for (int i = 0; i < value.length; i++) {
                System.out.println(m.getKey() + "" + value[i]);

            }
        }
        

        return R.ok().put("status",205).put("data","请求成功");
    }
}
