package com.typingtest.service.impl;

import com.typingtest.dao.ResultRepository;
import com.typingtest.po.Result;
import com.typingtest.service.IResultService;
import com.typingtest.util.ResultCalculator;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ResultServiceImpl implements IResultService {
    private final static int C0DE_VALID_RESULT = 1;
    private final static int CODE_INVALID_RESULT = 0;

    private ResultRepository results;

    public ResultServiceImpl(ResultRepository results) {
        this.results = results;
    }

    public List<Integer> getAllScores() {
        return results.findValidScores();
    }

    public void saveResult(Result result) {
        result.setCreateTime(new Date());
        if (validResult(result)) {
            result.setStatus(C0DE_VALID_RESULT);
        } else
            result.setStatus(CODE_INVALID_RESULT);
        results.save(result);
    }

    public boolean validResult(Result result) {
        return ResultCalculator.valid(result);
    }
}
