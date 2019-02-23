package com.huiketong.catshopkeeper.api.service;

import com.huiketong.catshopkeeper.util.GsonUtils;
import com.huiketong.catshopkeeper.util.HttpUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 左飞
 * @Date: 2019/2/14 15:53
 * @Version 1.0
 */
public class FaceSearchService {
    public static String search(String group_id,String image,String accessToken) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/search";
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("image", image);
            map.put("liveness_control", "NORMAL");
            map.put("group_id_list", group_id);
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
