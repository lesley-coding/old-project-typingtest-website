package com.typingtest.service;

import static org.assertj.core.api.Assertions.*;

import com.typingtest.po.Result;
import com.typingtest.util.ResultCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
//@Commit
public class ResultServiceTests {

    private final static int TEST_CPM = 70;
    private final static int TEST_ACC = 86;
    private final static int TEST_TIME = 1;

    @Autowired
    protected IResultService resultService;

    @Test
    @Transactional
    void shouldInsertResultAndGenerateId() {
        int found = resultService.getAllScores().size();

        Result result = new Result();
        result.setCpm(TEST_CPM);
        result.setAccuracy(TEST_ACC);
        result.setTestTime(TEST_TIME);

        result.setScore(ResultCalculator.getScore(TEST_CPM, TEST_ACC));

        this.resultService.saveResult(result);
        assertThat(resultService.getAllScores().size()).isEqualTo(found + 1);
//        assertThat(resultService.getAllScores().size()).isEqualTo(found); // when insert an invalid scores;
        assertThat(result.getId()).isNotNull();
    }

    @Test
    void shouldFindValidScoresInOrder() {
        List<Integer> results = resultService.getAllScores();
        assertThat(results.size()).isEqualTo(13);
        assertThat(results.get(0)).isEqualTo(30);
        assertThat(results.get(results.size()-1)).isEqualTo(135);
    }

}
