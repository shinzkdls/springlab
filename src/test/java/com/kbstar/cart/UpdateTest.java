package com.kbstar.cart;

import com.kbstar.dto.Cart;
import com.kbstar.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.util.Date;

@Slf4j
@SpringBootTest
class UpdateTest {
    @Autowired
    CartService service;

    @Test
    void contextLoads() {
        Cart obj = new Cart(103, "id03", 102, 7, new Date());
        try {
            service.modify(obj);
            log.info("등록 정상");
        } catch (Exception e) {
            if (e instanceof DuplicateKeyException) {
                log.info("ID가 중복되었습니다.--------------------------------------");
            } else {
                log.info("시스템 장애입니다.----------------------------------------");
            }
        }
    }

}
