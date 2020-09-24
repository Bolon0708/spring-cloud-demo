package com.softdev.system.demo.util;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;

/**
 * @Description: TODO
 * @ClassName: DingDingUtils
 * @Author: liangbl
 * @Date: 2020/7/29 15:55
 */
public class DingTalkUtils {
    private static final String SERVERURL = "https://oapi.dingtalk.com/robot/send?access_token=27a944f4c1cb2e180d71c10eb3289af6d500349363126117d4f0de66f37ddd43";
    private static final String MSGTYPE = "text";

    public static void main(String[] args) {
        sendExceptionMsg("测试文本消息");
    }

    public static void sendExceptionMsg(String content) {
        DingTalkClient client = new DefaultDingTalkClient(SERVERURL);
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype(MSGTYPE);
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent("【异常监控】" + content);
        request.setText(text);
        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        // isAtAll类型如果不为Boolean，请升级至最新SDK
        at.setIsAtAll(true);
        request.setAt(at);
        try {
            OapiRobotSendResponse response = client.execute(request);
            System.out.println("发送结果：" + response.getBody());
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }
}
