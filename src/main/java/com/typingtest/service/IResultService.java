package com.typingtest.service;

import com.typingtest.po.Result;
import java.util.List;

public interface IResultService {

    List<Integer> getAllScores();

    void saveResult(Result result);

    boolean validResult(Result result);

}
