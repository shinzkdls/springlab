package com.kbstar.sales;

import com.kbstar.dto.Adm;
import com.kbstar.dto.Sales;
import com.kbstar.service.AdmService;
import com.kbstar.service.SalesService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.util.Date;

@Slf4j
@SpringBootTest
class InsertTest {
    @Autowired
    SalesService service;

    @Test
    void contextLoads() {
        //Adm obj = new Adm("admin04", "pwd04", 4);
        Sales obj = new Sales(new Date(), 25000, "F");
        try{
            service.register(obj);
            log.info("등록 정상");
            service.get();
        } catch (Exception e){
            log.info("에러입니다.----------------------------------------");
        }
    }
}