package com.huiketong.catshopkeeper.api.service;

import com.huiketong.catshopkeeper.util.GsonUtils;
import com.huiketong.catshopkeeper.util.HttpUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 左飞
 * @Date: 2019/2/14 9:49
 * @Version 1.0
 */
public class FaceRegisterService {
    public static String add(String base64Image,String group_id,String user_id,String user_info,String accessToken) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add";
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("image", base64Image);
            map.put("group_id", group_id);
            map.put("user_id", user_id);
            map.put("user_info", user_info);
            map.put("liveness_control", "NORMAL");
            map.put("image_type", "BASE64");
            map.put("quality_control", "LOW");
            String param = GsonUtils.toJson(map);
            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
