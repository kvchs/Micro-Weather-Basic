package com.example.demo.util;

import com.example.demo.vo.City;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonBuilder {

    /**
     * 将Json转换为PoJo
     * https://blog.csdn.net/zhangphil/article/details/80004082
     *
     * @param jsonStr
     * @return
     *
     */

    public static List<City> jsonStringToCityList(String jsonStr){

        /**
         * 解决解析失败问题：https://my.oschina.net/u/3126720/blog/803478
         */
        Gson gson = new Gson();
        // Json转换为PoJo
        List<City> list = new ArrayList<>();
        Type listType = new TypeToken<List<City>>() {}.getType();
        return gson.fromJson(jsonStr, listType);
    }
}
