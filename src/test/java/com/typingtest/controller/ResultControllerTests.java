package com.typingtest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import com.typingtest.service.IResultService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ResultControllerTests {

    private static final int TEST_CPM = 200;
    private static final int TEST_ACC = 100;
    private static final int TEST_TIME_VALUE = 1;
    private static final List<Integer> TEST_SCORES = new ArrayList<>();

    private MockMvc mockMvc;

    @Autowired
    private ResultController target;

    @MockBean
    private IResultService resultService;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(target).build();
        TEST_SCORES.add(100);
        TEST_SCORES.add(180);
        given(this.resultService.getAllScores()).willReturn(TEST_SCORES);
    }

    @Test
    public void testInitResultPage() throws Exception {
        mockMvc.perform(get("/show/test/result/{cpm}/{acc}/{time}", TEST_CPM, TEST_ACC, TEST_TIME_VALUE))
                .andExpect(view().name("redirect:/result?time=" + TEST_TIME_VALUE))
                .andExpect(status().is3xxRedirection());

    }

}
