package com.huiketong.catshopkeeper.api;

import com.huiketong.catshopkeeper.api.service.AuthService;
import com.huiketong.catshopkeeper.api.service.FaceRegisterService;
import com.huiketong.catshopkeeper.api.service.FaceSearchService;
import com.huiketong.catshopkeeper.api.service.FaceVerify;
import com.huiketong.catshopkeeper.data.RespData;
import com.huiketong.catshopkeeper.entity.TokenManager;
import com.huiketong.catshopkeeper.service.TokenManagerService;
import com.huiketong.catshopkeeper.util.DateUtil;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author: 左飞
 * @Date: 2019/2/14 8:52
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "api")
public class ApiController {

    @Resource
    TokenManagerService tokenManagerService;

    @PostMapping(value = "updateToken")
    public RespData updateToken(String deviceId){
        RespData data = new RespData();
        TokenManager existtoken = tokenManagerService.queryByDeviceId(deviceId);
        if(ObjectUtils.isEmpty(existtoken))
        {
            TokenManager tokenManager = new TokenManager();
            tokenManager.setDeviceId(deviceId);
            tokenManager.setUpdateTime(new Date());
            tokenManager.setAccessToken(AuthService.getAuth());
            try {
                tokenManagerService.insert(tokenManager);
                data.setCode(0);
                data.setMsg("保存成功");
            }catch (Exception e){
                e.printStackTrace();
                data.setCode(-1);
                data.setMsg("保存失败");
            }
        }else{
            if(DateUtil.differentDays(existtoken.getUpdateTime(),new Date()) >= 30)
            {
                TokenManager tokenManager = new TokenManager();
                tokenManager.setDeviceId(deviceId);
                tokenManager.setUpdateTime(new Date());
                tokenManager.setAccessToken(AuthService.getAuth());
                tokenManagerService.update(tokenManager);
                data.setCode(500);
                data.setMsg("更新Token成功");
            }else{
                data.setCode(200);
                data.setMsg("无需更新Token");
            }
        }
        return data;
    }

    @PostMapping(value = "register_face")
    public String registerFace(String deviceId,String image,String group_id,String user_id,String user_info){
        TokenManager tokenManager = tokenManagerService.queryByDeviceId(deviceId);
        String response = null;
        if(!ObjectUtils.isEmpty(tokenManager))
        {
            if(DateUtil.differentDays(tokenManager.getUpdateTime(),new Date()) >= 30)
            {
                String accessToken = updateTime(deviceId);
              response = FaceRegisterService.add(image,group_id,user_id,user_info,accessToken);
            }
            else{
                response = FaceRegisterService.add(image,group_id,user_id,user_info,tokenManager.getAccessToken());
            }
            return response;
        }else{
            return "注册人脸失败";
        }

    }

    private String updateTime(String deviceId) {
        TokenManager tokenManager1 = new TokenManager();
        String accessToken = AuthService.getAuth();
        tokenManager1.setDeviceId(deviceId);
        tokenManager1.setAccessToken(accessToken);
        tokenManager1.setUpdateTime(new Date());
        tokenManagerService.update(tokenManager1);
        return accessToken;
    }

    @PostMapping(value = "face_search")
    public String searchFace(String deviceId,String image,String group_id){
        TokenManager tokenManager = tokenManagerService.queryByDeviceId(deviceId);
        String respone = null;
        if(!ObjectUtils.isEmpty(tokenManager))
        {
            if(DateUtil.differentDays(tokenManager.getUpdateTime(),new Date()) >= 30)
            {
                String accessToken = updateTime(deviceId);
                respone = FaceSearchService.search(group_id,image,accessToken);
            }
            else{
                respone = FaceSearchService.search(group_id,image,tokenManager.getAccessToken());
            }
            return respone;
        }else{
            return "搜索人脸失败";
        }
    }

    @PostMapping(value = "face_verify")
    public String verifyFace(String deviceId,String image){
        TokenManager tokenManager = tokenManagerService.queryByDeviceId(deviceId);
        String respone = null;
        if(!ObjectUtils.isEmpty(tokenManager))
        {
            if(DateUtil.differentDays(tokenManager.getUpdateTime(),new Date()) >= 30)
            {
                String accessToken = updateTime(deviceId);
                respone = FaceVerify.faceVerify(image,accessToken);
            }
            else{
                respone = FaceVerify.faceVerify(image,tokenManager.getAccessToken());
            }
            return respone;
        }else{
            return "活体检测失败";
        }
    }
}
