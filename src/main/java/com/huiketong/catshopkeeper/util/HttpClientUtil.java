package com.huiketong.catshopkeeper.util;

import com.alibaba.fastjson.JSONObject;
import com.squareup.okhttp.*;

import java.io.IOException;


public class HttpClientUtil {



    public String doPost(String url, String params) throws IOException {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, params);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("cache-control", "no-cache")
                .build();

        Response response = client.newCall(request).execute();
        ResponseBody result=response.body();
        return  result.string();
    }


    public String doGet(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("Content-Type", "application/json")
                .addHeader("cache-control", "no-cache")
                .build();
        Response response = client.newCall(request).execute();
        ResponseBody result=response.body();
        return  result.string();
    }




    public static void main(String[] args) throws IOException {
         String url = "https://guanjiatongtest.anyoucloud.com/api/service/CheckLogin";
         // String url ="https://guanjiatongtest.anyoucloud.com/api/service/GetProductCate?companyCode=4f91fada828b4a4baff87a9dcf65547c&catecode=sys";
          String  params="{\"uid\":15655982371,\"userpassword\":1}";
          HttpClientUtil client = new HttpClientUtil();
        String result = null;
        try {
            result = client.doPost(url,params);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        System.out.println(JSONObject.parse(result));


    }


}
