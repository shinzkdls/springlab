package com.kbstar.controller;

import com.kbstar.dto.Ncp;
import com.kbstar.util.CFRCelebrityUtil;
import com.kbstar.util.CFRFaceUtil;
import com.kbstar.util.FileUploadUtil;
import com.kbstar.util.OCRUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class NcpController {

    @Value("${uploadimgdir}")
    String imgpath;

    @RequestMapping("/crf1impl")
    public String crf1impl(Model model, Ncp ncp) throws ParseException {
        // 이미지 저장한다.
        FileUploadUtil.saveFile(ncp.getImg(), imgpath);

        // NCP에 요청한다.
        String imgname = ncp.getImg().getOriginalFilename();
        JSONObject result = (JSONObject) CFRCelebrityUtil.getResult(imgpath, imgname);
        log.info(result.toJSONString());

        JSONArray faces = (JSONArray) result.get("faces");
        JSONObject obj = (JSONObject) faces.get(0);
        JSONObject celebrity = (JSONObject) obj.get("celebrity");
        String value = (String) celebrity.get("value");


        // 결과를 받는다.
        model.addAttribute("center", "cfr1");
        model.addAttribute("result", value);

        return "index";
    }

    @RequestMapping("/crf2impl")
    public String crf2impl(Model model, Ncp ncp) throws ParseException {
        // 이미지 저장한다.
        FileUploadUtil.saveFile(ncp.getImg(), imgpath);

        // NCP에 요청한다.
        String imgname = ncp.getImg().getOriginalFilename();
        JSONObject result = (JSONObject) CFRFaceUtil.getResult(imgpath, imgname);
        log.info(result.toJSONString());

        String emotion_value = "";
        String gender_value = "";
        String pose_value = "";
        String age_value = "";

        JSONArray faces = (JSONArray) result.get("faces");
        JSONObject obj = (JSONObject) faces.get(0);

        JSONObject emotion = (JSONObject) obj.get("emotion");
        emotion_value = (String) emotion.get("value");

        JSONObject gender = (JSONObject) obj.get("gender");
        gender_value = (String) gender.get("value");

        JSONObject pose = (JSONObject) obj.get("pose");
        pose_value = (String) pose.get("value");

        JSONObject age = (JSONObject) obj.get("age");
        age_value = (String) age.get("value");

//        JSONObject values = new JSONObject();
//        values.put("emotion_value", emotion_value);
//        values.put("gender_value", gender_value);
//        values.put("pose_value", pose_value);
//        values.put("age_value", age_value);

        Map<String, String> map = new HashMap<>();
        map.put("emotion_value", emotion_value);
        map.put("gender_value", gender_value);
        map.put("pose_value", pose_value);
        map.put("age_value", age_value);

        // 결과를 받는다.
        model.addAttribute("center", "cfr2");
        model.addAttribute("result", map);

        return "index";
    }

    @RequestMapping("/mycfr")
    public String mycfr(Model model, String imgname) throws ParseException {

        // NCP에 요청한다.
        JSONObject result = (JSONObject) CFRFaceUtil.getResult(imgpath, imgname);
        log.info(result.toJSONString());

        String emotion_value = "";
        String gender_value = "";
        String pose_value = "";
        String age_value = "";

        JSONArray faces = (JSONArray) result.get("faces");
        JSONObject obj = (JSONObject) faces.get(0);

        JSONObject emotion = (JSONObject) obj.get("emotion");
        emotion_value = (String) emotion.get("value");

        JSONObject gender = (JSONObject) obj.get("gender");
        gender_value = (String) gender.get("value");

        JSONObject pose = (JSONObject) obj.get("pose");
        pose_value = (String) pose.get("value");

        JSONObject age = (JSONObject) obj.get("age");
        age_value = (String) age.get("value");

//        JSONObject values = new JSONObject();
//        values.put("emotion_value", emotion_value);
//        values.put("gender_value", gender_value);
//        values.put("pose_value", pose_value);
//        values.put("age_value", age_value);

        Map<String, String> map = new HashMap<>();
        map.put("emotion_value", emotion_value);
        map.put("gender_value", gender_value);
        map.put("pose_value", pose_value);
        map.put("age_value", age_value);

        // 결과를 받는다.
        model.addAttribute("center", "pic");
        model.addAttribute("result", map);

        return "index";
    }

    @RequestMapping("/ocr1impl")
    public String ocr1impl(Model model, Ncp ncp) throws ParseException {
        // 이미지 저장한다.
        FileUploadUtil.saveFile(ncp.getImg(), imgpath);

        // NCP에 요청한다.
        String imgname = ncp.getImg().getOriginalFilename();
        JSONObject result = (JSONObject) OCRUtil.getResult(imgpath, imgname);
        Map map = OCRUtil.getData(result);
        log.info(map.values().toString());
        // 결과를 받는다.
        model.addAttribute("center", "ocr1");
        model.addAttribute("result", map);

        return "index";
    }

    @RequestMapping("/ocr2impl")
    public String ocr2impl(Model model, Ncp ncp) throws ParseException {
        // 이미지 저장한다.
        FileUploadUtil.saveFile(ncp.getImg(), imgpath);

        // NCP에 요청한다.
        String imgname = ncp.getImg().getOriginalFilename();
        JSONObject result = (JSONObject) OCRUtil.getResult(imgpath, imgname);
        Map map = OCRUtil.getData_jiro(result);
        log.info(map.values().toString());
        // 결과를 받는다.
        model.addAttribute("center", "ocr2");
        model.addAttribute("result", map);

        return "index";
    }

}
