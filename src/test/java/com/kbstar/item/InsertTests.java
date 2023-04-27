package com.kbstar.item;

import com.kbstar.dto.Item;
import com.kbstar.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.util.Date;

@Slf4j
@SpringBootTest
class InsertTests {
    @Autowired
    ItemService service;

    @Test
    void contextLoads() {
        Item obj = new Item(200, "티셔츠", 10000, "pwd21", new Date());
        try {
            service.register(obj);
            log.info("등록정상...");
        } catch (Exception e) {
            if (e instanceof DuplicateKeyException) {
                log.info(".....상품ID가 중복되었습니다.......");
            } else {
                log.info("......시스템장애입니다.........");
                e.printStackTrace();
            }

        }
    }
}
