package com.typingtest.controller;

import com.typingtest.po.Result;
import com.typingtest.service.IResultService;
import com.typingtest.util.ResultCalculator;
import com.typingtest.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ResultController {

    private IResultService resultService;

    public ResultController(IResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("/show/test/result/{cpm}/{acc}/{time}")
    public String processTestResult(@PathVariable Integer cpm,
                                    @PathVariable Integer acc,
                                    @PathVariable int time,
                                    RedirectAttributes redirectAttributes) {
        double percentage = -1;

        if (StringUtils.isEmpty(cpm) || StringUtils.isEmpty(acc) || StringUtils.isEmpty(time))
            throw new IllegalArgumentException();

        int currentUserScore = ResultCalculator.getScore(cpm, acc);
        List<Integer> scores = resultService.getAllScores();
        if (scores != null && scores.size() > 0) {
            percentage = ResultCalculator.getBetterThanPercentage(scores, currentUserScore);
        }

        ResultVo resultVo = new ResultVo();
        resultVo.setAccuracy(acc);
        resultVo.setCpm(cpm);
        resultVo.setTestTime(time);
        resultVo.setScore(currentUserScore);

        // keep the model data while redirecting
        redirectAttributes.addFlashAttribute("result", resultVo);
        redirectAttributes.addFlashAttribute("percentage", (int) percentage);

        Result result = new Result();
        BeanUtils.copyProperties(resultVo, result);
        resultService.saveResult(result);

        return "redirect:/result?time=" + time;
    }

    @GetMapping("/result")
    public String showResult() {
        return "result";
    }

}

