package com.huiketong.catshopkeeper.api.service;

import com.huiketong.catshopkeeper.util.GsonUtils;
import com.huiketong.catshopkeeper.util.HttpUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 左飞
 * @Date: 2019/2/16 8:57
 * @Version 1.0
 * 人脸检测
 */
public class FaceDetectService {
    public static String detect(String accessToken,String image) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/detect";
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("image", image);
            map.put("face_field", "faceshape,facetype");
            map.put("image_type", "BASE64");
            map.put("face_type","LIVE");
            map.put("max_face_num",1);
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
