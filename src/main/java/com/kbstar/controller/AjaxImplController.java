package com.kbstar.controller;

import com.kbstar.dto.Cust;
import com.kbstar.dto.Marker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
public class AjaxImplController {

    @RequestMapping("/getservertime")
    public Object getservertime() {
        Date date = new Date();
        return date;
    }

    @RequestMapping("/checkid")
    public Object checkid(String id) {
        int result = 0;
        if (id.equals("qqqq") || id.equals("aaaa") || id.equals("ssss")) {
            result = 1;
        }
        return result;
    }

    @RequestMapping("/getdata")
    public Object getdata() {
        List<Cust> list = new ArrayList<>();
        list.add(new Cust("id01", "pwd01", "james1"));
        list.add(new Cust("id02", "pwd02", "james2"));
        list.add(new Cust("id03", "pwd03", "james3"));
        list.add(new Cust("id04", "pwd04", "james4"));
        list.add(new Cust("id05", "pwd05", "james5"));

        // Java Object ---> JSON
        // JSON(JavaScript Object Notation)
        // [{}, {}, {}, ...]
        JSONArray ja = new JSONArray();
        for (Cust obj : list) {
            JSONObject jo = new JSONObject();
            Random r = new Random();
            int i = r.nextInt(100) + 1;
            jo.put("id", obj.getId());
            jo.put("pwd", obj.getPwd());
            jo.put("name", obj.getName() + i);
            ja.add(jo);
        }
        return ja;
    }

    @RequestMapping("/markers")
    public Object markers(String loc) {
        List<Marker> list = new ArrayList<>();

        if (loc.equals("s")) {
            list.add(new Marker(100, "국밥집", "http://www.nate.com", 37.578798, 126.978548, "e.jpg", "s"));
            list.add(new Marker(101, "짬뽕", "http://www.naver.com", 37.578746, 126.976572, "a.jpg", "s"));
            list.add(new Marker(102, "껍데기", "http://www.daum.net", 37.578712, 126.977780, "b.jpg", "s"));
        } else if (loc.equals("b")) {
            list.add(new Marker(100, "국밥집", "http://www.nate.com", 35.154574, 129.160789, "e.jpg", "b"));
            list.add(new Marker(101, "짬뽕", "http://www.naver.com", 35.158354, 129.160456, "a.jpg", "b"));
            list.add(new Marker(102, "껍데기", "http://www.daum.net", 35.158234, 129.160857, "b.jpg", "b"));

        } else if (loc.equals("j")) {
            list.add(new Marker(100, "국밥집", "http://www.nate.com", 33.361321, 126.529875, "e.jpg", "j"));
            list.add(new Marker(101, "짬뽕", "http://www.naver.com", 33.361924, 126.529215, "a.jpg", "j"));
            list.add(new Marker(102, "껍데기", "http://www.daum.net", 33.361545, 126.528123, "b.jpg", "j"));

        }

        JSONArray ja = new JSONArray();
        for (Marker obj : list) {
            JSONObject jo = new JSONObject();
            jo.put("id", obj.getId());
            jo.put("title", obj.getTitle());
            jo.put("target", obj.getTarget());
            jo.put("lat", obj.getLat());
            jo.put("lng", obj.getLng());
            jo.put("img", obj.getImg());
            jo.put("loc", obj.getLoc());
            ja.add(jo);
        }
        return ja;
    }

}
