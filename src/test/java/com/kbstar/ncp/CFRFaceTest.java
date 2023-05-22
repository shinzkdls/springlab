package com.kbstar.ncp;

import com.kbstar.util.CFRFaceUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class CFRFaceTest {
    @Value("${uploadimgdir}")
    String imgpath;

    @Autowired
    CFRFaceUtil cfrfaceUtil;

    @Test
    void contextLoads() throws ParseException {
        String imgname = "lee.jpg";
        JSONObject result = (JSONObject) cfrfaceUtil.getResult(imgpath, imgname);
        log.info(result.toJSONString());
    }

}
