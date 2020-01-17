package com.example.springboottest.mapper.smt;

import com.example.springboottest.dto.UpdateBean;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdateMapper {

    int updatequery(UpdateBean updateBean);
}
