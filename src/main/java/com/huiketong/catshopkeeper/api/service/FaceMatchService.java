package com.huiketong.catshopkeeper.api.service;

import com.huiketong.catshopkeeper.util.GsonUtils;
import com.huiketong.catshopkeeper.util.HttpUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 左飞
 * @Date: 2019/2/14 15:39
 * @Version 1.0
 */
public class FaceMatchService {
    public static String match(String image1,String image2,String accessToken) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/match";
        try {
            List<Map<String, Object>> images = new ArrayList<>();

            Map<String, Object> map1 = getStringObjectMap(image1);

            Map<String, Object> map2 = getStringObjectMap(image2);

            images.add(map1);
            images.add(map2);

            String param = GsonUtils.toJson(images);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Map<String, Object> getStringObjectMap(String image) {
        Map<String, Object> map1 = new HashMap<>();
        map1.put("image", image);
        map1.put("image_type", "BASE64");
        map1.put("face_type", "LIVE");
        map1.put("quality_control", "LOW");
        map1.put("liveness_control", "NORMAL");
        return map1;
    }
}
