package com.huiketong.catshopkeeper.api.service;

import com.huiketong.catshopkeeper.util.GsonUtils;
import com.huiketong.catshopkeeper.util.HttpUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 左飞
 * @Date: 2019/2/22 14:14
 * @Version 1.0
 */
public class FaceVerify {

    public static String faceVerify(String base64Image,String accessToken) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceverify";
        try {
            List<Map> list = new ArrayList<>();
            Map<String, Object> map = new HashMap<>();
            map.put("image", base64Image);
            map.put("image_type", "BASE64");
            //返回年龄，美丑，表情，脸型,性别,是否带眼镜,人种
            map.put("face_field", "age,beauty,expression,face_shape,gender,glasses,race,landmark");
            list.add(map);
            String param = GsonUtils.toJson(list);
            System.out.println(param);
            String result = HttpUtil.post(url, accessToken, "application/json", param);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
