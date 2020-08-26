package com.typingtest;

import com.typingtest.dao.ResultRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TypingtestIntegrationTests {

    @Autowired
    private ResultRepository results;

    @Test
    void contextLoads() {
    }

    @Test
    void testFindAll() {
        results.findAll();
    }

}
