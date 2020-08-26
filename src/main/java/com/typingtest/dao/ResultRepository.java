package com.typingtest.dao;

import com.typingtest.po.Result;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResultRepository extends CrudRepository<Result, Integer> {

    /**
     * retrieve all of the valid user scores from the data store.
     * @return a Collection of Integers(scores).
     */
    @Query("SELECT score FROM Result  WHERE status = 1 ORDER BY score")
    List<Integer> findValidScores();
}
